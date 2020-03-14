/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.racun;

import domain.Racun;
import so.AbstractOpstaOperacija;

/**
 *
 * @author Vanja Vlahović
 */
public class KreirajRacun extends AbstractOpstaOperacija{

    @Override
    protected void preduslovi(Object entity) throws Exception {
        
    }

    @Override
    protected Object izvrsiOperaciju(Object entity) throws Exception {
        try{
            return databaseBroker.kreiraj((Racun) entity);
        }catch (Exception e){
            throw new Exception("Sistem ne može da kreira račun");
        }
    }
    
}
