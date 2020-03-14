/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.racun;

import domain.IOpstiObjekat;
import domain.Racun;
import java.util.List;
import so.AbstractOpstaOperacija;

/**
 *
 * @author Vanja Vlahović
 */
public class VratiRacune extends AbstractOpstaOperacija {

    @Override
    protected void preduslovi(Object entity) throws Exception {

    }

    @Override
    protected Object izvrsiOperaciju(Object entity) throws Exception {
        try {
            List<IOpstiObjekat> racuni = databaseBroker.selektuj((Racun) entity);
            if (racuni.isEmpty()) {
                throw new Exception("Sistem ne može da nađe račune po zadatoj vrednosti");
            } else {
                return racuni;
            }
        } catch (Exception e) {
            throw new Exception("Sistem ne moze da vrati racune");
        }
    }

}
