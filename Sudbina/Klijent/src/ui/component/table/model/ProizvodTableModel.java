/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.component.table.model;

import domain.Proizvod;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vanja Vlahović
 */
public class ProizvodTableModel extends AbstractTableModel{
    private final List<Proizvod> proizvodi;
    private String[] naziviKolona = new String[]{"Šifra", "Naziv", "Proizvođač", "Cena", "Veličina", "Tip"};
    private Class[] klaseKolona = new Class[]{Long.class, String.class, String.class, BigDecimal.class, String.class, String.class};

    public ProizvodTableModel(List<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
    }

    public List<Proizvod> getProizvodi() {
        return proizvodi;
    }
    
    @Override
    public int getRowCount() {
        if (proizvodi == null) {
            return 0;
        }
        return proizvodi.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int red, int kolona) {
        Proizvod proizvod = proizvodi.get(red);
        switch (kolona) {
            case 0:
                return proizvod.getSifra();
            case 1:
                return proizvod.getNaziv();
            case 2:
                return proizvod.getProizvodjac();
            case 3:
                return proizvod.getCena();
            case 4:
                return proizvod.getVelicina();
            case 5: 
                return proizvod.getTipProizvoda().getNaziv();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column > naziviKolona.length) {
            return "n/a";
        }

        return naziviKolona[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int column) {
        return klaseKolona[column];
    }

    public Proizvod getProizvod(int index) {
        return proizvodi.get(index);
    }

}
