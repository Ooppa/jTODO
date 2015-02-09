/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.ui;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import jtodo.domain.Category;
import jtodo.domain.ListItemColor;
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
public class CategoryEditorWindow extends JFrame {

    /*
     * Task to be edited or created
     */
    private Category category;

    private static final Logger logger = Logger.getLogger(CategoryEditorWindow.class.getName());

    /**
     * Creates a new TaskEditorWindow with it's location relative to the given
     * window and a predetermined task to edit
     *
     * @param window Window which TaskEditorWindow should be attached to
     * @param task   Task to edit
     *
     * @see Task
     */
    public CategoryEditorWindow(Window window, Category category) {
        this.category = category;
        createWindow(window, "Edit Category");
        fillInValues();

        logger.log(Level.INFO, "Created a new CategoryEditorWindow window "
                +"with predetermined Category object.");
    }

    /**
     * Creates a new TaskEditorWindow with it's location relative to the given
     * window, with new Task that will be generated on the go.
     *
     * @param window
     *
     * @see Task
     */
    public CategoryEditorWindow(Window window) {
        try {
            this.category = new Category("Name", "Description");
            createWindow(window, "Create new category");
            fillInValues();
        } catch(TooShortInputException|TooLongInputException ex) {
            logger.log(Level.WARNING, "Default task created caused an exception: "+ex.toString());
        }

        logger.log(Level.INFO, "Created a new CategoryEditorWindow window.");
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
        fieldName.setText(category.getName());
        fieldDescription.setText(category.getDescription());

        // TODO
    }

    private void attemptToCreateCategoryFromForm() {
        // TODO
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

        comboBoxPriority = new javax.swing.JComboBox(ListItemColor.values());
        labelDescription = new javax.swing.JLabel();
        labelCategoryName = new javax.swing.JLabel();
        labelIcon = new javax.swing.JLabel();
        fieldName = new javax.swing.JTextField();
        fieldDescription = new javax.swing.JTextField();
        buttonSave = new javax.swing.JButton();
        comboboxColor = new javax.swing.JComboBox();

        FormListener formListener = new FormListener();

        comboBoxPriority.setName("comboBoxPriority"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N
        setResizable(false);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("jtodo/ui/Bundle"); // NOI18N
        labelDescription.setText(bundle.getString("CategoryEditorWindow.labelDescription.text")); // NOI18N
        labelDescription.setName("labelDescription"); // NOI18N

        labelCategoryName.setText(bundle.getString("CategoryEditorWindow.labelCategoryName.text")); // NOI18N
        labelCategoryName.setName("labelCategoryName"); // NOI18N

        labelIcon.setText(bundle.getString("CategoryEditorWindow.labelIcon.text")); // NOI18N
        labelIcon.setName("labelIcon"); // NOI18N

        fieldName.setText(bundle.getString("CategoryEditorWindow.fieldName.text")); // NOI18N
        fieldName.setName("fieldName"); // NOI18N

        fieldDescription.setText(bundle.getString("CategoryEditorWindow.fieldDescription.text")); // NOI18N
        fieldDescription.setName("fieldDescription"); // NOI18N

        buttonSave.setText(bundle.getString("CategoryEditorWindow.buttonSave.text")); // NOI18N
        buttonSave.setName("buttonSave"); // NOI18N
        buttonSave.addActionListener(formListener);

        comboboxColor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboboxColor.setToolTipText(bundle.getString("CategoryEditorWindow.comboboxColor.toolTipText")); // NOI18N
        comboboxColor.setName("comboboxColor"); // NOI18N

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
                        .add(labelCategoryName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fieldName))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(labelDescription, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(fieldDescription, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(labelIcon, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(comboboxColor, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(fieldName)
                    .add(labelCategoryName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(labelDescription, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(fieldDescription))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(labelIcon, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .add(comboboxColor))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
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
                CategoryEditorWindow.this.buttonSaveActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    /*
     * Saving the new task or saving changes to the old one
     */
    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        // TODO
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
    private javax.swing.JComboBox comboBoxPriority;
    private javax.swing.JComboBox comboboxColor;
    private javax.swing.JTextField fieldDescription;
    private javax.swing.JTextField fieldName;
    private javax.swing.JLabel labelCategoryName;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelIcon;
    // End of variables declaration//GEN-END:variables
}
