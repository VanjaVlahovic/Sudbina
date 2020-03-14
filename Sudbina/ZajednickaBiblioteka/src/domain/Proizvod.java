/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vanja Vlahović
 */
public class Proizvod implements IOpstiObjekat{

    private Long sifra;
    private String naziv;
    private BigDecimal cena;
    private String proizvodjac;
    private String velicina;
    private TipProizvoda tipProizvoda;

    public Proizvod() {
        cena = new BigDecimal(0);
    }

    public Proizvod(Long sifra, String naziv, BigDecimal cena, String proizvodjac, String velicina, TipProizvoda tipProizvoda) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.cena = cena;
        this.proizvodjac = proizvodjac;
        this.velicina = velicina;
        this.tipProizvoda = tipProizvoda;
    }

    public Long getSifra() {
        return sifra;
    }

    @Override
    public void setSifra(Long sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getVelicina() {
        return velicina;
    }

    public void setVelicina(String velicina) {
        this.velicina = velicina;
    }

    public TipProizvoda getTipProizvoda() {
        return tipProizvoda;
    }

    public void setTipProizvoda(TipProizvoda tipProizvoda) {
        this.tipProizvoda = tipProizvoda;
    }

    @Override
    public String getNazivTabele() {
        return " proizvod ";
    }

    @Override
    public String getNaziviKolonaZaInsert() {
        return " naziv, cena, proizvodjac, velicina, tipID ";
    }

    @Override
    public String getVrednostiZaInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(naziv).append("',")
                .append(cena).append(",")
                .append("'").append(proizvodjac).append("',")
                .append("'").append(velicina).append("',")
                .append(tipProizvoda.getSifra());
                
        return sb.toString();
    }

    @Override
    public Proizvod napuniObjekat(ResultSet resultSet,Object lista) {
        Proizvod p = new Proizvod();
        try {
            p.setSifra(resultSet.getLong(1));
            p.setNaziv(resultSet.getString(2));
            p.setCena(resultSet.getBigDecimal(3));
            p.setProizvodjac(resultSet.getString(4));
            p.setVelicina(resultSet.getString(5));
            p.setTipProizvoda(new TipProizvoda(resultSet.getLong(6), resultSet.getString(7)));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    @Override
    public String joinUslov() {
        return " INNER JOIN tip_proizvoda t ON (proizvod.tipID = t.ID) ";
    }

    @Override
    public String getNaziviKolonaZaSelect() {
        return " proizvod.SifraProizvoda, proizvod.Naziv, proizvod.Cena, proizvod.Proizvodjac, proizvod.Velicina, proizvod.TipID, t.Naziv";
    }


    @Override
    public String getWhereUslov() {
        return "";
    }

    @Override
    public String getVrednostiZaUpdate() {
        return "Naziv ='"+naziv+"', Cena ="+cena+", Proizvodjac='"+proizvodjac+"', Velicina="+velicina+", TipID="+tipProizvoda.getSifra();
    }

    @Override
    public String getWhereUpdateUslov() {
        return " SifraProizvoda = "+sifra;
    }

    @Override
    public String getNazivTabeleAsocijacije() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNaziviKolonaZaInsertAsocijacije() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getVrednostiZaInsertAsocijacije(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNaziviKolonaZaSelectAsocijacije() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IOpstiObjekat napuniObjekatAsocijacije(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String joinUslovAsocijacije() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereUslovAsocijacije() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean imaAsocijaciju() {
        return false;
    }

    @Override
    public String getOrderByUslov() {
         return " ORDER BY tipID ASC";
    }

    @Override
    public String getWhereDeleteUslovAsocijacije(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
