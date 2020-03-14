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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import transfer.OdgovorObjekat;
import transfer.ZahtevObjekat;
import util.Operacija;
import util.StatusOdgovora;

/**
 *
 * @author Vanja Vlahović
 */
public class Controller {

    private static Controller instance;

    private final Socket socket;
    private final Map<String, Object> map;
    private final ObjectOutputStream objectOutputStream;
    private final ObjectInputStream objectInputStream;
    private Konobar konobar;

    private Controller() throws IOException {
        socket = new Socket("localhost", 9000);
        map = new HashMap<>();
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
    }

    public static Controller getInstance() throws IOException {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Konobar getKonobar() {
        return konobar;
    }

    public void prijava(Konobar k) throws IOException, ClassNotFoundException, Exception {
        ZahtevObjekat zahtev = new ZahtevObjekat();

        zahtev.setOperacija(Operacija.OPERACIJA_PRIJAVA);
        zahtev.setPodaci(k);
        objectOutputStream.writeObject(zahtev);
        objectOutputStream.flush();

        OdgovorObjekat odgovor = (OdgovorObjekat) objectInputStream.readObject();
        StatusOdgovora status = odgovor.getStatus();

        if (status == StatusOdgovora.USPESNO) {
            konobar = (Konobar) odgovor.getPodaci();
        } else {
            throw new Exception(odgovor.getPorukaGreska());
        }
    }

    public Long kreirajNovProizvod() throws IOException, ClassNotFoundException, Exception {
        ZahtevObjekat zahtev = new ZahtevObjekat();
        zahtev.setOperacija(Operacija.OPERACIJA_KREIRAJ_PROIZVOD);
        objectOutputStream.writeObject(zahtev);
        objectOutputStream.flush();

        OdgovorObjekat odgovor = (OdgovorObjekat) objectInputStream.readObject();
        StatusOdgovora status = odgovor.getStatus();
        if (status == StatusOdgovora.USPESNO) {
            return (Long) odgovor.getPodaci();
        } else {
            throw new Exception(odgovor.getPorukaGreska());
        }
    }

    public Long kreirajNovRacun() throws IOException, ClassNotFoundException, Exception {
        ZahtevObjekat zahtev = new ZahtevObjekat();
        zahtev.setOperacija(Operacija.OPERACIJA_KREIRAJ_RACUN);
        objectOutputStream.writeObject(zahtev);
        objectOutputStream.flush();

        OdgovorObjekat odgovor = (OdgovorObjekat) objectInputStream.readObject();
        StatusOdgovora status = odgovor.getStatus();
        if (status == StatusOdgovora.USPESNO) {
            return (Long) odgovor.getPodaci();
        } else {
            throw new Exception(odgovor.getPorukaGreska());
        }
    }

    public Long kreirajNovuRezervaciju() throws IOException, ClassNotFoundException, Exception {
        ZahtevObjekat zahtev = new ZahtevObjekat();
        zahtev.setOperacija(Operacija.OPERACIJA_KREIRAJ_REZERVACIJU);
        objectOutputStream.writeObject(zahtev);
        objectOutputStream.flush();

        OdgovorObjekat odgovor = (OdgovorObjekat) objectInputStream.readObject();
        StatusOdgovora status = odgovor.getStatus();
        if (status == StatusOdgovora.USPESNO) {
            return (Long) odgovor.getPodaci();
        } else {
            throw new Exception(odgovor.getPorukaGreska());
        }
    }

    public List<TipProizvoda> vratiTipoveProizvoda() throws IOException, ClassNotFoundException, Exception {
        ZahtevObjekat zahtev = new ZahtevObjekat();
        zahtev.setOperacija(Operacija.OPERACIJA_VRATI_TIPOVE_PROIZVODA);
        objectOutputStream.writeObject(zahtev);
        objectOutputStream.flush();

        OdgovorObjekat odgovor = (OdgovorObjekat) objectInputStream.readObject();
        StatusOdgovora status = odgovor.getStatus();
        if (status == StatusOdgovora.USPESNO) {
            return (List<TipProizvoda>) odgovor.getPodaci();
        } else {
            throw new Exception(odgovor.getPorukaGreska());
        }
    }

    public List<Sto> vratiStolove(Date datum) throws IOException, ClassNotFoundException, Exception {
        ZahtevObjekat zahtev = new ZahtevObjekat();
        zahtev.setOperacija(Operacija.OPERACIJA_VRATI_STOLOVE);
        zahtev.setPodaci(datum);
        objectOutputStream.writeObject(zahtev);
        objectOutputStream.flush();

        OdgovorObjekat odgovor = (OdgovorObjekat) objectInputStream.readObject();
        StatusOdgovora status = odgovor.getStatus();
        if (status == StatusOdgovora.USPESNO) {
            return (List<Sto>) odgovor.getPodaci();
        } else {
            throw new Exception(odgovor.getPorukaGreska());
        }
    }

    public List<Proizvod> vratiProizvode() throws IOException, ClassNotFoundException, Exception {
        ZahtevObjekat zahtev = new ZahtevObjekat();
        zahtev.setOperacija(Operacija.OPERACIJA_VRATI_PROIZVODE);
        objectOutputStream.writeObject(zahtev);
        objectOutputStream.flush();

        OdgovorObjekat odgovor = (OdgovorObjekat) objectInputStream.readObject();
        StatusOdgovora status = odgovor.getStatus();
        if (status == StatusOdgovora.USPESNO) {
            return (List<Proizvod>) odgovor.getPodaci();
        } else {
            throw new Exception(odgovor.getPorukaGreska());
        }
    }

    public Racun sacuvajRacun(Racun racun) throws Exception {
        ZahtevObjekat zahtev = new ZahtevObjekat(Operacija.OPERACIJA_ZAPAMTI_RACUN, racun);
        objectOutputStream.writeObject(zahtev);
        objectOutputStream.flush();

        OdgovorObjekat odgovor = (OdgovorObjekat) objectInputStream.readObject();
        StatusOdgovora status = odgovor.getStatus();
        if (status == StatusOdgovora.USPESNO) {
            return (Racun) odgovor.getPodaci();
        } else {
            throw new Exception(odgovor.getPorukaGreska());
        }
    }

    public String sacuvajProizvod(Proizvod proizvod) throws Exception {
        ZahtevObjekat zahtev = new ZahtevObjekat(Operacija.OPERACIJA_ZAPAMTI_PROIZVOD, proizvod);
        objectOutputStream.writeObject(zahtev);
        objectOutputStream.flush();

        OdgovorObjekat odgovor = (OdgovorObjekat) objectInputStream.readObject();
        StatusOdgovora status = odgovor.getStatus();
        if (status == StatusOdgovora.USPESNO) {
            return "Sistem je zapamtio proizvod!";
        } else {
            throw new Exception(odgovor.getPorukaGreska());
        }
    }

    public Rezervacija sacuvajRezervaciju(Rezervacija rezervacija) throws Exception {
        ZahtevObjekat zahtev = new ZahtevObjekat(Operacija.OPERACIJA_ZAPAMTI_REZERVACIJU, rezervacija);
        objectOutputStream.writeObject(zahtev);
        objectOutputStream.flush();

        OdgovorObjekat odgovor = (OdgovorObjekat) objectInputStream.readObject();
        StatusOdgovora status = odgovor.getStatus();
        if (status == StatusOdgovora.USPESNO) {
            return (Rezervacija) odgovor.getPodaci();
        } else {
            throw new Exception(odgovor.getPorukaGreska());
        }
    }

    public List<Rezervacija> vratiRezervacije(Rezervacija rezervacija) throws Exception {
        ZahtevObjekat zahtev = new ZahtevObjekat(Operacija.OPERACIJA_VRATI_REZERVACIJE, rezervacija);
        objectOutputStream.writeObject(zahtev);
        objectOutputStream.flush();

        OdgovorObjekat odgovor = (OdgovorObjekat) objectInputStream.readObject();
        StatusOdgovora status = odgovor.getStatus();
        if (status == StatusOdgovora.USPESNO) {
            return (List<Rezervacija>) odgovor.getPodaci();
        } else {
            throw new Exception(odgovor.getPorukaGreska());
        }
    }

    public List<Racun> vratiRacune(Racun racun) throws Exception {
        ZahtevObjekat zahtev = new ZahtevObjekat(Operacija.OPERACIJA_PRETRAZI_RACUNE, racun);
        objectOutputStream.writeObject(zahtev);
        objectOutputStream.flush();

        OdgovorObjekat odgovor = (OdgovorObjekat) objectInputStream.readObject();
        StatusOdgovora status = odgovor.getStatus();
        if (status == StatusOdgovora.USPESNO) {
            return (List<Racun>) odgovor.getPodaci();
        } else {
            throw new Exception(odgovor.getPorukaGreska());
        }
    }

    public Racun promeniRacun(Racun racun) throws Exception {
        ZahtevObjekat zahtev = new ZahtevObjekat(Operacija.OPERACIJA_PROMENI_RACUN, racun);
        objectOutputStream.writeObject(zahtev);
        objectOutputStream.flush();

        OdgovorObjekat odgovor = (OdgovorObjekat) objectInputStream.readObject();
        StatusOdgovora status = odgovor.getStatus();
        if (status == StatusOdgovora.USPESNO) {
            return (Racun) odgovor.getPodaci();
        } else {
            throw new Exception(odgovor.getPorukaGreska());
        }
    }

    public Rezervacija promeniRezervaciju(Rezervacija rezervacija) throws Exception {
        ZahtevObjekat zahtev = new ZahtevObjekat(Operacija.OPERACIJA_PROMENI_REZERVACIJU, rezervacija);
        objectOutputStream.writeObject(zahtev);
        objectOutputStream.flush();

        OdgovorObjekat odgovor = (OdgovorObjekat) objectInputStream.readObject();
        StatusOdgovora status = odgovor.getStatus();
        if (status == StatusOdgovora.USPESNO) {
            return (Rezervacija) odgovor.getPodaci();
        } else {
            throw new Exception(odgovor.getPorukaGreska());
        }
    }

    public Racun stornirajRacun(Racun racun) throws Exception {
        ZahtevObjekat zahtev = new ZahtevObjekat(Operacija.OPERACIJA_STORNIRAJ_RACUN, racun);
        objectOutputStream.writeObject(zahtev);
        objectOutputStream.flush();

        OdgovorObjekat odgovor = (OdgovorObjekat) objectInputStream.readObject();
        StatusOdgovora status = odgovor.getStatus();
        if (status == StatusOdgovora.USPESNO) {
            return (Racun) odgovor.getPodaci();
        } else {
            throw new Exception(odgovor.getPorukaGreska());
        }

    }

    public Rezervacija obrisiRezervaciju(Rezervacija r) throws Exception {
        ZahtevObjekat zahtev = new ZahtevObjekat(Operacija.OPERACIJA_OBRISI_REZERVACIJU, r);
        objectOutputStream.writeObject(zahtev);
        objectOutputStream.flush();

        OdgovorObjekat odgovor = (OdgovorObjekat) objectInputStream.readObject();
        StatusOdgovora status = odgovor.getStatus();
        if (status == StatusOdgovora.USPESNO) {
            return (Rezervacija) odgovor.getPodaci();
        } else {
            throw new Exception(odgovor.getPorukaGreska());
        }
    }
}
