/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rezervacija;

import domain.Rezervacija;
import so.AbstractOpstaOperacija;

/**
 *
 * @author Vanja Vlahović
 */
public class ObrisiRezervaciju extends AbstractOpstaOperacija{

    @Override
    protected void preduslovi(Object entity) throws Exception {
        
    }

    @Override
    protected Object izvrsiOperaciju(Object entity) throws Exception {
        try{
            databaseBroker.delete((Rezervacija) entity);
        }catch (Exception e){
            throw new Exception("Sistem ne može da obriše rezervaciju");
        }
        return entity;
    }
    
}
