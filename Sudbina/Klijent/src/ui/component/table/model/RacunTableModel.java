/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.component.table.model;

import domain.Proizvod;
import domain.Racun;
import domain.Status;
import domain.StavkaRacuna;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vanja Vlahović
 */
public class RacunTableModel extends AbstractTableModel {

    private Racun racun;
    private String[] naziviKolona = new String[]{"Redni broj", "Proizvod", "Velicina", "Kolicina", "Vrednost", "Ukupno"};
    private List<StavkaRacuna> obrisaneStavke = new ArrayList<>();
    
    public RacunTableModel(Racun racun) {
        this.racun = racun;
    }

    public List<StavkaRacuna> getObrisaneStavke() {
        return obrisaneStavke;
    }
    
    @Override
    public int getRowCount() {
        if (racun != null) {
            return racun.getStavkeRacuna().size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public String getColumnName(int kolona) {
        return naziviKolona[kolona];
    }

    @Override
    public Object getValueAt(int red, int kolona) {
        StavkaRacuna stavka = racun.getStavkeRacuna().get(red);
        switch (kolona) {
            case 0:
                return red + 1;
            case 1:
                return stavka.getProizvod().getNaziv();
            case 2:
                return stavka.getProizvod().getVelicina();
            case 3:
                return stavka.getKolicina();
            case 4:
                return stavka.getVrednost();
            case 5:
                return stavka.getVrednost().multiply(new BigDecimal(stavka.getKolicina()));
            default:
                return "n/a";
        }
    }

    public StavkaRacuna dodajStavku(Proizvod proizvod, int kolicina) {
        StavkaRacuna stavka = new StavkaRacuna();
        stavka.setBrojRacuna(racun.getSifra());
        stavka.setrBStavke(racun.getStavkeRacuna().size() + 1);
        stavka.setProizvod(proizvod);
        stavka.setVrednost(proizvod.getCena());
        stavka.setKolicina(kolicina);
        stavka.setStatus(Status.NOV);
        racun.getStavkeRacuna().add(stavka);
        racun.setUkupnaVrednost(racun.getUkupnaVrednost().add(stavka.getVrednost().multiply(new BigDecimal(stavka.getKolicina()))));
        System.out.println("Dodata stavka racuna");
        fireTableRowsInserted(racun.getStavkeRacuna().size() - 1, racun.getStavkeRacuna().size() - 1);
        return stavka;
    }

    public void obrisiStavku(int index) {
        StavkaRacuna sr = racun.getStavkeRacuna().get(index);
        if(sr.getStatus()==Status.STARI){
            sr.setStatus(Status.OBRISAN);
            obrisaneStavke.add(sr);
        }
        racun.getStavkeRacuna().remove(index);
        fireTableRowsDeleted(racun.getStavkeRacuna().size() - 1, racun.getStavkeRacuna().size() - 1);
    }

    public Racun getRacun() {
        return racun;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (column == 3) {
            return true;
        }
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        StavkaRacuna sr = (StavkaRacuna) racun.getStavkeRacuna().get(rowIndex);
        try {
            sr.setKolicina(new Integer(aValue.toString()));
        } catch (Exception e) {
            System.out.println("Nepravilan format za kolicinu.");
        }
        sr.setStatus(Status.IZMENJEN);
        fireTableDataChanged();
    }

}
