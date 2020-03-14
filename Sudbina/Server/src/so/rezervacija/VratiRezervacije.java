/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rezervacija;

import domain.IOpstiObjekat;
import domain.Rezervacija;
import java.util.List;
import so.AbstractOpstaOperacija;

/**
 *
 * @author Vanja Vlahović
 */
public class VratiRezervacije extends AbstractOpstaOperacija{

    @Override
    protected void preduslovi(Object entity) throws Exception {
        
    }

    @Override
    protected Object izvrsiOperaciju(Object entity) throws Exception {
        List<IOpstiObjekat> rezervacije = databaseBroker.selektuj((Rezervacija) entity);
        if(rezervacije.isEmpty())
            throw new Exception("Sistem ne može da nađe rezervacije po zadatoj vrednosti");
        return rezervacije;
    }
    
}
