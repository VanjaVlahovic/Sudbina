/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;

/**
 *
 * @author Vanja Vlahović
 */
public interface IOpstiObjekat extends Serializable {
    
    public String getNazivTabele();

    public String getNaziviKolonaZaInsert();

    public String getVrednostiZaInsert();

    public void setSifra(Long sifra);
    
    public IOpstiObjekat napuniObjekat (ResultSet resultSet, Object lista); 
    
    public String joinUslov();
    
    public String getNaziviKolonaZaSelect();
    
    public String getWhereUslov();

    public String getVrednostiZaUpdate();

    public String getWhereUpdateUslov();

    public Long getSifra();

    public String getNazivTabeleAsocijacije();

    public String getNaziviKolonaZaInsertAsocijacije();

    public String getVrednostiZaInsertAsocijacije(int i);

    public String getOrderByUslov();

    public String getNaziviKolonaZaSelectAsocijacije();

    public String getWhereUslovAsocijacije();

    public String getWhereDeleteUslovAsocijacije(int i);

    public Object napuniObjekatAsocijacije(ResultSet rs);

    public String joinUslovAsocijacije();

    public boolean imaAsocijaciju();

}
