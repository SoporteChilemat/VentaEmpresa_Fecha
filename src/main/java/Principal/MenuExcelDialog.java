/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Principal;

/**
 *
 * @author sopor
 */
import Clases.ErrorExito;
import Clases.Maestra;
import static DAO.maestraDAO.insertMaestra;
import Logica.Logica;
import static Logica.Logica.abrirExcel;
import static Logica.Logica.abrirExcel2;
import static Logica.Logica.abrirExcel3;
import static Logica.Logica.arrMaestra;
import static Logica.Logica.cargaTablaLocal;
import static Logica.Logica.chromeDriverNotaDeCredito;
import static Logica.Logica.crearExcel;
import static Logica.Logica.crearExcel2;
import static Logica.Logica.crearExcel3;
import static Logica.Logica.fila;
import static Logica.Logica.filtraRecuadroUno;
import static Principal.Principal.arrReportes;
import static Principal.Principal.arrReportes2;
import static Principal.Principal.arrReportes3;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.TransformerException;
import org.apache.commons.codec.EncoderException;
import static Logica.Logica.procedimientoCargarDocumento;
import static Logica.Logica.resizeColumnWidth;
import static Principal.Principal.jLabel4;
import static Principal.Principal.jTable1;
import static Principal.Principal.jTable2;
import static Principal.Principal.jTable3;
import static Principal.Principal.jTable4;
import static Principal.Principal.jTable6;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import static Logica.Logica.arrErrorExito;
import static Principal.Principal.jTable5;
import static Principal.Principal.jTable7;

public class MenuExcelDialog extends javax.swing.JDialog {

    /**
     * Creates new form MenuExcelDialogDialog
     */
    public MenuExcelDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

//        jPanel1.setVisible(false);
//        jButton3.setVisible(false);
//        jButton4.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Facturas", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe Script", 0, 12))); // NOI18N

        jButton3.setText("Generar Excel Especial");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Leer Excel con Origen");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setText("Generar Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Leer Excel Facturas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton5.setText("Generar Excel N.Credito");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Leer Excel N.Credito");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton1))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Maestra", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe Script", 0, 12))); // NOI18N

