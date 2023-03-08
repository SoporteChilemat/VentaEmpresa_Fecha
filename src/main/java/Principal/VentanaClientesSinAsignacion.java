/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Principal;

import Clases.ClienteVESinAsignar;
import Clases.Vendedor;
import DAO.consultaClienteSinAsignarDAO;
import DAO.consultaClienteVEDAO;
import static DAO.consultaVendedorVEDAO.consultaVendedoresVE;
import static Logica.LogicaVE.cargaTabla;
import static Logica.LogicaVE.ventanaVE;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author sopor
 */
public class VentanaClientesSinAsignacion extends javax.swing.JFrame {

    /**
     * Creates new form ClientesSinAsignacion
     */
    public VentanaClientesSinAsignacion() {
        initComponents();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Clientes Sin Asignacion:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cargarTablaSinAsignar();
    }//GEN-LAST:event_formWindowOpened

    public static void cargarTablaSinAsignar() {
        // TODO add your handling code here:
        ArrayList<ClienteVESinAsignar> consultaClientesVESinAsignar = consultaClienteSinAsignarDAO.consultaClientesVESinAsignar();

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Rut");
        model.addColumn("Razol Social");
        model.addColumn("Mover");
        model.addColumn("Quitar");

        Object[] fila = new Object[4];

        consultaClientesVESinAsignar.stream().forEach((ClienteVESinAsignar clienteVESinAsignar) -> {
            fila[0] = clienteVESinAsignar.getRut();
            fila[1] = clienteVESinAsignar.getRazonSocial();
            fila[2] = "Aqui va el boton";
            fila[3] = "Aqui va el boton";
            model.addRow(fila);
        });

        jTable1.setModel(model);

        jTable1.setRowHeight(25);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);

        jTable1.getColumnModel().getColumn(0).setCellRenderer(renderer);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(renderer);

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);

        jTable1.getColumnModel().getColumn(0).setCellEditor(new TablePopupEditor1());
        jTable1.getColumnModel().getColumn(1).setCellEditor(new TablePopupEditor1());

        jTable1.getColumn("Quitar").setCellRenderer(new CustomRendererBoton4("Quitar"));
        jTable1.getColumn("Quitar").setCellEditor(new CustomEditorBoton4("Quitar", jTable1));

        jTable1.getColumn("Mover").setCellRenderer(new CustomRendererBoton5("Mover"));
        jTable1.getColumn("Mover").setCellEditor(new CustomEditorBoton5("Mover", jTable1));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

class CustomRendererBoton4 implements TableCellRenderer {

    JButton b;

    public CustomRendererBoton4(String name) {
        b = new javax.swing.JButton();
        b.setText(name);
        b.setText("Quitar");
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return b;
    }
}

class CustomEditorBoton4 extends AbstractCellEditor implements TableCellEditor, ActionListener, FocusListener {

    JButton b;
    JTable tabla;

    @Override
    public Object getCellEditorValue() {
        return "";
    }

    public CustomEditorBoton4(String nombre, JTable Jtable) {
        this.tabla = Jtable;
//        this.razonSocial = razonSocial;
        b = new javax.swing.JButton();
        b.setText("Quitar");
        b.addActionListener(this);
        b.addFocusListener(this);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return b;
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        int selectedRow = tabla.getSelectedRow();
        try {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(Principal.newJFrame, "Quieres Eliminar?", "Eliminar?", dialogButton);

            if (dialogResult == 0) {
                boolean eliminaCorreo = consultaClienteSinAsignarDAO.eliminaClienteSinAsignar(tabla.getValueAt(selectedRow, 0).toString());
                if (eliminaCorreo == true) {
                    DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                    model.removeRow(selectedRow);
                    tabla.revalidate();
                    tabla.repaint();
                }
            }
        } catch (Exception ex) {
            //Logger.getLogger(TablePopupEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actionPerformed(ActionEvent e) {
        tabla.getCellEditor().stopCellEditing();
    }
}
////////////////////////////////////////////////////////////////////////////////

class CustomRendererBoton5 implements TableCellRenderer {

    JButton b;

    public CustomRendererBoton5(String name) {
        b = new javax.swing.JButton();
        b.setText(name);
        b.setText("Mover");
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return b;
    }
}

class CustomEditorBoton5 extends AbstractCellEditor implements TableCellEditor, ActionListener, FocusListener {

    JButton b;
    JTable tabla;

    @Override
    public Object getCellEditorValue() {
        return "";
    }

