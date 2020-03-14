/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domain.IOpstiObjekat;
import domain.Konobar;
import java.util.List;

/**
 *
 * @author Vanja Vlahović
 */
public class Prijava extends AbstractOpstaOperacija{

    @Override
    protected void preduslovi(Object entity) throws Exception {
        
    }

    @Override
    protected Object izvrsiOperaciju(Object entity) throws Exception {
        List<IOpstiObjekat> konobari =  databaseBroker.selektuj((Konobar)entity);
        if(konobari.isEmpty())
            throw new Exception("Ne postoji u bazi konobar sa datim podacima.");
        else
            return konobari.get(0);
    }
    
}
