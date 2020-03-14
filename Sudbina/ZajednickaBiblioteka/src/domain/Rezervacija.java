/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
public class Rezervacija implements IOpstiObjekat{
    private Long sifra;
    private String naIme;
    private int brojMesta;
    private Date vreme;
    private String napomena;
    private List<Sto> stolovi;

    public Rezervacija() {
        this.stolovi = new ArrayList<>();
    }

    public Rezervacija(Long sifra, String naIme, int brojMesta, Date vreme, String napomena) {
        this.sifra = sifra;
        this.naIme = naIme;
        this.brojMesta = brojMesta;
        this.vreme = vreme;
        this.napomena = napomena;
        this.stolovi = new ArrayList<>();
    }

    public Long getSifra() {
        return sifra;
    }

    @Override
    public void setSifra(Long sifra) {
        this.sifra = sifra;
    }

    public String getNaIme() {
        return naIme;
    }

    public void setNaIme(String naIme) {
        this.naIme = naIme;
    }

    public int getBrojMesta() {
        return brojMesta;
    }

    public void setBrojMesta(int brojMesta) {
        this.brojMesta = brojMesta;
    }

    public Date getVreme() {
        return vreme;
    }

    public void setVreme(Date vreme) {
        this.vreme = vreme;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public List<Sto> getStolovi() {
        return stolovi;
    }

    public void setStolovi(List<Sto> stolovi) {
        this.stolovi = stolovi;
    }

    @Override
    public String getNazivTabele() {
        return " rezervacija ";
    }

    @Override
    public String getNaziviKolonaZaInsert() {
        return " NaIme, BrojMesta, Vreme, Napomena ";
    }

    @Override
    public String getVrednostiZaInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(naIme).append("',")
            .append(brojMesta).append(",")
            .append("'").append(vreme).append("',")
            .append("'").append(napomena).append("'");

        return sb.toString();
    }

    @Override
    public Rezervacija napuniObjekat(ResultSet resultSet, Object lista) {
        Rezervacija r = new Rezervacija();
        try {
            r.setSifra(resultSet.getLong(1));
            r.setNaIme(resultSet.getString(2));
            r.setBrojMesta(resultSet.getInt(3));
            r.setVreme(resultSet.getDate(4));
            r.setNapomena(resultSet.getString(5));
            r.setStolovi((List<Sto>) lista);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return r;
    }

    @Override
    public String joinUslov() {
        return ""; 
    }

    @Override
    public String getNaziviKolonaZaSelect() {
        return " * ";
    }

    @Override
    public String getWhereUslov() {
        if (naIme!=null && !naIme.isEmpty()) {
            if (vreme != null) {
                return " WHERE rezervacija.naime LIKE '" + naIme + "%' "
                        + " AND rezervacija.vreme='" + new java.sql.Date(vreme.getTime()) + "'";
            } else {
                return " WHERE rezervacija.naime LIKE '" + naIme + "%'";
            }
        } else {
            if (vreme != null) {
                return " WHERE rezervacija.vreme='" + new java.sql.Date(vreme.getTime()) + "' ";
            } else {
                return "";
            }
        }
    }

    @Override
    public String getVrednostiZaUpdate() {
        return "NaIme='"+naIme+"', BrojMesta="+brojMesta+", Vreme='"+new java.sql.Date(vreme.getTime())+"', Napomena='"+napomena+"' ";
    }

    @Override
    public String getWhereUpdateUslov() {
        return "SifraRezervacije="+sifra;
    }

    @Override
    public String getNazivTabeleAsocijacije() {
        return " rezervacija_za_sto ";
    }

    @Override
    public String getNaziviKolonaZaInsertAsocijacije() {
        return " SifraRezervacije, SifraStola, Vreme ";
    }

    @Override
    public String getVrednostiZaInsertAsocijacije(int i) {
        return sifra+", "+stolovi.get(i).getSifra()+", '"+new java.sql.Date(vreme.getTime())+"'";
    }

    @Override
    public String getNaziviKolonaZaSelectAsocijacije() {
        return "*";
    }

    @Override
    public IOpstiObjekat napuniObjekatAsocijacije(ResultSet rs) {
       Sto s = new Sto();
        try {
            s.setSifra(rs.getLong(4));
            s.setNaziv(rs.getString(5));
            s.setBrojMesta(rs.getInt(6));
        } catch (SQLException ex) {
            Logger.getLogger(Racun.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    @Override
    public String joinUslovAsocijacije() {
       return "LEFT JOIN sto ON (rezervacija_za_sto.sifrastola=sto.sifrastola)";
    }

    @Override
    public String getWhereUslovAsocijacije() {
        return "WHERE rezervacija_za_sto.SifraRezervacije=";
    }

    @Override
    public boolean imaAsocijaciju() {
        return true;
    }

    @Override
    public String getOrderByUslov() {
         return " ORDER BY rezervacija.naIme ASC";
    }

    @Override
    public String getWhereDeleteUslovAsocijacije(int i) {
        return " rezervacija_za_sto.SifraRezervacije= "+sifra +" AND rezervacija_za_sto.sifrastola="+stolovi.get(i).getSifra();
    }

    
}
