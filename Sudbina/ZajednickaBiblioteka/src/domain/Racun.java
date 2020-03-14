/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vanja Vlahović
 */
public class Racun implements IOpstiObjekat {

    private Long sifra;
    private Date vreme;
    private Konobar konobar;
    private BigDecimal ukupnaVrednost;
    private boolean storniran;
    private List<StavkaRacuna> stavkeRacuna;
    private List<Sto> stolovi;

    public Racun() {
        this.stavkeRacuna = new ArrayList<>();
        this.stolovi = new ArrayList<>();
        this.ukupnaVrednost = new BigDecimal(0);
    }

    public Racun(Long sifra, Date vreme, Konobar konobar, BigDecimal ukupnaVrednost, boolean storniran) {
        this.sifra = sifra;
        this.vreme = vreme;
        this.konobar = konobar;
        this.ukupnaVrednost = ukupnaVrednost;
        this.storniran = storniran;
        this.stavkeRacuna = new ArrayList<>();
        this.stolovi = new ArrayList<>();
    }

    public Long getSifra() {
        return sifra;
    }

    @Override
    public void setSifra(Long sifra) {
        this.sifra = sifra;
    }

    public Date getVreme() {
        return vreme;
    }

    public void setVreme(Date vreme) {
        this.vreme = vreme;
    }

    public Konobar getKonobar() {
        return konobar;
    }

    public void setKonobar(Konobar konobar) {
        this.konobar = konobar;
    }

    public BigDecimal getUkupnaVrednost() {
        return ukupnaVrednost;
    }

    public void setUkupnaVrednost(BigDecimal ukupnaVrednost) {
        this.ukupnaVrednost = ukupnaVrednost;
    }

    public boolean isStorniran() {
        return storniran;
    }

    public void setStorniran(boolean storniran) {
        this.storniran = storniran;
    }

    public List<StavkaRacuna> getStavkeRacuna() {
        return stavkeRacuna;
    }

    public void setStavkeRacuna(List<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
    }

    public List<Sto> getStolovi() {
        return stolovi;
    }

    public void setStolovi(List<Sto> stolovi) {
        this.stolovi = stolovi;
    }

    @Override
    public String getNazivTabele() {
        return " racun ";
    }

    @Override
    public String getNaziviKolonaZaInsert() {
        return " Vreme, KonobarID, UkupnaVrednost, Storniran";
    }

    @Override
    public String getVrednostiZaInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(vreme).append("',")
                .append(konobar.getSifra()).append(",")
                .append(ukupnaVrednost).append(",")
                .append(storniran);

        return sb.toString();
    }

    @Override
    public Racun napuniObjekat(ResultSet resultSet, Object stolovi) {
        Racun r = new Racun();
        try {
            r.setSifra(resultSet.getLong(1));
            r.setVreme(resultSet.getDate(2));
            r.setKonobar(new Konobar(resultSet.getLong(11), resultSet.getString(12), resultSet.getString(13), resultSet.getString(16), resultSet.getString(17), resultSet.getString(14), resultSet.getString(15)));
            r.setUkupnaVrednost(resultSet.getBigDecimal(4));
            r.setStorniran(resultSet.getBoolean(5));
            int brojRedova = resultSet.getInt(26);
            r.setStolovi((List<Sto>) stolovi);
            for (int i = 0; i < brojRedova; i++) {
                StavkaRacuna sr = new StavkaRacuna();
                sr.setrBStavke(resultSet.getInt(7));
                sr.setKolicina(resultSet.getInt(8));
                sr.setVrednost(resultSet.getBigDecimal(9));
                sr.setBrojRacuna(r.getSifra());
                sr.setProizvod(new Proizvod(resultSet.getLong(18), resultSet.getString(19), resultSet.getBigDecimal(20), resultSet.getString(21), resultSet.getString(22), new TipProizvoda(resultSet.getLong(24), resultSet.getString(25))));
                r.getStavkeRacuna().add(sr);
                if (i == brojRedova - 1) {
                    return r;
                }
                resultSet.next();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return r;
    }

    @Override
    public String joinUslov() {
        return "LEFT JOIN stavka_racuna ON (stavka_racuna.brojRacuna = racun.brojRacuna) "
                + " LEFT JOIN konobar k ON (racun.konobarID=k.konobarID) "
                + " LEFT JOIN proizvod p ON (stavka_racuna.sifraproizvoda = p.sifraproizvoda) "
                + " LEFT JOIN tip_proizvoda tp ON (p.tipid=tp.id)";
    }

    @Override
    public String getNaziviKolonaZaSelect() {
        return " *, (SELECT COUNT(sr.rbstavke) FROM stavka_racuna sr JOIN racun r1 ON (sr.brojracuna=r1.brojracuna) WHERE sr.brojRacuna=racun.brojRacuna GROUP BY sr.brojRacuna) ";
    }

    @Override
    public String getWhereUslov() {
        if (konobar!=null && !konobar.getIme().isEmpty()) {
            if (vreme != null) {
                return " WHERE (k.ime LIKE '" + konobar.getIme() + "%' OR k.prezime LIKE '" + konobar.getIme() + "%') "
                        + " AND racun.vreme='" + new java.sql.Date(vreme.getTime()) + "'";
            } else {
                return " WHERE (k.ime LIKE '" + konobar.getIme() + "%' OR k.prezime LIKE '" + konobar.getIme() + "%') ";
            }
        } else {
            if (vreme != null) {
                return " WHERE racun.vreme='" + new java.sql.Date(vreme.getTime()) + "' ";
            } else {
                return "";
            }
        }
    }

    @Override
    public String getVrednostiZaUpdate() {
        return "Vreme='" + new java.sql.Date(vreme.getTime()) + "', KonobarID=" + konobar.getSifra() + ", UkupnaVrednost=" + ukupnaVrednost + ", Storniran=" + storniran;
    }

    @Override
    public String getWhereUpdateUslov() {
        return "brojRacuna=" + sifra;
    }

    @Override
    public String getNazivTabeleAsocijacije() {
        return " racun_za_sto ";
    }

    @Override
    public String getNaziviKolonaZaInsertAsocijacije() {
        return " SifraStola, BrojRacuna ";
    }

    @Override
    public String getVrednostiZaInsertAsocijacije(int i) {
        return stolovi.get(i).getSifra() + ", " + sifra;
    }

    @Override
    public String getNaziviKolonaZaSelectAsocijacije() {
        return "*";
    }

    @Override
    public IOpstiObjekat napuniObjekatAsocijacije(ResultSet rs) {
        Sto s = new Sto();
        try {
            s.setSifra(rs.getLong(3));
            s.setNaziv(rs.getString(4));
            s.setBrojMesta(rs.getInt(5));
        } catch (SQLException ex) {
            Logger.getLogger(Racun.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    @Override
    public String joinUslovAsocijacije() {
        return "LEFT JOIN sto ON (racun_za_sto.sifrastola=sto.sifrastola)";
    }

    @Override
    public String getWhereUslovAsocijacije() {
        return "WHERE racun_za_sto.brojracuna=";
    }

    @Override
    public boolean imaAsocijaciju() {
        return true;
    }

    @Override
    public String getOrderByUslov() {
         return "ORDER BY racun.BrojRacuna ASC";
    }

    @Override
    public String getWhereDeleteUslovAsocijacije(int i) {
        return " racun_za_sto.brojracuna= "+sifra+" AND racun_za_sto.sifrastola="+stolovi.get(i).getSifra();
    }

}
