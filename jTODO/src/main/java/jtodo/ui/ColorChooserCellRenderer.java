/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.ui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * Used in CategoryEditorWindow to choose the color for the Category
 *
 * @author Ooppa
 * @see CategoryEditorWindow
 */
public class ColorChooserCellRenderer extends JButton implements
        ListCellRenderer {

    static boolean hasBackgroundNotBeenSet = false;

    /*
     * Creates a new ColorChooserCellRenderer with opaque set to true
     */
    ColorChooserCellRenderer() {
        setOpaque(true);
    }

    @Override
    public void setBackground(Color backgroundColor) {
        if(!hasBackgroundNotBeenSet) {
            return;
        }

        super.setBackground(backgroundColor);
    }

    @Override
    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        hasBackgroundNotBeenSet = true;
        setText(" ");
        setBackground((Color) value);
        hasBackgroundNotBeenSet = false;
        return this;
    }
}
