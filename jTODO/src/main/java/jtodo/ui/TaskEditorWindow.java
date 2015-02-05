/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.ui;

import java.awt.Window;
import java.util.logging.Level;
import java.util.logging.Logger;
import jtodo.domain.Priority;
import jtodo.domain.Task;
import jtodo.excptions.TooLongInputException;
import jtodo.excptions.TooShortInputException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Creates a new window for editing or creating a new task
 * 
 * TODO: Created using Netbeans, will clean up later.
 *
 * @author Ooppa
 * @see Task
 */
public class TaskEditorWindow extends javax.swing.JFrame {

    /*
     * Task to be edited or created
     */
    private Task task;

    private static final Logger logger = Logger.getLogger(TaskEditorWindow.class.getName());

    /**
     * Creates a new TaskEditorWindow with it's location relative to the given
     * window and a predetermined task to edit
     *
     * @param window Window which TaskEditorWindow should be attached to
     * @param task   Task to edit
     *
     * @see Task
     */
    public TaskEditorWindow(Window window, Task task) {
        this.task = task;
        createWindow(window, "Edit Task");
        fillInValues();
    }

    /**
     * Creates a new TaskEditorWindow with it's location relative to the given
     * window, with new Task that will be generated on the go.
     *
     * @param window
     *
     * @see Task
     */
    public TaskEditorWindow(Window window) {
        try {
            this.task = new Task("Name", "Description");
            createWindow(window, "Create new Task");
            fillInValues();
        } catch(TooShortInputException|TooLongInputException ex) {
            logger.log(Level.WARNING, "Default task created caused an exception: "+ex.toString());
        }
    }

    private void createWindow(Window window, String title) {
        this.setTitle(title);
        this.initComponents();
        this.setLocationRelativeTo(window);
        this.setVisible(true);
    }

    /*
     * Fills the form with Task's values
     */
    private void fillInValues() {
        fieldName.setText(task.getName());
        fieldDescription.setText(task.getDescription());

        if(task.isDeadlineActive()) {
            fieldFormattedDate.setText(task.getDeadlineAsString());
            checkBoxDeadlineActive.setSelected(true);
        } else {
            fieldFormattedDate.setText(getCurrentTimeFormattedAsString());
            checkBoxDeadlineActive.setSelected(false);
        }

    }

    private void attemptToCreateTaskFromForm() {
        try {
            Task created = new Task(fieldName.getText(), fieldDescription.getText());
            created.setDeadline(fieldFormattedDate.getText());
            created.setDeadlineActive(checkBoxDeadlineActive.isSelected());
            created.setPriority((Priority) comboBoxPriority.getSelectedItem());
        } catch(TooShortInputException ex) {
            // TODO
            logger.log(Level.INFO, "Tried to add Task with too short input. User notified.");
        } catch(TooLongInputException ex) {
            // TODO
            logger.log(Level.INFO, "Tried to add Task with too long input. User notified.");
        }

    }

    /*
     * Creates a timestamp as a suggestion for a deadline if not defined already
     */
    private String getCurrentTimeFormattedAsString() {
        DateTimeFormatter formatter;

        formatter = DateTimeFormat.forPattern("dd.MM.YYYY HH:mm");
        DateTime datetime = new DateTime();

        return datetime.toString(formatter);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        labelDeadline = new javax.swing.JLabel();
        labelDescription = new javax.swing.JLabel();
        labelTaskName = new javax.swing.JLabel();
        labelPriority = new javax.swing.JLabel();
        fieldName = new javax.swing.JTextField();
        fieldDescription = new javax.swing.JTextField();
        comboBoxPriority = new javax.swing.JComboBox(Priority.values());
        fieldFormattedDate = new javax.swing.JFormattedTextField();
        buttonSave = new javax.swing.JButton();
        checkBoxDeadlineActive = new javax.swing.JCheckBox();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N
        setResizable(false);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("jtodo/ui/Bundle"); // NOI18N
        labelDeadline.setText(bundle.getString("TaskEditorWindow.labelDeadline.text")); // NOI18N
        labelDeadline.setName("labelDeadline"); // NOI18N

        labelDescription.setText(bundle.getString("TaskEditorWindow.labelDescription.text")); // NOI18N
        labelDescription.setName("labelDescription"); // NOI18N

        labelTaskName.setText(bundle.getString("TaskEditorWindow.labelTaskName.text")); // NOI18N
        labelTaskName.setName("labelTaskName"); // NOI18N

        labelPriority.setText(bundle.getString("TaskEditorWindow.labelPriority.text")); // NOI18N
        labelPriority.setName("labelPriority"); // NOI18N

        fieldName.setText(bundle.getString("TaskEditorWindow.fieldName.text")); // NOI18N
        fieldName.setName("fieldName"); // NOI18N

        fieldDescription.setText(bundle.getString("TaskEditorWindow.fieldDescription.text")); // NOI18N
        fieldDescription.setName("fieldDescription"); // NOI18N

        comboBoxPriority.setName("comboBoxPriority"); // NOI18N

        fieldFormattedDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.YYYY hh:mm"))));
        fieldFormattedDate.setName("fieldFormattedDate"); // NOI18N

        buttonSave.setText(bundle.getString("TaskEditorWindow.buttonSave.text")); // NOI18N
        buttonSave.setName("buttonSave"); // NOI18N
        buttonSave.addActionListener(formListener);

        checkBoxDeadlineActive.setSelected(true);
        checkBoxDeadlineActive.setText(bundle.getString("TaskEditorWindow.checkBoxDeadlineActive.text")); // NOI18N
        checkBoxDeadlineActive.setName("checkBoxDeadlineActive"); // NOI18N
        checkBoxDeadlineActive.addActionListener(formListener);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(buttonSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 104, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(labelTaskName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fieldName))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(labelDeadline, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(checkBoxDeadlineActive)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fieldFormattedDate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(labelDescription, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fieldDescription))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(labelPriority, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(comboBoxPriority, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(fieldName)
                    .add(labelTaskName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(labelDescription, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(fieldDescription))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(labelPriority, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .add(comboBoxPriority))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(labelDeadline, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, checkBoxDeadlineActive, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .add(fieldFormattedDate))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(buttonSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == checkBoxDeadlineActive) {
                TaskEditorWindow.this.checkBoxDeadlineActiveActionPerformed(evt);
            }
            else if (evt.getSource() == buttonSave) {
                TaskEditorWindow.this.buttonSaveActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    /*
     * When deadline is not set as active (checkbox not ticked) the field is
     * uneditable
     */
    private void checkBoxDeadlineActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxDeadlineActiveActionPerformed
        this.fieldFormattedDate.setEditable(this.checkBoxDeadlineActive.isSelected());
        logger.log(Level.FINE, "User clicked a checkbox in "+this.getClass().toString()+": "+evt.toString());
    }//GEN-LAST:event_checkBoxDeadlineActiveActionPerformed

    /*
     * Saving the new task or saving changes to the old one
     */
    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        logger.log(Level.FINE, "User clicked a button in "+this.getClass().toString()+": "+evt.toString());
        attemptToCreateTaskFromForm();
    }//GEN-LAST:event_buttonSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSave;
    private javax.swing.JCheckBox checkBoxDeadlineActive;
    private javax.swing.JComboBox comboBoxPriority;
    private javax.swing.JTextField fieldDescription;
    private javax.swing.JFormattedTextField fieldFormattedDate;
    private javax.swing.JTextField fieldName;
    private javax.swing.JLabel labelDeadline;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelPriority;
    private javax.swing.JLabel labelTaskName;
    // End of variables declaration//GEN-END:variables
}
