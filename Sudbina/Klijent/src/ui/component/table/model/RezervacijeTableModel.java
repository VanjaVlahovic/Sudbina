/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.component.table.model;

import domain.Rezervacija;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vanja Vlahović
 */
public class RezervacijeTableModel extends AbstractTableModel{

    private List<Rezervacija> rezervacije;
    private final String[] naziviKolona={"Sifra", "Na ime", "Vreme", "Broj mesta", "Stolovi"};
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");

    public RezervacijeTableModel(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
        fireTableDataChanged();
    }
   
    @Override
    public int getRowCount() {
        if(rezervacije==null)
            return 0;
        return rezervacije.size();
    }

    @Override
    public int getColumnCount() {
       return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int red, int kolona) {
        Rezervacija rezervacija = rezervacije.get(red);
        switch(kolona){
            case 0:
                return rezervacija.getSifra();
            case 1:
                return rezervacija.getNaIme();
            case 2:
                return sdf.format(rezervacija.getVreme());
            case 3:
                return rezervacija.getBrojMesta();
            case 4:
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<rezervacija.getStolovi().size(); i++){
                    sb.append(rezervacija.getStolovi().get(i).getNaziv()).append(" ");
                }
                return sb;
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int kolona) {
        return naziviKolona[kolona];
    }
    
    public Rezervacija getRezervacija(int i){
        return rezervacije.get(i);
    }
    
}
