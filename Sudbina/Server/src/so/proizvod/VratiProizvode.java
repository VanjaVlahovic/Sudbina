/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.proizvod;

import domain.IOpstiObjekat;
import domain.Proizvod;
import java.util.List;
import so.AbstractOpstaOperacija;

/**
 *
 * @author Vanja Vlahović
 */
public class VratiProizvode extends AbstractOpstaOperacija {

    @Override
    protected void preduslovi(Object entity) throws Exception {
    }

    @Override
    protected Object izvrsiOperaciju(Object entity) throws Exception {
        try {
            List<IOpstiObjekat> proizvodi = databaseBroker.selektuj((Proizvod) entity);
            if (proizvodi.isEmpty()) {
                throw new Exception("Sistem ne moze da nadje proizvode.");
            } else {
                return proizvodi;
            }
        } catch (Exception e) {
            throw new Exception("Sistem ne moze da nadje proizvode.");
        }
    }
}
