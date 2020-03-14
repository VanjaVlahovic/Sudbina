/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Konobar;
import domain.Proizvod;
import domain.Racun;
import domain.Rezervacija;
import domain.Sto;
import domain.TipProizvoda;
import java.util.List;
import so.AbstractOpstaOperacija;
import so.Prijava;
import so.proizvod.KreirajProizvod;
import so.racun.KreirajRacun;       
import so.rezervacija.KreirajRezervaciju;
import so.proizvod.VratiProizvode;
import so.rezervacija.VratiStolove;
import so.proizvod.VratiTipoveProizvoda;
import so.proizvod.ZapamtiProizvod;
import so.racun.StornirajRacun;
import so.racun.VratiRacune;
import so.racun.ZapamtiRacun;
import so.rezervacija.ObrisiRezervaciju;
import so.rezervacija.VratiRezervacije;
import so.rezervacija.ZapamtiRezervaciju;

/**
 *
 * @author Vanja Vlahović
 */
public class Controller {
    private static Controller instance;

    public Controller() {
    }

    public static Controller getInstance() {
        if (instance==null)
            instance = new Controller();
        return instance;
    }

    public Konobar prijava(Konobar konobar) throws Exception {
        AbstractOpstaOperacija prijava = new Prijava();
        return (Konobar) prijava.izvrsi(konobar);
    }

    public List<TipProizvoda> vratiTipoveProizvoda() throws Exception {
        AbstractOpstaOperacija vratiTipoveProizvoda = new VratiTipoveProizvoda();
        return (List<TipProizvoda>) vratiTipoveProizvoda.izvrsi(new TipProizvoda());
    }

    public Proizvod kreirajProizvod() throws Exception {
        AbstractOpstaOperacija kreirajProizvod = new KreirajProizvod();
        return  (Proizvod) kreirajProizvod.izvrsi(new Proizvod());
    }

    public Racun kreirajRacun() throws Exception {
        AbstractOpstaOperacija kreirajRacun = new KreirajRacun();
        return  (Racun) kreirajRacun.izvrsi(new Racun());
    }

    public Rezervacija kreirajRezervaciju() throws Exception {
        AbstractOpstaOperacija kreirajRezervaciju = new KreirajRezervaciju();
        return  (Rezervacija) kreirajRezervaciju.izvrsi(new Rezervacija());
    }

    public List<Proizvod> vratiProizvode() throws Exception {
        AbstractOpstaOperacija vratiProizvode = new VratiProizvode();
        return (List<Proizvod>) vratiProizvode.izvrsi(new Proizvod());
    }

    public List<Sto> vratiStolove(Sto sto) throws Exception {
        AbstractOpstaOperacija vratiStolove = new VratiStolove();
        return (List<Sto>) vratiStolove.izvrsi(sto);
    }

    public Proizvod zapamtiProizvod(Proizvod proizvod) throws Exception {
        AbstractOpstaOperacija zapamtiProizvod = new ZapamtiProizvod();
        return (Proizvod) zapamtiProizvod.izvrsi(proizvod);
    }

    public Racun zapamtiRacun(Racun racun) throws Exception {
        AbstractOpstaOperacija zapamtiRacun = new ZapamtiRacun();
        return (Racun) zapamtiRacun.izvrsi(racun);
    }

    public Rezervacija zapamtiRezervaciju(Rezervacija rezervacija) throws Exception {
        AbstractOpstaOperacija zapamtiRezervaciju = new ZapamtiRezervaciju();
        return (Rezervacija) zapamtiRezervaciju.izvrsi(rezervacija);
    }

    public List<Rezervacija> vratiRezervacije(Rezervacija r) throws Exception {
        AbstractOpstaOperacija vratiRezervacije  = new VratiRezervacije();
        return (List<Rezervacija>) vratiRezervacije.izvrsi(r);
    }

    public List<Racun> vratiRacune(Racun r) throws Exception {
        AbstractOpstaOperacija vratiRacune = new VratiRacune();
        return (List<Racun>) vratiRacune.izvrsi(r);
    }

    public Racun stornirajRacun(Racun racun) throws Exception {
        AbstractOpstaOperacija stornirajRacun  = new StornirajRacun();
        return (Racun) stornirajRacun.izvrsi(racun);
    }
    
    public Rezervacija obrisiRezervaciju(Rezervacija rezervacija) throws Exception {
        AbstractOpstaOperacija obrisiRezervaciju = new ObrisiRezervaciju();
        return (Rezervacija) obrisiRezervaciju.izvrsi(rezervacija);
    }
    
}
