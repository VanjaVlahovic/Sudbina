/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.racun;

import domain.IOpstiObjekat;
import domain.Racun;
import domain.StavkaRacuna;
import domain.Sto;
import so.AbstractOpstaOperacija;

/**
 *
 * @author Vanja Vlahović
 */
public class StornirajRacun extends AbstractOpstaOperacija{

    @Override
    protected void preduslovi(Object entity) throws Exception {
    }

    @Override
    protected Object izvrsiOperaciju(Object entity) throws Exception {
        Racun racun = (Racun) entity;  
        try{
            databaseBroker.update((Racun) entity);
            racun.setUkupnaVrednost(racun.getUkupnaVrednost().negate());
            racun = (Racun) databaseBroker.insert((Racun)entity);            
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new Exception("Sistem ne može da stornira račun");
        }
        return racun;
    }
    
}
