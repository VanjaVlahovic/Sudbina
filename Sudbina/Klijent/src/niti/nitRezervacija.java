/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import controller.Controller;
import domain.Rezervacija;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import ui.component.table.model.RezervacijeTableModel;
import ui.form.FPretragaRezervacija;

/**
 *
 * @author Vanja Vlahović
 */
public class nitRezervacija extends Thread {

    RezervacijeTableModel model;
    JCheckBox naIme;
    JCheckBox dan;
    JTextField ime;
    JTextField d;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
    FPretragaRezervacija forma;

    public nitRezervacija() {
    }

    public nitRezervacija(RezervacijeTableModel model, JCheckBox naIme, JCheckBox dan, JTextField ime, JTextField d, FPretragaRezervacija f) {
        this.model = model;
        this.naIme = naIme;
        this.dan = dan;
        this.ime = ime;
        this.d = d;
        this.forma = f;
    }

    @Override
    public void run() {

        while (isAlive()) {
            try {
                sleep(5000);
                Rezervacija r = new Rezervacija(1l, "", 0, null, "");
                if (naIme.isSelected()) {
                    r.setNaIme(ime.getText());
                }
                if (dan.isSelected()) {
                    r.setVreme(sdf.parse(d.getText()));
                }
                model.setRezervacije(Controller.getInstance().vratiRezervacije(r));
            } catch (ParseException ex){
                JOptionPane.showMessageDialog(forma, "Datum morate uneti u punom formatu");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, ex.getMessage());
            }
        }
    }

}
