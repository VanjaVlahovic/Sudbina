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
public class Konobar implements IOpstiObjekat {

    private Long sifra;
    private String korisnickoIme;
    private String sifraK;
    private String ime;
    private String prezime;
    private String email;
    private String telefon;

    public Konobar() {
    }

    public Konobar(Long sifra, String korisnickoIme, String sifraK, String ime, String prezime, String email, String telefon) {
        this.sifra = sifra;
        this.korisnickoIme = korisnickoIme;
        this.sifraK = sifraK;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.telefon = telefon;
    }

    public Long getSifra() {
        return sifra;
    }

    @Override
    public void setSifra(Long sifra) {
        this.sifra = sifra;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifraK() {
        return sifraK;
    }

    public void setSifraK(String sifraK) {
        this.sifraK = sifraK;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String getNazivTabele() {
        return "konobar";
    }

    @Override
    public String getNaziviKolonaZaInsert() {
        return " KorisnickoIme, Sifra, E-mail, Telefon, Ime, Prezime ";
    }

    @Override
    public String getVrednostiZaInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(korisnickoIme).append("',")
                .append("'").append(sifraK).append("',")
                .append("'").append(email).append("',")
                .append("'").append(telefon).append("',")
                .append("'").append(ime).append("',")
                .append("'").append(prezime).append("'");

        return sb.toString();
    }

    @Override
    public Konobar napuniObjekat(ResultSet resultSet, Object lista) {
        try {
            sifra = resultSet.getLong(1);
            korisnickoIme = resultSet.getString(2);
            sifraK = resultSet.getString(3);
            email = resultSet.getString(4);
            telefon = resultSet.getString(5);
            ime = resultSet.getString(6);
            prezime = resultSet.getString(7);
            return this;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
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
        return " WHERE korisnickoIme='"+korisnickoIme+"' AND sifra='"+sifraK+"'";
    }

    @Override
    public String getVrednostiZaUpdate() {
        return "";
    }

    @Override
    public String getWhereUpdateUslov() {
        return "";
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
        return "ORDER BY Ime ASC";
    }

    @Override
    public String getWhereDeleteUslovAsocijacije(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
