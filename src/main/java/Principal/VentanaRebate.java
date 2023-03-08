/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Principal;

import Clases.PorcentajeProveedorRebate;
import Clases.ProveedorRebate;
import DAO.porcentajeProveedorRebateDAO;
import static DAO.proveedorRebateDAO.selectProveedorRebate;
import static Principal.Principal.vr;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author sopor
 */
public class VentanaRebate extends javax.swing.JDialog {

    /**
     * Creates new form VentanaRebate
     */
    public VentanaRebate(java.awt.Frame parent, boolean modal) throws IOException, SQLException {
        super(parent, modal);
        initComponents();
        int mayor = 0;
        jPanel1.removeAll();
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));
        
        ArrayList<ProveedorRebate> selectProveedorRebate = selectProveedorRebate();
        
        for (int i = 0; i < selectProveedorRebate.size(); i++) {
            JPanel jp0 = new JPanel();
            jp0.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            jp0.setBackground(Color.WHITE);
            jp0.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            
            JLabel jLabel0 = new javax.swing.JLabel();
            jLabel0.setText("   " + selectProveedorRebate.get(i).getNombre());
            jLabel0.setPreferredSize(new Dimension(150, 16));
            jLabel0.setSize(new Dimension(150, 16));
            jLabel0.setToolTipText(selectProveedorRebate.get(i).getNombre());
            
            jp0.add(jLabel0);
            
            ArrayList<PorcentajeProveedorRebate> selectPorcentajeXProveedorRebate = porcentajeProveedorRebateDAO.selectPorcentajeXProveedorRebate(selectProveedorRebate.get(i).getRut());
            
            for (int j = 0; j < selectPorcentajeXProveedorRebate.size(); j++) {
                if (mayor < selectPorcentajeXProveedorRebate.size()) {
                    mayor = selectPorcentajeXProveedorRebate.size();
                }
                
                JPanel jp1 = new JPanel();
                JLabel jLabel1 = new javax.swing.JLabel();
                jLabel1.setFont(new Font("Calibri", Font.PLAIN, 12));
                jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
                jLabel1.setVerticalAlignment(SwingConstants.CENTER);
                
                JLabel jLabel2 = new javax.swing.JLabel();
                jLabel2.setFont(new Font("Calibri", Font.PLAIN, 12));
                jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
                jLabel2.setVerticalAlignment(SwingConstants.CENTER);
                
                JButton jButton1 = new javax.swing.JButton();
                
                JLabel jLabel3 = new javax.swing.JLabel();
                jLabel3.setText(selectProveedorRebate.get(i).getRut());
                jLabel3.setVisible(false);
                
                jLabel1.setText(selectPorcentajeXProveedorRebate.get(j).getAño());
                jLabel2.setText((100 - Integer.valueOf(selectPorcentajeXProveedorRebate.get(j).getPorcentaje())) + "%");
                jButton1.setText("Eliminar");
                
                jButton1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String rut = jLabel3.getText();
                            String año = jLabel1.getText();
                            porcentajeProveedorRebateDAO.eliminaPorcentajeProveedorRebate(rut, año);
                            
                            dispose();
                            
                            vr = new VentanaRebate(Principal.newJFrame, true);
                            vr.setLocationRelativeTo(Principal.newJFrame);
                            vr.setVisible(true);
                        } catch (IOException ex) {
                            Logger.getLogger(VentanaRebate.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(VentanaRebate.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                
                jp1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                
                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jp1);
                jp1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addContainerGap())
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1)
                                        .addContainerGap())
                );
                
                jp1.setPreferredSize(new Dimension(89, 87));
                jp1.setSize(new Dimension(89, 87));
                
                jp0.add(jp1, BorderLayout.WEST);
            }
            
            System.out.println(90 * selectPorcentajeXProveedorRebate.size());
            jp0.setSize(new Dimension(88, (90 * selectPorcentajeXProveedorRebate.size())));
            jp0.setPreferredSize(new Dimension(88, (90 * selectPorcentajeXProveedorRebate.size())));
            
            jPanel1.add(jp0);
        }
        
        System.out.println(93 * selectProveedorRebate.size());
        jPanel1.setSize(new Dimension(154 + (89 * mayor), (91 * selectProveedorRebate.size())));
        jPanel1.setPreferredSize(new Dimension(154 + (89 * mayor), (91 * selectProveedorRebate.size())));
        
        System.out.println("mayor " + mayor);
        
        if (selectProveedorRebate.size() <= 5) {
            System.out.println((92 * selectProveedorRebate.size()) + 70 + 6);
            this.setSize(new Dimension(169 + (89 * mayor) + 34, (92 * selectProveedorRebate.size()) + 70 + 6));
            this.setPreferredSize(new Dimension(169 + (89 * mayor) + 34, (92 * selectProveedorRebate.size()) + 70 + 6));
        } else {
            System.out.println((92 * selectProveedorRebate.size()) + 70 + 6);
            this.setSize(new Dimension(169 + (89 * mayor) + 34, (92 * 5) + 70 + 6));
            this.setPreferredSize(new Dimension(169 + (89 * mayor) + 34, (92 * 5) + 70 + 6));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        jScrollPane1.setViewportView(jPanel1);

        jMenu1.setText("Menu");

        jMenuItem1.setText("Agregar Acuerdo Comercial");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        try {
            this.dispose();
            
            VentanaAgregaRebate var = new VentanaAgregaRebate(Principal.newJFrame, true);
            var.setLocationRelativeTo(Principal.newJFrame);
            var.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(VentanaRebate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaRebate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
