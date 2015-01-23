/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package ui;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Window displayed during creation and editing of a Task
 *
 * @author Ooppa
 * @see Task
 */
public class TaskEditorWindow extends JFrame {

    public TaskEditorWindow() {
        initComponents();
    }

    private void initComponents() {
        pack();
    }
    
    // TODO This
    private void windowSettings() {
        Dimension minimum = new Dimension(500, 300);
        Dimension preferred = new Dimension(1000, 600);

        setSize(preferred);
        setPreferredSize(preferred);
        setMaximumSize(minimum);

        setTitle("jTODO");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
