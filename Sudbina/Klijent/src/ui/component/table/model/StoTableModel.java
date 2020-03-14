/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.component.table.model;

import domain.Status;
import domain.Sto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vanja Vlahović
 */
public class StoTableModel extends AbstractTableModel {

    private List<Sto> stolovi = new ArrayList<>();
    private List<Sto> obrisani = new ArrayList<>();
    private String[] naziviKolona = {"Sto", "Broj mesta"};

    public StoTableModel() {
    }

    public List<Sto> getStolovi() {
        return stolovi;
    }

    public void setStolovi(List<Sto> stolovi) {
        this.stolovi = stolovi;
        fireTableDataChanged();
    }

    public List<Sto> getObrisani() {
        return obrisani;
    }

    @Override
    public int getRowCount() {
        return stolovi.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int red, int kolona) {
        Sto sto = stolovi.get(red);
        switch (kolona) {
            case 0:
                return sto.getNaziv();
            case 1:
                return sto.getBrojMesta();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void dodajSto(Sto sto) {
        if (stolovi.contains(sto)) {
            throw new RuntimeException("Ovaj sto ste vec uneli u spisak stolova!");
        }
        sto.setStatus(Status.NOV);
        stolovi.add(sto);
        fireTableDataChanged();
    }

    public void izbaciSto(int broj) {
        Sto s = stolovi.get(broj);
        if (s.getStatus() == Status.STARI) {
            s.setStatus(Status.OBRISAN);
            obrisani.add(s);
        }
        stolovi.remove(broj);
        fireTableDataChanged();
    }

}
