/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import controller.Controller;
import domain.Konobar;
import domain.Proizvod;
import domain.Racun;
import domain.Rezervacija;
import domain.Sto;
import domain.TipProizvoda;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import transfer.OdgovorObjekat;
import transfer.ZahtevObjekat;
import util.Operacija;
import util.StatusOdgovora;

/**
 *
 * @author Vanja Vlahović
 */
public class KlijentskaNit extends Thread {

    private final Socket socket;
    private final ObjectInputStream objectInputStream;
    private final ObjectOutputStream objectOutputStream;

    private Konobar prijavljenKonobar;

    public KlijentskaNit(Socket socket) throws IOException {
        this.socket = socket;
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
    }

    public Socket getSocket() {
        return socket;
    }

    public Konobar getPrijavljenKonobar() {
        return prijavljenKonobar;
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
            try {
                ZahtevObjekat zahtevObjekat = (ZahtevObjekat) objectInputStream.readObject();
                OdgovorObjekat odgovorObjekat = handleRequest(zahtevObjekat);
                objectOutputStream.writeObject(odgovorObjekat);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                try {
                    socket.close();
                } catch (IOException ex1) {
                    System.out.println(ex1.getMessage());
                }
                return;
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getException());
            }
        }
    }

    private OdgovorObjekat handleRequest(ZahtevObjekat zahtevObjekat) {
        int operacija = zahtevObjekat.getOperacija();
        switch (operacija) {
            case Operacija.OPERACIJA_PRIJAVA:
                return prijava((Konobar) zahtevObjekat.getPodaci());
            case Operacija.OPERACIJA_VRATI_TIPOVE_PROIZVODA:
                return vratiTipoveProizvoda();
            case Operacija.OPERACIJA_KREIRAJ_PROIZVOD:
                return kreirajProizvod();
            case Operacija.OPERACIJA_KREIRAJ_RACUN:
                return kreiraRacun();
            case Operacija.OPERACIJA_KREIRAJ_REZERVACIJU:
                return kreirajRezervaciju();
            case Operacija.OPERACIJA_VRATI_PROIZVODE:
                return vratiProizvode();
            case Operacija.OPERACIJA_VRATI_STOLOVE:
                return vratiStolove(zahtevObjekat.getPodaci());
            case Operacija.OPERACIJA_ZAPAMTI_PROIZVOD:
                return zapamtiProizvod((Proizvod) zahtevObjekat.getPodaci());
            case Operacija.OPERACIJA_ZAPAMTI_RACUN:
                return zapamtiRacun((Racun) zahtevObjekat.getPodaci());
            case Operacija.OPERACIJA_ZAPAMTI_REZERVACIJU:
                return zapamtiRezervaciju((Rezervacija) zahtevObjekat.getPodaci());
            case Operacija.OPERACIJA_VRATI_REZERVACIJE:
                return vratiRezervacije((Rezervacija) zahtevObjekat.getPodaci());
            case Operacija.OPERACIJA_PRETRAZI_RACUNE:
                return vratiRacune((Racun) zahtevObjekat.getPodaci());
            case Operacija.OPERACIJA_PROMENI_RACUN:
                return promeniRacun((Racun) zahtevObjekat.getPodaci());
            case Operacija.OPERACIJA_PROMENI_REZERVACIJU:
                return promeniRezervaciju((Rezervacija) zahtevObjekat.getPodaci());
            case Operacija.OPERACIJA_STORNIRAJ_RACUN:
                return stornirajRacun((Racun) zahtevObjekat.getPodaci());
            case Operacija.OPERACIJA_OBRISI_REZERVACIJU:
                return obrisiRezervaciju((Rezervacija) zahtevObjekat.getPodaci());
        }
        return null;
    }

    private OdgovorObjekat prijava(Konobar konobar) {
        OdgovorObjekat odgovor = new OdgovorObjekat();
        try {
            Konobar k = Controller.getInstance().prijava(konobar);
            System.out.println(k.toString());
            odgovor.setStatus(StatusOdgovora.USPESNO);
            odgovor.setPodaci(k);
        } catch (Exception ex) {
            odgovor.setStatus(StatusOdgovora.GRESKA);
            odgovor.setPorukaGreska(ex.getMessage());
            System.out.println(ex.getMessage());
        }
        return odgovor;
    }

    private OdgovorObjekat vratiTipoveProizvoda() {
        OdgovorObjekat odgovor = new OdgovorObjekat();
        try {
            List<TipProizvoda> tipovi = Controller.getInstance().vratiTipoveProizvoda();
            odgovor.setStatus(StatusOdgovora.USPESNO);
            odgovor.setPodaci(tipovi);
        } catch (Exception ex) {
            odgovor.setStatus(StatusOdgovora.GRESKA);
            odgovor.setPorukaGreska(ex.getMessage());
            System.out.println(ex.getMessage());
        }
        return odgovor;
    }

    private OdgovorObjekat kreirajProizvod() {
        OdgovorObjekat odgovor = new OdgovorObjekat();
        try {
            Proizvod proizvod = Controller.getInstance().kreirajProizvod();
            odgovor.setStatus(StatusOdgovora.USPESNO);
            odgovor.setPodaci(proizvod.getSifra());
        } catch (Exception ex) {
            odgovor.setStatus(StatusOdgovora.GRESKA);
            odgovor.setPorukaGreska(ex.getMessage());
            System.out.println(ex.getMessage());
        }
        return odgovor;
    }

    private OdgovorObjekat kreiraRacun() {
        OdgovorObjekat odgovor = new OdgovorObjekat();
        try {
            Racun racun = Controller.getInstance().kreirajRacun();
            odgovor.setStatus(StatusOdgovora.USPESNO);
            odgovor.setPodaci(racun.getSifra());
        } catch (Exception ex) {
            odgovor.setStatus(StatusOdgovora.GRESKA);
            odgovor.setPorukaGreska(ex.getMessage());
            System.out.println(ex.getMessage());
        }
        return odgovor;
    }

    private OdgovorObjekat kreirajRezervaciju() {
        OdgovorObjekat odgovor = new OdgovorObjekat();
        try {
            Rezervacija rezervacija = Controller.getInstance().kreirajRezervaciju();
            odgovor.setStatus(StatusOdgovora.USPESNO);
            odgovor.setPodaci(rezervacija.getSifra());
        } catch (Exception ex) {
            odgovor.setStatus(StatusOdgovora.GRESKA);
            odgovor.setPorukaGreska(ex.getMessage());
            System.out.println(ex.getMessage());
        }
        return odgovor;
    }

    private OdgovorObjekat vratiProizvode() {
        OdgovorObjekat odgovor = new OdgovorObjekat();
        try {
            List<Proizvod> proizvodi = Controller.getInstance().vratiProizvode();
            odgovor.setStatus(StatusOdgovora.USPESNO);
            odgovor.setPodaci(proizvodi);
        } catch (Exception ex) {
            odgovor.setStatus(StatusOdgovora.GRESKA);
            odgovor.setPorukaGreska(ex.getMessage());
            System.out.println(ex.getMessage());
        }
        return odgovor;
    }

    private OdgovorObjekat vratiStolove(Object vreme) {
        OdgovorObjekat odgovor = new OdgovorObjekat();
        try {
            Sto s = new Sto();
            if (vreme != null) {
                s.getDatumi().add((Date) vreme);
            }
            List<Sto> stolovi = Controller.getInstance().vratiStolove(s);
            odgovor.setStatus(StatusOdgovora.USPESNO);
            odgovor.setPodaci(stolovi);
        } catch (Exception ex) {
            odgovor.setStatus(StatusOdgovora.GRESKA);
            odgovor.setPorukaGreska(ex.getMessage());
            System.out.println(ex.getMessage());
        }
        return odgovor;
    }

    private OdgovorObjekat zapamtiProizvod(Proizvod proizvod) {
        OdgovorObjekat odgovor = new OdgovorObjekat();
        try {
            Proizvod p = Controller.getInstance().zapamtiProizvod(proizvod);
            odgovor.setStatus(StatusOdgovora.USPESNO);
            odgovor.setPodaci(p);
        } catch (Exception ex) {
            odgovor.setStatus(StatusOdgovora.GRESKA);
            odgovor.setPorukaGreska(ex.getMessage());
            System.out.println(ex.getMessage());
        }
        return odgovor;
    }

    private OdgovorObjekat zapamtiRacun(Racun racun) {
        OdgovorObjekat odgovor = new OdgovorObjekat();
        try {
            Racun r = Controller.getInstance().zapamtiRacun(racun);
            odgovor.setStatus(StatusOdgovora.USPESNO);
            odgovor.setPodaci(r);
        } catch (Exception ex) {
            odgovor.setStatus(StatusOdgovora.GRESKA);
            odgovor.setPorukaGreska(ex.getMessage());
            System.out.println(ex.getMessage());
        }
        return odgovor;
    }

    private OdgovorObjekat zapamtiRezervaciju(Rezervacija rezervacija) {
        OdgovorObjekat odgovor = new OdgovorObjekat();
        try {
            Rezervacija r = Controller.getInstance().zapamtiRezervaciju(rezervacija);
            odgovor.setStatus(StatusOdgovora.USPESNO);
            odgovor.setPodaci(r);
        } catch (Exception ex) {
            odgovor.setStatus(StatusOdgovora.GRESKA);
            odgovor.setPorukaGreska(ex.getMessage());
            System.out.println(ex.getMessage());
        }
        return odgovor;
    }

    private OdgovorObjekat vratiRezervacije(Rezervacija rezervacija) {
        OdgovorObjekat odgovor = new OdgovorObjekat();
        try {
            List<Rezervacija> rezervacije = Controller.getInstance().vratiRezervacije(rezervacija);
            odgovor.setStatus(StatusOdgovora.USPESNO);
            odgovor.setPodaci(rezervacije);
        } catch (Exception ex) {
            odgovor.setStatus(StatusOdgovora.GRESKA);
            odgovor.setPorukaGreska(ex.getMessage());
            System.out.println(ex.getMessage());
        }
        return odgovor;
    }

    private OdgovorObjekat vratiRacune(Racun racun) {
        OdgovorObjekat odgovor = new OdgovorObjekat();
        try {
            List<Racun> racuni = Controller.getInstance().vratiRacune(racun);
            odgovor.setStatus(StatusOdgovora.USPESNO);
            odgovor.setPodaci(racuni);
        } catch (Exception ex) {
            odgovor.setStatus(StatusOdgovora.GRESKA);
            odgovor.setPorukaGreska(ex.getMessage());
            System.out.println(ex.getMessage());
        }
        return odgovor;
    }

    private OdgovorObjekat promeniRacun(Racun racun) {
        OdgovorObjekat odgovor = new OdgovorObjekat();
        try {
            Racun r = Controller.getInstance().zapamtiRacun(racun);
            odgovor.setStatus(StatusOdgovora.USPESNO);
            odgovor.setPodaci(r);
        } catch (Exception ex) {
            odgovor.setStatus(StatusOdgovora.GRESKA);
            odgovor.setPorukaGreska(ex.getMessage());
            System.out.println(ex.getMessage());
        }
        return odgovor;
    }

    private OdgovorObjekat promeniRezervaciju(Rezervacija rezervacija) {
        OdgovorObjekat odgovor = new OdgovorObjekat();
        try {
            Rezervacija r = Controller.getInstance().zapamtiRezervaciju(rezervacija);
            odgovor.setStatus(StatusOdgovora.USPESNO);
            odgovor.setPodaci(r);
        } catch (Exception ex) {
            odgovor.setStatus(StatusOdgovora.GRESKA);
            odgovor.setPorukaGreska(ex.getMessage());
            System.out.println(ex.getMessage());
        }
        return odgovor;
    }

    private OdgovorObjekat stornirajRacun(Racun racun) {
        OdgovorObjekat odgovor = new OdgovorObjekat();
        try {
            Racun r = Controller.getInstance().stornirajRacun(racun);
            odgovor.setStatus(StatusOdgovora.USPESNO);
            odgovor.setPodaci(r);
        } catch (Exception ex) {
            odgovor.setStatus(StatusOdgovora.GRESKA);
            odgovor.setPorukaGreska(ex.getMessage());
            System.out.println(ex.getMessage());
        }
        return odgovor;
    }

    private OdgovorObjekat obrisiRezervaciju(Rezervacija rezervacija) {
        OdgovorObjekat odgovor = new OdgovorObjekat();
        try {
            Rezervacija r = Controller.getInstance().obrisiRezervaciju(rezervacija);
            odgovor.setStatus(StatusOdgovora.USPESNO);
            odgovor.setPodaci(r);
        } catch (Exception ex) {
            odgovor.setStatus(StatusOdgovora.GRESKA);
            odgovor.setPorukaGreska(ex.getMessage());
            System.out.println(ex.getMessage());
        }
        return odgovor;
    }
}
