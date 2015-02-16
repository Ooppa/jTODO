/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.ui;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.time.Month;
import java.util.Calendar;
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

    private boolean newTask;

    private TaskViewWindow taskViewWindow;

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
    public TaskEditorWindow(TaskViewWindow taskViewWindow, Task task) {
        this.task = task;
        this.taskViewWindow = taskViewWindow;
        this.newTask = false;

        createWindow(taskViewWindow, "Edit Task");
        fillInValues();

        logger.log(Level.INFO, "Created a new TaskEditorWindow window "
                +"with predetermined Task object.");
    }

    /**
     * Creates a new TaskEditorWindow with it's location relative to the given
     * window, with new Task that will be generated on the go.
     *
     * @param window
     *
     * @see Task
     */
    public TaskEditorWindow(TaskViewWindow taskViewWindow) {
        try {
            this.task = new Task("Name", "Description");
            this.taskViewWindow = taskViewWindow;
            this.newTask = true;

            createWindow(taskViewWindow, "Create new task");
            fillInValues();
        } catch(TooShortInputException|TooLongInputException ex) {
            logger.log(Level.WARNING, "Default task created caused an exception: "+ex.toString());
        }

        logger.log(Level.INFO, "Created a new TaskEditorWindow window.");
    }

    private void createWindow(Window window, String title) {
        setTitle(title);
        initComponents();
        setLocationRelativeTo(window);
        setVisible(true);
    }

    /*
     * Fills the form with Task's values
     */
    private void fillInValues() {
        logger.log(Level.INFO, "Automatically filling in the values for the task");

        fieldName.setText(task.getName());
        fieldDescription.setText(task.getDescription());
        comboBoxPriority.setSelectedItem(task.getPriority());

        if(task.isDeadlineActive()) {

            DateTime dateTime = task.getDeadline().getDateTime();

            comboBoxDay.setSelectedIndex(dateTime.getDayOfMonth()-1);
            comboBoxMonth.setSelectedIndex(dateTime.getMonthOfYear()-1);
            fieldYear.setText(""+dateTime.getYear());
            comboBoxTime.setSelectedItem(dateTime.getHourOfDay()+":"+dateTime.getMinuteOfHour());

            checkBoxDeadlineActive.setSelected(true);
        } else {
            checkBoxDeadlineActive.setSelected(false);
        }

    }

    private Task attemptToCreateTaskFromForm() throws TooLongInputException, TooShortInputException {
        logger.log(Level.INFO, "Attempting to create task from the form input.");

        Task created = new Task(fieldName.getText(), fieldDescription.getText());
        created.setDeadline(getDeadlineFromFieldAsString());
        created.setDeadlineActive(checkBoxDeadlineActive.isSelected());
        created.setPriority((Priority) comboBoxPriority.getSelectedItem());

        return created;
    }
    
    private void attemptToEditTaskFromForm() throws TooLongInputException, TooShortInputException {
        logger.log(Level.INFO, "Attempting to create task from the form input.");
        
        task.setName(fieldName.getText());
        task.setDescription(fieldDescription.getText());
        
        if(checkBoxDeadlineActive.isSelected()){
            task.setDeadline(getDeadlineFromFieldAsString());
        } else {
            task.setDeadlineActive(false);
        }
        
        task.setPriority((Priority) comboBoxPriority.getSelectedItem());
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

    private String getDeadlineFromFieldAsString() {
        String dayString = (String) comboBoxDay.getSelectedItem();
        String monthString = (String) comboBoxDay.getSelectedItem();
        String yearString = fieldYear.getText();
        String timeString = (String) comboBoxTime.getSelectedItem();

        return dayString+"."+monthString+"."+yearString+" "+timeString;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelDeadline = new javax.swing.JLabel();
        labelDescription = new javax.swing.JLabel();
        labelTaskName = new javax.swing.JLabel();
        labelPriority = new javax.swing.JLabel();
        fieldName = new javax.swing.JTextField();
        fieldDescription = new javax.swing.JTextField();
        comboBoxPriority = new javax.swing.JComboBox(Priority.values());
        buttonSave = new javax.swing.JButton();
        checkBoxDeadlineActive = new javax.swing.JCheckBox();
        comboBoxDay = new javax.swing.JComboBox();
        comboBoxMonth = new javax.swing.JComboBox(Month.values());
        fieldYear = new javax.swing.JTextField();
        comboBoxTime = new javax.swing.JComboBox();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        buttonSave.setText(bundle.getString("TaskEditorWindow.buttonSave.text")); // NOI18N
        buttonSave.setName("buttonSave"); // NOI18N
        buttonSave.addActionListener(formListener);

        checkBoxDeadlineActive.setSelected(true);
        checkBoxDeadlineActive.setText(bundle.getString("TaskEditorWindow.checkBoxDeadlineActive.text")); // NOI18N
        checkBoxDeadlineActive.setToolTipText(bundle.getString("TaskEditorWindow.checkBoxDeadlineActive.toolTipText")); // NOI18N
        checkBoxDeadlineActive.setName("checkBoxDeadlineActive"); // NOI18N
        checkBoxDeadlineActive.addActionListener(formListener);

        comboBoxDay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        comboBoxDay.setToolTipText(bundle.getString("TaskEditorWindow.comboBoxDay.toolTipText")); // NOI18N
        comboBoxDay.setName("comboBoxDay"); // NOI18N

        comboBoxMonth.setToolTipText(bundle.getString("TaskEditorWindow.comboBoxMonth.toolTipText")); // NOI18N
        comboBoxMonth.setName("comboBoxMonth"); // NOI18N

        fieldYear.setText("" + Calendar.getInstance().get(Calendar.YEAR));
        fieldYear.setToolTipText(bundle.getString("TaskEditorWindow.fieldYear.toolTipText")); // NOI18N
        fieldYear.setName("fieldYear"); // NOI18N

        comboBoxTime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "06:00", "06:15", "06:30", "06:45", "07:00", "07:15", "07:30", "07:45", "08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45", "11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45", "17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15", "23:30", "23:45", "00:00", "00:15", "00:30", "00:45", "01:00", "01:15", "01:30", "01:45", "02:00", "02:15", "02:30", "02:45", "03:00", "03:15", "03:30", "03:45", "04:00", "04:15", "04:30", "04:45", "05:00", "05:15", "05:30", "05:45" }));
        comboBoxTime.setToolTipText(bundle.getString("TaskEditorWindow.comboBoxTime.toolTipText")); // NOI18N
        comboBoxTime.setName("comboBoxTime"); // NOI18N

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
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(comboBoxDay, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(comboBoxMonth, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fieldYear, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(comboBoxTime, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
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
                    .add(comboBoxMonth)
                    .add(comboBoxDay)
                    .add(labelDeadline, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, checkBoxDeadlineActive, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .add(fieldYear)
                    .add(comboBoxTime))
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
            if (evt.getSource() == buttonSave) {
                TaskEditorWindow.this.buttonSaveActionPerformed(evt);
            }
            else if (evt.getSource() == checkBoxDeadlineActive) {
                TaskEditorWindow.this.checkBoxDeadlineActiveActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    /*
     * When deadline is not set as active (checkbox not ticked) the fields are
     * uneditable
     */
    private void checkBoxDeadlineActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxDeadlineActiveActionPerformed
        comboBoxDay.setEnabled(checkBoxDeadlineActive.isSelected());
        comboBoxMonth.setEnabled(checkBoxDeadlineActive.isSelected());
        fieldYear.setEnabled(checkBoxDeadlineActive.isSelected());
        comboBoxTime.setEnabled(checkBoxDeadlineActive.isSelected());

        logEvent(evt);
    }//GEN-LAST:event_checkBoxDeadlineActiveActionPerformed

    /*
     * Saving the new task or saving changes to the old one
     */
    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        if(newTask) {
            // Creating a new task
            try {
                Task created = attemptToCreateTaskFromForm();
                taskViewWindow.addNewTask(created);

                dispose();
            } catch(TooShortInputException ex) {

                ErrorWindow error = new ErrorWindow("Your task name is too short.");
                logger.log(Level.INFO, "Tried to add Task with too short input. User notified.");

            } catch(TooLongInputException ex) {

                ErrorWindow error = new ErrorWindow("Your task name or description is too long.");
                logger.log(Level.INFO, "Tried to add Task with too long input. User notified.");

            } catch(IllegalArgumentException ex) {

                ErrorWindow error = new ErrorWindow("Could not parse the date your gave. Check it for errors.");
                logger.log(Level.INFO, "ErrorWindow during the parsing of datetime. Could not parse the date given.");

            }

        } else {
            // Editing old task
            try {
                attemptToEditTaskFromForm();
                taskViewWindow.updateTable();
                dispose();
            } catch(TooShortInputException ex) {

                ErrorWindow error = new ErrorWindow("Your task name is too short.");
                logger.log(Level.INFO, "Tried to add Task with too short input. User notified.");

            } catch(TooLongInputException ex) {

                ErrorWindow error = new ErrorWindow("Your task name or description is too long.");
                logger.log(Level.INFO, "Tried to add Task with too long input. User notified.");

            } catch(IllegalArgumentException ex) {

                ErrorWindow error = new ErrorWindow("Could not parse the date your gave. Check it for errors.");
                logger.log(Level.INFO, "ErrorWindow during the parsing of datetime. Could not parse the date given.");

            }
        }

        logEvent(evt);
    }//GEN-LAST:event_buttonSaveActionPerformed

    /*
     * Logs the ActionEvents that the user performs.
     */
    private void logEvent(ActionEvent evt) {
        logger.log(Level.INFO, "User performed action: "+evt.toString());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSave;
    private javax.swing.JCheckBox checkBoxDeadlineActive;
    private javax.swing.JComboBox comboBoxDay;
    private javax.swing.JComboBox comboBoxMonth;
    private javax.swing.JComboBox comboBoxPriority;
    private javax.swing.JComboBox comboBoxTime;
    private javax.swing.JTextField fieldDescription;
    private javax.swing.JTextField fieldName;
    private javax.swing.JTextField fieldYear;
    private javax.swing.JLabel labelDeadline;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelPriority;
    private javax.swing.JLabel labelTaskName;
    // End of variables declaration//GEN-END:variables
}
