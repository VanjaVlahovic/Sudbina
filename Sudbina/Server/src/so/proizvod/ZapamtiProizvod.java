/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.proizvod;

import domain.Proizvod;
import so.AbstractOpstaOperacija;

/**
 *
 * @author Vanja Vlahović
 */
public class ZapamtiProizvod extends AbstractOpstaOperacija{

    @Override
    protected void preduslovi(Object entity) throws Exception {
        //uraditi
    }

    @Override
    protected Object izvrsiOperaciju(Object objekat) throws Exception {
        try{
            return databaseBroker.update((Proizvod) objekat);
        }catch(Exception e){
            throw new Exception("Sistem ne može da zapamti proizvod");
        }
        
    }
    
}
