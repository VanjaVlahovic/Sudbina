/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 *
 * @author Vanja Vlahović
 */
public class StavkaRacuna implements IOpstiObjekat{

    private int rBStavke;
    private int kolicina;
    private BigDecimal vrednost;
    private Proizvod proizvod;
    private Status status;
    private Long brojRacuna;

    public StavkaRacuna() {
        this.vrednost = new BigDecimal(0);
    }

    public StavkaRacuna(int rBStavke, int kolicina, BigDecimal vrednost, Proizvod proizvod) {
        this.rBStavke = rBStavke;
        this.kolicina = kolicina;
        this.vrednost = vrednost;
        this.proizvod = proizvod;
    }

    public int getrBStavke() {
        return rBStavke;
    }

    public void setrBStavke(int rBStavke) {
        this.rBStavke = rBStavke;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public BigDecimal getVrednost() {
        return vrednost;
    }

    public void setVrednost(BigDecimal vrednost) {
        this.vrednost = vrednost;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(Long brojRacuna) {
        this.brojRacuna = brojRacuna;
    }
    
    @Override
    public String getNazivTabele() {
        return "stavka_racuna";
    }

    @Override
    public String getNaziviKolonaZaInsert() {
        return "BrojRacuna, Kolicina, Vrednost, SifraProizvoda";
    }

    @Override
    public void setSifra(Long sifra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IOpstiObjekat napuniObjekat(ResultSet resultSet, Object lista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String joinUslov() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNaziviKolonaZaSelect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereUslov() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getVrednostiZaUpdate() {
        return " kolicina=" +kolicina;
    }

    @Override
    public String getWhereUpdateUslov() {
        return " RBStavke = "+rBStavke+" AND BrojRacuna = "+brojRacuna;
    }

    @Override
    public String getVrednostiZaInsert() {
        return brojRacuna+", "+kolicina+", "+vrednost+", "+proizvod.getSifra();
    }

    @Override
    public Long getSifra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
         return "ORDER BY RBStavke ASC";
    }

    @Override
    public String getWhereDeleteUslovAsocijacije(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
