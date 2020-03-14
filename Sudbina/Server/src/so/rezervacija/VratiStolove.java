/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rezervacija;

import domain.IOpstiObjekat;
import domain.Sto;
import java.util.List;
import so.AbstractOpstaOperacija;

/**
 *
 * @author Vanja Vlahović
 */
public class VratiStolove extends AbstractOpstaOperacija {

    @Override
    protected void preduslovi(Object entity) throws Exception {
    }

    @Override
    protected Object izvrsiOperaciju(Object entity) throws Exception {
        try{
        List<IOpstiObjekat> stolovi = databaseBroker.selektuj((Sto) entity);
        if(stolovi.isEmpty()){
            throw new Exception("Sistem ne može da nađe slobodne stolove.");
        }else
            return stolovi;
        }catch(Exception e){
            throw new Exception("Sistem ne može da vrati stolove.");
        }
    }

}
