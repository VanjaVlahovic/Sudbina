/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.component.table.model;

import domain.Racun;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vanja Vlahović
 */
public class RacuniTableModel extends AbstractTableModel {
    
    private List<Racun> racuni;
    private final String[] naziviKolona={"Broj racuna", "Konobar", "Vreme", "Ukupno", "Broj stavki", "Stolovi", "Storniran"};
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

    public RacuniTableModel(List<Racun> racuni) {
        this.racuni = racuni;
    }

    public void setRacuni (List<Racun> racuni) {
        this.racuni = racuni;
        fireTableDataChanged();
    }
   
    @Override
    public int getRowCount() {
        if(racuni == null)
            return 0;
        return racuni.size();
    }

    @Override
    public int getColumnCount() {
       return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int red, int kolona) {
        Racun racun = racuni.get(red);
        switch(kolona){
            case 0:
                return racun.getSifra();
            case 1:
                return racun.getKonobar();
            case 2:
                return sdf.format(racun.getVreme());
            case 3:
                return racun.getUkupnaVrednost();
            case 4:
                return racun.getStavkeRacuna().size();
            case 5:
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<racun.getStolovi().size(); i++){
                    sb.append(racun.getStolovi().get(i).getNaziv()).append(" ");
                }
                return sb;
            case 6: 
                return racun.isStorniran();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int kolona) {
        return naziviKolona[kolona];
    }
    
    public Racun getRacun(int i){
        return racuni.get(i);
    }
    
}
