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
public class Sto implements IOpstiObjekat{
    private Long sifra;
    private String naziv;
    private int brojMesta;
    private List<Date> datumi;
    private Status status;

    public Sto() {
        this.datumi = new ArrayList<>();
    }

    public Sto(Long sifra, String naziv, int brojMesta) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.brojMesta = brojMesta;
        this.datumi = new ArrayList<>();
        
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

    public int getBrojMesta() {
        return brojMesta;
    }

    public void setBrojMesta(int brojMesta) {
        this.brojMesta = brojMesta;
    }

    public List<Date> getDatumi() {
        return datumi;
    }

    public void setDatumi(List<Date> datumi) {
        this.datumi = datumi;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Sto){
            Sto s = (Sto) obj;
            if(s.getNaziv().equals(naziv))
                return true;
        }
        return false;
    }
    
    

    @Override
    public String getNazivTabele() {
        return " sto ";
    }

    @Override
    public String getNaziviKolonaZaInsert() {
        return " Naziv, BrojMesta ";
    }

    @Override
    public String getVrednostiZaInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(naziv).append("'")
            .append(brojMesta);

        return sb.toString();
    }

    @Override
    public Sto napuniObjekat(ResultSet resultSet, Object lista) {
        Sto s = new Sto();
        try {
            s.setSifra(resultSet.getLong(1));
            s.setNaziv(resultSet.getString(2));
            s.setBrojMesta(resultSet.getInt(3));
        } catch (SQLException ex) {
            Logger.getLogger(Sto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
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
        if(!datumi.isEmpty()){
            return "WHERE sifraStola NOT IN (SELECT sifraStola FROM rezervacija_za_sto WHERE Vreme='"+new java.sql.Date(datumi.get(0).getTime())+"')";
        }
        else return "";
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
         return "ORDER BY Naziv ASC";
    }

    @Override
    public String getWhereDeleteUslovAsocijacije(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
