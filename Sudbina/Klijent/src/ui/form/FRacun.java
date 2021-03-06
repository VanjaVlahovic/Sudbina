/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.form;

import controller.Controller;
import domain.Konobar;
import domain.Proizvod;
import domain.Racun;
import domain.Status;
import domain.StavkaRacuna;
import domain.Sto;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import ui.component.table.model.ProizvodTableModel;
import ui.component.table.model.RacunTableModel;
import ui.component.table.model.StoTableModel;

/**
 *
 * @author Vanja Vlahović
 */
public class FRacun extends javax.swing.JFrame {

    private ProizvodTableModel modelProizvod;
    private RacunTableModel modelRacun;
    private StoTableModel modelStola;
    private final Long sifraRacuna;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
    private final String mode;

    /**
     * Creates new form FRacun
     */
    public FRacun(Long sifraRacuna) {
        initComponents();
        this.sifraRacuna = sifraRacuna;
        mode = "new";
        popuniFormu();
        setLocationRelativeTo(null);
    }

    public FRacun(Racun r) {
        initComponents();
        this.sifraRacuna = r.getSifra();
        mode = "edit";
        popuniFormu(r);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxtSifra = new javax.swing.JTextField();
        jTxtKonobar = new javax.swing.JTextField();
        jTxtDatum = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRacun = new javax.swing.JTable();
        jBtnObrisiStavku = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTxtUkupno = new javax.swing.JTextField();
        jBtnSacuvaj = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableStolovi = new javax.swing.JTable();
        jBtnDodajSto = new javax.swing.JButton();
        jCBStolovi = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jBtnIzbaciSto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProizvod = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTxtNaziv = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxtSifraProizvoda = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTxtCenaProizvoda = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTxtKolicina = new javax.swing.JTextField();
        jBtnDodajStavku = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTxtVelicina = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Račun");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Račun"));

        jLabel1.setText("Šifra računa:");

        jLabel2.setText("Konobar:");

        jLabel3.setText("Datum kreiranja (dd.MM.yyyy.):");

        jTxtSifra.setEnabled(false);

        jTxtKonobar.setEnabled(false);

        jTxtDatum.setEnabled(false);

        jTableRacun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableRacun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRacunMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableRacun);

        jBtnObrisiStavku.setText("Obrisi stavku");
        jBtnObrisiStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnObrisiStavkuActionPerformed(evt);
            }
        });

        jLabel4.setText("Ukupno: ");

        jTxtUkupno.setEnabled(false);

        jBtnSacuvaj.setText("Sacuvaj račun");
        jBtnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSacuvajActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Račun za stolove"));

        jTableStolovi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTableStolovi);

        jBtnDodajSto.setText("Dodaj sto");
        jBtnDodajSto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDodajStoActionPerformed(evt);
            }
        });

        jCBStolovi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCBStolovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBStoloviActionPerformed(evt);
            }
        });

        jLabel10.setText("Sto:");

        jBtnIzbaciSto.setText("Izbaci sto");
        jBtnIzbaciSto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIzbaciStoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jCBStolovi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(119, 119, 119))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jBtnDodajSto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnIzbaciSto)
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBStolovi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnDodajSto)
                    .addComponent(jBtnIzbaciSto))
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTxtUkupno, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBtnObrisiStavku))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtKonobar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jBtnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTxtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTxtKonobar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTxtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTxtUkupno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnObrisiStavku)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(7, 7, 7)
                .addComponent(jBtnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Proizvodi"));

        jTableProizvod.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableProizvod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProizvodMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProizvod);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Proizvod"));

        jLabel5.setText("Naziv proizvoda:");

        jTxtNaziv.setEnabled(false);

        jLabel6.setText("Šifra proizvoda:");

        jTxtSifraProizvoda.setEnabled(false);

        jLabel7.setText("Cena proizvoda:");

        jTxtCenaProizvoda.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Količina:");

        jBtnDodajStavku.setText("Dodaj stavku računa");
        jBtnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDodajStavkuActionPerformed(evt);
            }
        });

        jLabel9.setText("Veličina:");

        jTxtVelicina.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtSifraProizvoda, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(jTxtNaziv))
                        .addGap(46, 46, 46)
                        .addComponent(jBtnDodajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtKolicina, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(jTxtCenaProizvoda, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTxtVelicina))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtSifraProizvoda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTxtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnDodajStavku))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTxtCenaProizvoda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTxtVelicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jTxtKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableProizvodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProizvodMouseClicked

        int red = jTableProizvod.getSelectedRow();
        if (red >= 0) {
            Proizvod proizvod = modelProizvod.getProizvod(red);
            jTxtSifraProizvoda.setText(proizvod.getSifra() + "");
            jTxtNaziv.setText(proizvod.getNaziv());
            jTxtCenaProizvoda.setText(String.valueOf(proizvod.getCena()));
            jTxtVelicina.setText(proizvod.getVelicina());
            jTxtKolicina.setText("1");
            jTxtKolicina.grabFocus();
            jTxtKolicina.setSelectionStart(0);
        }
    }//GEN-LAST:event_jTableProizvodMouseClicked

    private void jBtnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDodajStavkuActionPerformed
        try {
            int red = jTableProizvod.getSelectedRow();
            if (red >= 0) {
                Proizvod proizvod = modelProizvod.getProizvod(red);
                int kolicina = Integer.valueOf(jTxtKolicina.getText().trim());
                if (kolicina <= 0) {
                    JOptionPane.showMessageDialog(this, "Kolicinu mora biti veca od 0");
                    return;
                }
                modelRacun.dodajStavku(proizvod, kolicina);
                BigDecimal vrednost = vratiUkupnuVrednost();
                jTxtUkupno.setText(String.valueOf(vrednost));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Kolicinu unesite ispravno (ceo broj)");
        }
    }//GEN-LAST:event_jBtnDodajStavkuActionPerformed

    private void jBtnObrisiStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnObrisiStavkuActionPerformed

        int red = jTableRacun.getSelectedRow();
        if (red >= 0) {
            modelRacun.obrisiStavku(red);
            BigDecimal vrednost = vratiUkupnuVrednost();
            jTxtUkupno.setText(String.valueOf(vrednost));
        } else {
            JOptionPane.showMessageDialog(this, "Niste selektovali stavku racuna koju zelite da obrisete");
        }
    }//GEN-LAST:event_jBtnObrisiStavkuActionPerformed

    private void jBtnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSacuvajActionPerformed
        try {
            List<Sto> stolovi = validacija();
            Racun racun = modelRacun.getRacun();
            racun.setStolovi(stolovi);
            if (mode.equals("new")) {
                List<StavkaRacuna> stavke = racun.getStavkeRacuna();
                for (StavkaRacuna sr : stavke) {
                    sr.setStatus(Status.NOV);
                }
                Controller.getInstance().sacuvajRacun(racun);
            } else {
                List<StavkaRacuna> sveStavke = new ArrayList<>();
                List<Sto> sviStolovi = new ArrayList<>();
                List<StavkaRacuna> obrisaneStavke = modelRacun.getObrisaneStavke();
                List<Sto> obrisaniStolovi = modelStola.getObrisani();
            
                sveStavke.addAll(obrisaneStavke);
                sveStavke.addAll(racun.getStavkeRacuna());
                racun.setStavkeRacuna(sveStavke);
                sviStolovi.addAll(obrisaniStolovi);
                sviStolovi.addAll(racun.getStolovi());
                racun.setStolovi(sviStolovi);
                Controller.getInstance().promeniRacun(racun);
            }
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio racun.");
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jBtnSacuvajActionPerformed

    private void jBtnDodajStoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDodajStoActionPerformed

        Sto sto = (Sto) jCBStolovi.getSelectedItem();
        try {
            modelStola.dodajSto(sto);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jBtnDodajStoActionPerformed

    private void jCBStoloviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBStoloviActionPerformed

    }//GEN-LAST:event_jCBStoloviActionPerformed

    private void jBtnIzbaciStoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIzbaciStoActionPerformed
        int red = jTableStolovi.getSelectedRow();
        if (red != -1) {
            modelStola.izbaciSto(red);
        }
    }//GEN-LAST:event_jBtnIzbaciStoActionPerformed

    private void jTableRacunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRacunMouseClicked
        jTxtUkupno.setText(String.valueOf(vratiUkupnuVrednost()));
    }//GEN-LAST:event_jTableRacunMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnDodajStavku;
    private javax.swing.JButton jBtnDodajSto;
    private javax.swing.JButton jBtnIzbaciSto;
    private javax.swing.JButton jBtnObrisiStavku;
    private javax.swing.JButton jBtnSacuvaj;
    private javax.swing.JComboBox jCBStolovi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableProizvod;
    private javax.swing.JTable jTableRacun;
    private javax.swing.JTable jTableStolovi;
    private javax.swing.JTextField jTxtCenaProizvoda;
    private javax.swing.JTextField jTxtDatum;
    private javax.swing.JTextField jTxtKolicina;
    private javax.swing.JTextField jTxtKonobar;
    private javax.swing.JTextField jTxtNaziv;
    private javax.swing.JTextField jTxtSifra;
    private javax.swing.JTextField jTxtSifraProizvoda;
    private javax.swing.JTextField jTxtUkupno;
    private javax.swing.JTextField jTxtVelicina;
    // End of variables declaration//GEN-END:variables

    private void popuniFormu() {
        jTxtSifra.setText(sifraRacuna + "");
        Racun racun = new Racun();
        try {
            Konobar konobar = Controller.getInstance().getKonobar();
            jTxtKonobar.setText(konobar.toString());
            Date datum = new Date();
            String datumS = sdf.format(datum);
            jTxtDatum.setText(datumS);
            racun.setSifra(sifraRacuna);
            racun.setKonobar(konobar);
            racun.setVreme(datum);
            System.out.println(datumS);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        modelRacun = new RacunTableModel(racun);
        modelStola = new StoTableModel();
        jCBStolovi.removeAllItems();
        try {
            List<Sto> stolovi = Controller.getInstance().vratiStolove(null);
            for (int i = 0; i < stolovi.size(); i++) {
                jCBStolovi.addItem(stolovi.get(i));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        List<Proizvod> proizvodi;
        try {
            proizvodi = Controller.getInstance().vratiProizvode();
            modelProizvod = new ProizvodTableModel(proizvodi);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        jTableProizvod.setModel(modelProizvod);
        jTableRacun.setModel(modelRacun);
        jTableStolovi.setModel(modelStola);

    }

    private BigDecimal vratiUkupnuVrednost() {
        Racun racun = modelRacun.getRacun();

        BigDecimal vrednost = new BigDecimal(0);
        for (StavkaRacuna stavka : racun.getStavkeRacuna()) {
            vrednost = vrednost.add(stavka.getProizvod().getCena().multiply(new BigDecimal(stavka.getKolicina())));
        }
        racun.setUkupnaVrednost(vrednost);
        return vrednost;
    }

    private List<Sto> validacija() throws Exception {
        List<Sto> stolovi = modelStola.getStolovi();
        List<StavkaRacuna> stavke = modelRacun.getRacun().getStavkeRacuna();

        if (stavke.isEmpty()) {
            throw new Exception("Morate uneti bar jedan proizvod!");
        }
        if (stolovi.isEmpty()) {
            throw new Exception("Morate uneti bar jedan sto na koji se račun odnosi!");
        } else {
            return stolovi;
        }
    }

    private void popuniFormu(Racun r) {
        for (StavkaRacuna sr : r.getStavkeRacuna()) {
            sr.setStatus(Status.STARI);
        }
        for (Sto s : r.getStolovi()) {
            s.setStatus(Status.STARI);
        }
        jTxtSifra.setText(sifraRacuna + "");

        jTxtKonobar.setText(r.getKonobar().toString());
        jTxtDatum.setText(sdf.format(r.getVreme()));

        modelRacun = new RacunTableModel(r);
        modelStola = new StoTableModel();
        modelStola.setStolovi(r.getStolovi());
        jCBStolovi.removeAllItems();
        try {
            List<Sto> stolovi = Controller.getInstance().vratiStolove(null);
            for (int i = 0; i < stolovi.size(); i++) {
                jCBStolovi.addItem(stolovi.get(i));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        List<Proizvod> proizvodi;
        try {
            proizvodi = Controller.getInstance().vratiProizvode();
            modelProizvod = new ProizvodTableModel(proizvodi);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        jTxtUkupno.setText(r.getUkupnaVrednost() + "");

        jTableProizvod.setModel(modelProizvod);
        jTableRacun.setModel(modelRacun);
        jTableStolovi.setModel(modelStola);
    }
}
