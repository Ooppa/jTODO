/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.ui;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import jtodo.domain.Task;
import jtodo.excptions.TooLongInputException;
import jtodo.excptions.TooShortInputException;

/**
 * Window displayed during creation and editing of a Task
 *
 * @author Ooppa
 * @see Task
 */
public class TaskEditorWindow extends JFrame {
    
    private Task task;
    private static final Logger logger = Logger.getLogger(TaskEditorWindow.class.getName());

    public TaskEditorWindow() {
        try {
            this.task = new Task("Name", "Description");
            setTitle("New Task");
            initComponents();
            
        } catch(TooShortInputException|TooLongInputException ex) {
            logger.log(Level.WARNING, "Failed to create Task in TaskEditorWindow");
        }
    }
    
    public TaskEditorWindow(Task task) {
        this.task = task;
        setTitle("Edit Task");
        initComponents();
    }

    private void initComponents() {
        // TODO components
        pack();
    }
    
    // TODO This
    private void windowSettings() {
        Dimension minimum = new Dimension(500, 300);
        Dimension preferred = new Dimension(1000, 600);

        setSize(preferred);
        setPreferredSize(preferred);
        setMaximumSize(minimum);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
