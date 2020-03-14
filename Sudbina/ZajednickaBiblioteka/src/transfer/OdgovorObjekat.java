/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
import util.StatusOdgovora;

/**
 *
 * @author Vanja Vlahović
 */
public class OdgovorObjekat implements Serializable{

    private static final long serialVersionUID = 1209201909480000l;
    private StatusOdgovora status;
    private Object podaci;
    private String porukaGreska;

    public OdgovorObjekat() {
    }

    public OdgovorObjekat(StatusOdgovora status, Object podaci, String porukaGreska) {
        this.status = status;
        this.podaci = podaci;
        this.porukaGreska = porukaGreska;
    }

    public StatusOdgovora getStatus() {
        return status;
    }

    public void setStatus(StatusOdgovora status) {
        this.status = status;
    }

    public Object getPodaci() {
        return podaci;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

    public String getPorukaGreska() {
        return porukaGreska;
    }

    public void setPorukaGreska(String porukaGreska) {
        this.porukaGreska = porukaGreska;
    }

}
