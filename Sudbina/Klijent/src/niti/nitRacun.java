/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import controller.Controller;
import domain.Konobar;
import domain.Racun;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import ui.component.table.model.RacuniTableModel;
import ui.form.FPretragaRacuna;
import ui.form.FRacun;

/**
 *
 * @author Vanja Vlahović
 */
public class nitRacun extends Thread {

    RacuniTableModel model;
    JCheckBox konobar;
    JCheckBox dan;
    JTextField k;
    JTextField d;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
    FPretragaRacuna forma;

    public nitRacun() {
    }

    public nitRacun(RacuniTableModel model, JCheckBox konobar, JCheckBox dan, JTextField k, JTextField d, FPretragaRacuna f) {
        this.model = model;
        this.konobar = konobar;
        this.dan = dan;
        this.k = k;
        this.d = d;
        this.forma = f;
    }

    @Override
    public void run(){

        while (isAlive()) {
            try {
                sleep(5000);
                Racun r = new Racun(1l, null, null, BigDecimal.ZERO, false);
                r.setKonobar(new Konobar(1l, "", "", "", "", "", ""));
                if (konobar.isSelected()) {
                    r.getKonobar().setIme(k.getText());
                }
                if (dan.isSelected()) {
                    r.setVreme(sdf.parse(d.getText()));
                }
                model.setRacuni(Controller.getInstance().vratiRacune(r));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(forma, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