    public CustomEditorBoton5(String nombre, JTable Jtable) {
        this.tabla = Jtable;
//        this.label = label;
//        this.razonSocial = razonSocial;
        b = new javax.swing.JButton();
        b.setText("Mover");
        b.addActionListener(this);
        b.addFocusListener(this);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return b;
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        int selectedRow = tabla.getSelectedRow();
        try {
            JComboBox jpf = new JComboBox();
            ArrayList<Vendedor> consultaVendedoresVE = consultaVendedoresVE();
            for (int i = 0; i < consultaVendedoresVE.size(); i++) {
                jpf.addItem(consultaVendedoresVE.get(i).getNombre());
            }

            JLabel jl = new JLabel("Mover a: ");
            Box box = Box.createHorizontalBox();
            box.add(jl);
            box.add(jpf);
            int x = JOptionPane.showConfirmDialog(Principal.newJFrame, box, "Mover Cliente de Vendedor", JOptionPane.OK_CANCEL_OPTION);
            String input = "";

            if (x == JOptionPane.OK_OPTION) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(Principal.newJFrame, "Quieres Actualizar?", "Actualizar?", dialogButton);

                if (dialogResult == 0) {
                    input = jpf.getSelectedItem().toString();
                    consultaClienteVEDAO.registraClientes(tabla.getValueAt(selectedRow, 0).toString(), tabla.getValueAt(selectedRow, 1).toString(), input);

                    boolean eliminaCorreo = consultaClienteSinAsignarDAO.eliminaClienteSinAsignar(tabla.getValueAt(selectedRow, 0).toString());
                    if (eliminaCorreo == true) {
                        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                        model.removeRow(selectedRow);
                        tabla.revalidate();
                        tabla.repaint();

                        JPanel cargaTabla = cargaTabla();
                        ventanaVE.jScrollPane1.setViewportView(cargaTabla);
                        ventanaVE.revalidate();
                        ventanaVE.repaint();
                    }
                }
            }
        } catch (Exception ex) {
            //Logger.getLogger(TablePopupEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actionPerformed(ActionEvent e) {
        tabla.getCellEditor().stopCellEditing();
    }
}

class UpperCaseDocument1 extends PlainDocument {

    private boolean upperCase = true;

    public void setUpperCase(boolean flag) {
        upperCase = flag;
    }

    public void insertString(int offset, String str, AttributeSet attSet)
            throws BadLocationException {
        if (upperCase) {
            str = str.toUpperCase();
        }
        super.insertString(offset, str, attSet);
    }
}
////////////////////////////////////////////////////////////////////////////////

class TablePopupEditor1 extends DefaultCellEditor implements TableCellEditor {

    private PopupDialog1 popup;
    private String currentText = "";
    private JButton editorComponent;

    public TablePopupEditor1() {
        super(new JTextField());

        setClickCountToStart(1);

        //  Use a JButton as the editor component
        editorComponent = new JButton();
        editorComponent.setBackground(Color.white);
        editorComponent.setBorderPainted(false);
        editorComponent.setContentAreaFilled(false);

        // Make sure focus goes back to the table when the dialog is closed
        editorComponent.setFocusable(false);

        //  Set up the dialog where we do the actual editing
        popup = new PopupDialog1();
    }

    public Object getCellEditorValue() {
        return currentText;
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                popup.setText(currentText);
//              popup.setLocationRelativeTo( editorComponent );
                Point p = editorComponent.getLocationOnScreen();
                popup.setLocation(p.x, p.y + editorComponent.getSize().height);
//                fadeIn(popup);
                popup.show();
                fireEditingStopped();
            }
        });

        currentText = value.toString();
        editorComponent.setText(currentText);
        return editorComponent;
    }
////////////////////////////////////////////////////////////////////////////////

    class PopupDialog1 extends JDialog implements ActionListener, WindowFocusListener {

        private JTextArea textArea;

        public PopupDialog1() {
            super((Frame) null, "Change Description", false);

            this.setUndecorated(true);
            textArea = new JTextArea();
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            KeyStroke keyStroke = KeyStroke.getKeyStroke("ENTER");
            textArea.getInputMap().put(keyStroke, "none");
            JScrollPane scrollPane = new JScrollPane(textArea);
            getContentPane().add(textArea);

            this.addWindowFocusListener(this);

            pack();
        }

        public void setText(String text) {
            textArea.setText(text);
            AffineTransform affinetransform = new AffineTransform();
            FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
            Font font = new Font("Dialog", Font.PLAIN, 12);
            int textwidth = (int) (font.getStringBounds(text, frc).getWidth());
            System.out.println("textwidth " + textwidth);
            int textheight = (int) (font.getStringBounds(text, frc).getHeight());
            System.out.println("textheight " + textheight);
//            fadeIn(this);
            this.setSize(textwidth + 25, textheight * 2);
        }

        public void actionPerformed(ActionEvent e) {
            if ("Ok".equals(e.getActionCommand())) {
                currentText = textArea.getText();
            }

            textArea.requestFocusInWindow();
            setVisible(false);
        }

        @Override
        public void windowGainedFocus(WindowEvent e) {

        }

        @Override
        public void windowLostFocus(WindowEvent e) {
            this.dispose();
        }
    }
}
