/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.racun;

import domain.Racun;
import domain.StavkaRacuna;
import domain.Sto;
import so.AbstractOpstaOperacija;

/**
 *
 * @author Vanja Vlahović
 */
public class ZapamtiRacun extends AbstractOpstaOperacija{

    @Override
    protected void preduslovi(Object entity) throws Exception {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object izvrsiOperaciju(Object entity) throws Exception {
        Racun racun = (Racun) entity;  
        try{
            racun = (Racun) databaseBroker.update((Racun)entity);
            for(StavkaRacuna sr : racun.getStavkeRacuna()){
                System.out.println(sr.getrBStavke());
                switch(sr.getStatus()){
                    case NOV:
                        databaseBroker.insert(sr);
                        break;
                    case IZMENJEN:
                        databaseBroker.update(sr);
                        break;
                    case OBRISAN:
                        databaseBroker.delete(sr);
                        break;
                    case STARI:
                        break;
                }
            }
            for(int i=0; i<racun.getStolovi().size(); i++){
                Sto s =  racun.getStolovi().get(i);
                System.out.println(s.getNaziv());
                switch(s.getStatus()){
                    case NOV:
                        databaseBroker.insertAsocijacija(racun, i);
                        break;
                    case IZMENJEN:
                        break;
                    case OBRISAN:
                        databaseBroker.deleteAsocijacija(racun, i);
                        break;
                    case STARI:
                        break;
                }
            }
                
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new Exception("Sistem ne može da zapamti račun");
        }
        return racun;
    }
    
}
