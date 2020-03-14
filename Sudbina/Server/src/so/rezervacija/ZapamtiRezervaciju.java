/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rezervacija;

import domain.Rezervacija;
import domain.Sto;
import so.AbstractOpstaOperacija;

/**
 *
 * @author Vanja Vlahović
 */
public class ZapamtiRezervaciju extends AbstractOpstaOperacija {

    @Override
    protected void preduslovi(Object entity) throws Exception {

    }

    @Override
    protected Object izvrsiOperaciju(Object entity) throws Exception {
        Rezervacija rezervacija;
        try {
            rezervacija = (Rezervacija) databaseBroker.update((Rezervacija) entity);
            for(int i=0; i<rezervacija.getStolovi().size(); i++){
                Sto s =  rezervacija.getStolovi().get(i);
                switch(s.getStatus()){
                    case NOV:
                        databaseBroker.insertAsocijacija(rezervacija, i);
                        break;
                    case IZMENJEN:
                        break;
                    case OBRISAN:
                        databaseBroker.deleteAsocijacija(rezervacija, i);
                        break;
                    case STARI:
                        break;
                }
            }
        } catch (Exception e) {
            throw new Exception("Sistem ne može da zapamti rezervaciju!");
        }
        return rezervacija;
    }

}
