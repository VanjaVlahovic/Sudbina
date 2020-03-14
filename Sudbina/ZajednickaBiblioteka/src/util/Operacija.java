/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author Vanja Vlahović
 */
public interface Operacija extends Serializable {

    public static final int OPERACIJA_VRATI_PROIZVODE = 1;
    public static final int OPERACIJA_VRATI_STOLOVE = 2;
    public static final int OPERACIJA_KREIRAJ_RACUN = 3;
    public static final int OPERACIJA_ZAPAMTI_RACUN = 4;
    public static final int OPERACIJA_PRETRAZI_RACUNE = 5;
    public static final int OPERACIJA_STORNIRAJ_RACUN = 6;
    public static final int OPERACIJA_PROMENI_RACUN = 7;
    public static final int OPERACIJA_KREIRAJ_REZERVACIJU = 8;
    public static final int OPERACIJA_ZAPAMTI_REZERVACIJU = 9;
    public static final int OPERACIJA_VRATI_REZERVACIJE = 10;
    public static final int OPERACIJA_PROMENI_REZERVACIJU = 11;
    public static final int OPERACIJA_OBRISI_REZERVACIJU = 12;
    public static final int OPERACIJA_KREIRAJ_PROIZVOD = 13;
    public static final int OPERACIJA_ZAPAMTI_PROIZVOD = 14;
    public static final int OPERACIJA_PRIJAVA = 15;
    public static final int OPERACIJA_VRATI_TIPOVE_PROIZVODA = 16;
}
