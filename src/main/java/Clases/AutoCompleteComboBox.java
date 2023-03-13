/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxEditor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxEditor;

/**
 *
 * @author sopor
 */
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AutoCompleteComboBox extends JComboBox<String> {

    private int caretPos = 0;
    private JTextField tfield = null;

    public AutoCompleteComboBox() {
        setEditor(new BasicComboBoxEditor());
        setEditable(true);
        setRenderer(new CustomComboBoxRenderer());
        ((JLabel) getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        tfield.setHorizontalAlignment(JTextField.CENTER);
    }

    public void setSelectedIndex(int index) {
        super.setSelectedIndex(index);
        tfield.setText(getItemAt(index).toString());
        tfield.setSelectionEnd(caretPos + tfield.getText().length());
        tfield.moveCaretPosition(caretPos);
    }

    public void setEditor(ComboBoxEditor editor) {
        super.setEditor(editor);
        if (editor.getEditorComponent() instanceof JTextField) {
            tfield = (JTextField) editor.getEditorComponent();
            tfield.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent ke) {
                    char key = ke.getKeyChar();
                    if (!(Character.isLetterOrDigit(key) || Character.isSpaceChar(key))) {
                        return;
                    }
                    caretPos = tfield.getCaretPosition();
                    String text = "";
                    try {
                        text = tfield.getText(0, caretPos);
                    } catch (javax.swing.text.BadLocationException e) {
                        e.printStackTrace();
                    }
                    // Convertir el texto a mayúsculas antes de compararlo
                    text = text.toUpperCase();
                    for (int i = 0; i < getItemCount(); i++) {
                        String element = (String) getItemAt(i);
                        if (element.toUpperCase().startsWith(text)) {
                            setSelectedIndex(i);
                            return;
                        }
                    }
                }
            });
        }
    }

    private static class CustomComboBoxRenderer extends JLabel implements ListCellRenderer<Object> {

        private Border border = BorderFactory.createLineBorder(Color.BLUE, 1);

        public CustomComboBoxRenderer() {
            setOpaque(true);
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
        }

        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            setText((String) value);
            setBorder(cellHasFocus ? border : null);
            setBackground(isSelected ? Color.lightGray : Color.white);
            return this;
        }
    }
}