        jButton9.setText("Leer Excel Maestra");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            crearExcel2();
            abrirExcel2();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        CompletableFuture.runAsync(() -> {
            try {
                ejecucion2 = 1;
                arrReportes2 = Logica.arrReportes2(System.getProperty("user.dir") + "\\ListadoFacturas2.xlsx");
                System.out.println(arrReportes2.size());
                for (int i = 0; i < arrReportes2.size(); i++) {
                    ArrayList<String> get = arrReportes2.get(i);
                    System.out.println(get.get(0) + " " + get.get(1));
                }
                procedimientoCargarDocumento(1);
            } catch (Exception ex) {
                System.out.println("ex " + ex);
            }
        }).thenRunAsync(() -> {
            ejecucion2 = 0;

            if (!arrErrorExito.isEmpty()) {
                VentanaErrorExito vee = new VentanaErrorExito(Principal.newJFrame, true);

                DefaultTableModel model = (DefaultTableModel) vee.jTable1.getModel();
                fila = new Object[3];
                for (int i = 0; i < arrErrorExito.size(); ++i) {
                    ErrorExito errorExito = arrErrorExito.get(i);

                    fila[0] = errorExito.getFolio();
                    fila[1] = errorExito.getDescripcion();
                    fila[2] = errorExito.isEstado();
                    model.addRow(fila);
                }

                ((DefaultTableCellRenderer) vee.jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
                resizeColumnWidth(vee.jTable1);

                vee.jTable1.setRowHeight(35);
                vee.jTable1.setShowHorizontalLines(true);
                vee.jTable1.setShowVerticalLines(true);

                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                int columnCount = vee.jTable1.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    vee.jTable1.getColumnModel().getColumn(i).setCellRenderer(renderer);
                }
                renderer.setHorizontalAlignment(JLabel.CENTER);

                vee.jTable1.getColumn("Estado").setCellRenderer(new CustomRenderer());

                vee.setLocationRelativeTo(this);
                vee.setVisible(true);
            }

            try {
                ((DefaultTableModel) jTable1.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                ((DefaultTableModel) jTable2.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                ((DefaultTableModel) jTable3.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                ((DefaultTableModel) jTable4.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                ((DefaultTableModel) jTable5.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                ((DefaultTableModel) jTable6.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                ((DefaultTableModel) jTable7.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                cargaTablaLocal();
                if (!jLabel4.getText().equals("-")) {
                    filtraRecuadroUno();
                }
            } catch (IOException | SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(MenuExcelDialog.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                File f = new File(System.getProperty("user.dir") + "\\ListadoFacturas2.xlsx");
                if (f.delete()) {
                    System.out.println(f.getName() + " deleted");
                } else {
                    System.out.println("failed");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            dispose();
        });
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            crearExcel();
            abrirExcel();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CompletableFuture.runAsync(() -> {
            try {
                ejecucion1 = 1;
                arrReportes = Logica.arrReportes(System.getProperty("user.dir") + "\\ListadoFacturas.xlsx");
                procedimientoCargarDocumento(0);
            } catch (InterruptedException ex) {
                Logger.getLogger(MenuExcelDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MenuExcelDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (EncoderException ex) {
                Logger.getLogger(MenuExcelDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(MenuExcelDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MenuExcelDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(MenuExcelDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(MenuExcelDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).thenRunAsync(() -> {
            ejecucion1 = 0;
            if (!arrErrorExito.isEmpty()) {
                VentanaErrorExito vee = new VentanaErrorExito(Principal.newJFrame, true);

                DefaultTableModel model = (DefaultTableModel) vee.jTable1.getModel();
                fila = new Object[3];
                for (int i = 0; i < arrErrorExito.size(); ++i) {
                    ErrorExito errorExito = arrErrorExito.get(i);

                    fila[0] = errorExito.getFolio();
                    fila[1] = errorExito.getDescripcion();
                    fila[2] = errorExito.isEstado();
                    model.addRow(fila);
                }

                ((DefaultTableCellRenderer) vee.jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
                resizeColumnWidth(vee.jTable1);

                vee.jTable1.setRowHeight(35);
                vee.jTable1.setShowHorizontalLines(true);
                vee.jTable1.setShowVerticalLines(true);

                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                int columnCount = vee.jTable1.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    vee.jTable1.getColumnModel().getColumn(i).setCellRenderer(renderer);
                }
                renderer.setHorizontalAlignment(JLabel.CENTER);

                vee.jTable1.getColumn("Estado").setCellRenderer(new CustomRenderer());

                vee.setLocationRelativeTo(this);
                vee.setVisible(true);
            }

            try {
                ((DefaultTableModel) jTable1.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                ((DefaultTableModel) jTable2.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                ((DefaultTableModel) jTable3.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                ((DefaultTableModel) jTable4.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                ((DefaultTableModel) jTable5.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                ((DefaultTableModel) jTable6.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                ((DefaultTableModel) jTable7.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                cargaTablaLocal();
                if (!jLabel4.getText().equals("-")) {
                    filtraRecuadroUno();
                }
            } catch (IOException | SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(MenuExcelDialog.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                File f = new File(System.getProperty("user.dir") + "\\ListadoFacturas.xlsx");
                if (f.delete()) {
                    System.out.println(f.getName() + " deleted");
                } else {
                    System.out.println("failed");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            dispose();
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            // TODO add your handling code here:
            crearExcel3();
            abrirExcel3();
        } catch (IOException ex) {
            Logger.getLogger(MenuExcelDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        CompletableFuture.runAsync(() -> {
            try {
                ejecucion3 = 1;
                arrReportes3 = Logica.arrReportes(System.getProperty("user.dir") + "\\ListadoNotasCredito.xlsx");
                chromeDriverNotaDeCredito();
            } catch (IOException ex) {
                Logger.getLogger(MenuExcelDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(MenuExcelDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (EncoderException ex) {
                Logger.getLogger(MenuExcelDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(MenuExcelDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MenuExcelDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).thenRunAsync(() -> {
            ejecucion3 = 0;
            if (!arrErrorExito.isEmpty()) {
                VentanaErrorExito vee = new VentanaErrorExito(Principal.newJFrame, true);

                DefaultTableModel model = (DefaultTableModel) vee.jTable1.getModel();
                fila = new Object[3];
                for (int i = 0; i < arrErrorExito.size(); ++i) {
                    ErrorExito errorExito = arrErrorExito.get(i);

                    fila[0] = errorExito.getFolio();
                    fila[1] = errorExito.getDescripcion();
                    fila[2] = errorExito.isEstado();
                    model.addRow(fila);
                }

                ((DefaultTableCellRenderer) vee.jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
                resizeColumnWidth(vee.jTable1);

                vee.jTable1.setRowHeight(35);
                vee.jTable1.setShowHorizontalLines(true);
                vee.jTable1.setShowVerticalLines(true);

                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                int columnCount = vee.jTable1.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    vee.jTable1.getColumnModel().getColumn(i).setCellRenderer(renderer);
                }
                renderer.setHorizontalAlignment(JLabel.CENTER);

                vee.jTable1.getColumn("Estado").setCellRenderer(new CustomRenderer());

                vee.setLocationRelativeTo(this);
                vee.setVisible(true);
            }

            try {
                ((DefaultTableModel) jTable1.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                ((DefaultTableModel) jTable2.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                ((DefaultTableModel) jTable3.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                ((DefaultTableModel) jTable4.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                ((DefaultTableModel) jTable5.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                ((DefaultTableModel) jTable6.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                ((DefaultTableModel) jTable7.getModel()).setNumRows(0);
            } catch (Exception ex) {

            }
            try {
                cargaTablaLocal();
                if (!jLabel4.getText().equals("-")) {
                    filtraRecuadroUno();
                }
            } catch (IOException | SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(MenuExcelDialog.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                File f = new File(System.getProperty("user.dir") + "\\ListadoNotasCredito.xlsx");
                if (f.delete()) {
                    System.out.println(f.getName() + " deleted");
                } else {
                    System.out.println("failed");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Maestra", ".xlsx", "xlsx");
        fileChooser.setFileFilter(filter);
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            Thread thread = new Thread(() -> {
                try {
                    jButton9.setEnabled(false);
                    cont = new AtomicInteger(1);
                    ArrayList<Maestra> arrMaestrax = null;
                    try {
                        arrMaestrax = arrMaestra(selectedFile.getAbsolutePath());
                        boolean insertMaestra = insertMaestra(arrMaestrax);

                        if (insertMaestra) {
                            JOptionPane.showMessageDialog(Principal.newJFrame, "Maestra Actualizada!");
                        } else {
                            JOptionPane.showMessageDialog(Principal.newJFrame, "Ops, Algo salio mal!", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (Exception ex) {

                } finally {
                    jButton9.setText("Leer Excel Maestra");
                    jButton9.setEnabled(true);
                }
            });
            thread.start();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    public static javax.swing.JButton jButton4;
    public static javax.swing.JButton jButton5;
    public static javax.swing.JButton jButton6;
    public static javax.swing.JButton jButton9;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
    public static AtomicInteger cont;
    public static int ejecucion1;
    public static int ejecucion2;
    public static int ejecucion3;
}

class MoveMouseListener implements MouseListener, MouseMotionListener {

    JComponent target;
    Point start_drag;
    Point start_loc;

    public MoveMouseListener(JComponent target) {
        this.target = target;
    }

    public static JFrame getFrame(Container target) {
        if (target instanceof JFrame) {
            return (JFrame) target;
        }
        return getFrame(target.getParent());
    }

    Point getScreenLocation(MouseEvent e) {
        Point cursor = e.getPoint();
        Point target_location = this.target.getLocationOnScreen();
        return new Point((int) (target_location.getX() + cursor.getX()),
                (int) (target_location.getY() + cursor.getY()));
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        this.start_drag = this.getScreenLocation(e);
        this.start_loc = this.getFrame(this.target).getLocation();
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        Point current = this.getScreenLocation(e);
        Point offset = new Point((int) current.getX() - (int) start_drag.getX(), (int) current.getY() - (int) start_drag.getY());
        JFrame frame = this.getFrame(target);
        Point new_location = new Point((int) (this.start_loc.getX() + offset.getX()), (int) (this.start_loc.getY() + offset.getY()));
        frame.setLocation(new_location);
    }

    public void mouseMoved(MouseEvent e) {
    }
}