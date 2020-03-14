/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Vanja Vlahović
 */
public class TipProizvoda implements IOpstiObjekat{

    private Long sifra;
    private String naziv;

    public TipProizvoda() {
    }

    public TipProizvoda(Long sifra, String naziv) {
        this.sifra = sifra;
        this.naziv = naziv;
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

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String getNazivTabele() {
        return "tip_proizvoda";
    }

    @Override
    public String getNaziviKolonaZaInsert() {
        return " Naziv";
    }

    @Override
    public String getVrednostiZaInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(naziv).append("'");
            
        return sb.toString();
    }

    @Override
    public TipProizvoda napuniObjekat(ResultSet resultSet, Object lista) {
        TipProizvoda tip = new TipProizvoda();
        try {
            tip.setSifra(resultSet.getLong(1));
            tip.setNaziv(resultSet.getString(2));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tip;
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
        return "";
    }

    @Override
    public String getVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereUpdateUslov() {
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
         return " ORDER BY ID ASC";
    }

    @Override
    public String getWhereDeleteUslovAsocijacije(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
