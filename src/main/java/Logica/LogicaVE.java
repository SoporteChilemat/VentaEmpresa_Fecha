package Logica;

import Clases.ClienteVE;
import Clases.ClienteVESinAsignar;
import Clases.Vendedor;
import DAO.consultaClienteVEDAO;
import DAO.consultaClienteSinAsignarDAO;
import static DAO.consultaClienteVEDAO.consultaClientesVE;
import static DAO.consultaVendedorVEDAO.consultaVendedoresVE;
import static Logica.LogicaVE.cargaTabla;
import static Logica.LogicaVE.ventanaVE;
import Principal.Hija;
import Principal.Principal;
import static Principal.Principal.newJFrame;
import Principal.VentanaClientes;
import Principal.VentanaLogin;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.AbstractCellEditor;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import Principal.VentanaVE;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LogicaVE {

    public static VentanaVE ventanaVE;
    public static VentanaClientes vcl;

    public static void Principal() throws IOException, SQLException {

//        if (VentanaLogin.nombrex.equals("ROJICD")) {
            vcl = new VentanaClientes();
            vcl.setLocationRelativeTo(Principal.newJFrame);
            vcl.setVisible(true);
//        } else {
//            ventanaVE = new VentanaVE();
//
//            JPanel cargaTabla = cargaTabla();
//
//            ventanaVE.jScrollPane1.setViewportView(cargaTabla);
//
//            ventanaVE.setSize(new Dimension(860, 683));
//            ventanaVE.setResizable(false);
//            ventanaVE.setLocationRelativeTo(newJFrame);
//            ventanaVE.setVisible(true);
//        }
    }

    public static JPanel cargaTabla() throws IOException, SQLException {

        ArrayList<JPanel> listPanel = new ArrayList<>();
        ArrayList< ArrayList<JPanel>> arrPanel = new ArrayList<>();

        //obtener informacion de BD 
        ArrayList<Vendedor> consultaVendedoresVe = consultaVendedoresVE();
        ArrayList<ClienteVE> consultaClienteVE = consultaClientesVE();

        for (int i = 0; i < consultaVendedoresVe.size(); i++) {
            System.out.println("i " + i);
            System.out.println("consultaVendedoresVe " + consultaVendedoresVe.get(i).getNombre());

            if (i != 0) {
                System.out.println("cont % 2 " + (i % 2));
                if (i % 2 == 0) {
                    System.out.println("xi " + i);
                    System.out.println("listPanel.size() " + listPanel.size());
                    arrPanel.add(listPanel);
                    listPanel = new ArrayList<>();
                }
            }

            Hija vi = new Hija();
            UpperCaseDocument ucd = new UpperCaseDocument();
            vi.jTextField1.setDocument(ucd);
            UpperCaseDocument ucd1 = new UpperCaseDocument();
            vi.jTextField2.setDocument(ucd1);

            vi.jLabel1.setText(consultaVendedoresVe.get(i).getNombre());
            DefaultTableModel model = clientesModel(consultaVendedoresVe.get(i).getNombre(), consultaClienteVE);
            vi.jTable1.setModel(model);

            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);

            vi.jTable1.getColumnModel().getColumn(0).setCellRenderer(renderer);
            vi.jTable1.getColumnModel().getColumn(1).setCellRenderer(renderer);
            vi.jTable1.getColumnModel().getColumn(2).setCellRenderer(renderer);
            vi.jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            vi.jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            vi.jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);

            vi.jTable1.getColumnModel().getColumn(0).setCellEditor(new TablePopupEditor());
            vi.jTable1.getColumnModel().getColumn(1).setCellEditor(new TablePopupEditor());

            vi.jTable1.getColumn("Quitar").setCellRenderer(new CustomRendererBoton("Quitar"));
            vi.jTable1.getColumn("Quitar").setCellEditor(new CustomEditorBoton("Quitar", vi.jTable1));

            vi.jTable1.getColumn("Sin Asignar").setCellRenderer(new CustomRendererBotonSinAsignar("Sin Asignar"));
            vi.jTable1.getColumn("Sin Asignar").setCellEditor(new CustomEditorBotonSinAsignar("Sin Asignar", vi.jTable1));

            vi.jTable1.getColumn("Mover").setCellRenderer(new CustomRendererBoton2("Mover"));
            vi.jTable1.getColumn("Mover").setCellEditor(new CustomEditorBoton2("Mover", vi.jTable1, vi.jLabel1));

            vi.jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        int dialogResult = JOptionPane.showConfirmDialog(Principal.newJFrame, "Quieres Registrar?", "Registrar?", dialogButton);

                        if (dialogResult == 0) {
                            String rut = vi.jTextField1.getText();
                            String razonSocial = vi.jTextField2.getText();
                            String nombreVendedor = vi.jLabel1.getText();

                            boolean registraClientes = consultaClienteVEDAO.registraClientes(rut, razonSocial, nombreVendedor);
                            if (registraClientes) {
                                JPanel cargaTabla = cargaTabla();

                                ventanaVE.jScrollPane1.setViewportView(cargaTabla);
                                ventanaVE.revalidate();
                                ventanaVE.repaint();
                            } else {
                                JOptionPane.showMessageDialog(null, "Cliente No Creado", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(LogicaVE.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(LogicaVE.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            listPanel.add(vi);
        }

        if (listPanel.size() > 0) {
            arrPanel.add(listPanel);
        }

        System.out.println("arrPanel.size()  " + arrPanel.size());

        // panel main
        JPanel jp = new JPanel();
        // Crear layout de filas verticales
        jp.setLayout(new BoxLayout(jp, BoxLayout.PAGE_AXIS));

        for (int c = 0; c < arrPanel.size(); c++) {
            ArrayList<JPanel> get = arrPanel.get(c);
            JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            jp2.setLayout(new BoxLayout(jp2, BoxLayout.LINE_AXIS));
            jp2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

            for (int j = 0; j < get.size(); j++) {
                jp2.add(get.get(j));
            }

            jp.add(jp2);
        }

        return jp;
    }

    public static DefaultTableModel clientesModel(String vendedor, ArrayList<ClienteVE> arrCliente) {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Rut");
        model.addColumn("Razol Social");
        model.addColumn("Mover");
        model.addColumn("Sin Asignar");
        model.addColumn("Quitar");

        Object[] fila = new Object[4];

        for (int i = 0; i < arrCliente.size(); i++) {

            ClienteVE ve = arrCliente.get(i);
            String vendedor1 = ve.getNombreVendedor();

            if (vendedor1.equals(vendedor)) {
                fila[0] = ve.getRut();
                fila[1] = ve.getRazonSocial();
                fila[2] = "Aqui va el boton";
                fila[3] = "Aqui va el boton";
                model.addRow(fila);
            }
        }
        return model;
    }
}

class CustomRendererBoton implements TableCellRenderer {

    JButton b;

    public CustomRendererBoton(String name) {
        b = new javax.swing.JButton();
        b.setText(name);
        b.setText("Quitar");
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return b;
    }
}

class CustomEditorBoton extends AbstractCellEditor implements TableCellEditor, ActionListener, FocusListener {

    JButton b;
    JTable tabla;

    @Override
    public Object getCellEditorValue() {
        return "";
    }

    public CustomEditorBoton(String nombre, JTable Jtable) {
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
                boolean eliminaCorreo = consultaClienteVEDAO.eliminaCliente(tabla.getValueAt(selectedRow, 0).toString());
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

class CustomRendererBotonSinAsignar implements TableCellRenderer {

    JButton b;

    public CustomRendererBotonSinAsignar(String name) {
        b = new javax.swing.JButton();
        b.setText(name);
        b.setText("Sin Asignar");
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return b;
    }
}

class CustomEditorBotonSinAsignar extends AbstractCellEditor implements TableCellEditor, ActionListener, FocusListener {

    JButton b;
    JTable tabla;

    @Override
    public Object getCellEditorValue() {
        return "";
    }

    public CustomEditorBotonSinAsignar(String nombre, JTable Jtable) {
        this.tabla = Jtable;
//        this.razonSocial = razonSocial;
        b = new javax.swing.JButton();
        b.setText("Sin Asignar");
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
            int dialogResult = JOptionPane.showConfirmDialog(Principal.newJFrame, "Quieres mover a Sin Asignar?", "Sin Asignar?", dialogButton);

            if (dialogResult == 0) {
                ClienteVESinAsignar clienteVESinAsignar = new ClienteVESinAsignar();
                clienteVESinAsignar.setRut(tabla.getValueAt(selectedRow, 0).toString());
                clienteVESinAsignar.setRazonSocial(tabla.getValueAt(selectedRow, 1).toString());

                if (consultaClienteSinAsignarDAO.registraClientesSinAsignar(clienteVESinAsignar)) {
                    boolean eliminaCorreo = consultaClienteVEDAO.eliminaCliente(tabla.getValueAt(selectedRow, 0).toString());
                    if (eliminaCorreo == true) {
                        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                        model.removeRow(selectedRow);
                        tabla.revalidate();
                        tabla.repaint();
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

////////////////////////////////////////////////////////////////////////////////
class CustomRendererBoton2 implements TableCellRenderer {

    JButton b;

    public CustomRendererBoton2(String name) {
        b = new javax.swing.JButton();
        b.setText(name);
        b.setText("Mover");
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return b;
    }
}

class CustomEditorBoton2 extends AbstractCellEditor implements TableCellEditor, ActionListener, FocusListener {

    JButton b;
    JTable tabla;
    JLabel label;

    @Override
    public Object getCellEditorValue() {
        return "";
    }

    public CustomEditorBoton2(String nombre, JTable Jtable, JLabel label) {
        this.tabla = Jtable;
        this.label = label;
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

                    consultaClienteVEDAO.actualizaClienteVendedor(tabla.getValueAt(selectedRow, 0).toString(), tabla.getValueAt(selectedRow, 1).toString(), label.getText(), input);

                    JPanel cargaTabla = cargaTabla();
                    ventanaVE.jScrollPane1.setViewportView(cargaTabla);
                    ventanaVE.revalidate();
                    ventanaVE.repaint();
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

class UpperCaseDocument extends PlainDocument {

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

class TablePopupEditor extends DefaultCellEditor implements TableCellEditor {

    private PopupDialog popup;
    private String currentText = "";
    private JButton editorComponent;

    public TablePopupEditor() {
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
        popup = new PopupDialog();
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

    class PopupDialog extends JDialog implements ActionListener, WindowFocusListener {

        private JTextArea textArea;

        public PopupDialog() {
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

//            JButton cancel = new JButton("Cancel");
//            cancel.addActionListener(this);
//            JButton ok = new JButton("Ok");
//            ok.setPreferredSize(cancel.getPreferredSize());
//            ok.addActionListener(this);
//            JPanel buttons = new JPanel();
//            buttons.add(ok);
//            buttons.add(cancel);
//            getContentPane().add(buttons, BorderLayout.SOUTH);
            pack();
//            getRootPane().setDefaultButton(ok); 
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

//            jScrollPane1.getVerticalScrollBar().addAdjustmentListener((AdjustmentEvent e) -> {
//                // Check if user has done dragging the scroll bar
//                if (!e.getValueIsAdjusting()) {
//                    this.dispose();
//                }
//            });
        }

        /*
        *   Save the changed text before hiding the popup
         */
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

//    public static void fadeIn(final JDialog dialog) {
//        System.out.println("FadeIn");
//        final Timer timer = new Timer(15, null);
//        timer.setRepeats(true);
//        timer.addActionListener(new ActionListener() {
//            private float opacity = 0;
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                opacity += 0.15f;
//                dialog.setOpacity(Math.min(opacity, 1));
//                if (opacity >= 1) {
//                    timer.stop();
//                }
//            }
//        });
//
//        dialog.setOpacity(0);
//        timer.start();
////        dialog.setVisible(true);
//    }
}
