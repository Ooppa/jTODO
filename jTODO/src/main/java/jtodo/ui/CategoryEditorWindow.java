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
import jtodo.managers.DatabaseManager;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Creates a new window for editing or creating a new task
 *
 *
 * @author Ooppa
 * @see Task
 */
public class CategoryEditorWindow extends JFrame {

    /*
     * Category to be edited or created
     */
    private Category category;

    /*
     * Is the category new or old
     */
    private boolean newCategory;

    private DatabaseManager databaseManager;

    private ListCategoriesWindow listCategoriesWindow;
    private TaskViewWindow taskViewWindow;

    private static final Logger logger = Logger.getLogger(CategoryEditorWindow.class.getName());

    /**
     * Creates a new TaskEditorWindow with it's location relative to the given
     * window and a predetermined task to edit
     *
     * @param window         Window to set this window relative to
     * @param categoryToEdit Category to edit
     *
     * @see Task
     */
    public CategoryEditorWindow(Window window, Category categoryToEdit) {
        category = categoryToEdit;
        newCategory = false;

        createWindow(window, "Edit Category");
        fillInValues();

        logger.log(Level.INFO, "Created a new CategoryEditorWindow window "
                +"with predetermined Category object.");
    }

    /**
     * Creates a new TaskEditorWindow with it's location relative to the given
     * window, with new Task that will be generated on the go.
     *
     * @param window   Window to set this window relative to
     * @param database Database to attach to the CategoryEditorWindow
     *
     * @see Task
     */
    public CategoryEditorWindow(Window window, DatabaseManager database) {
        try {
            category = new Category("Name", "Description");
            databaseManager = database;
            newCategory = true;

            createWindow(window, "Create new category");
            fillInValues();
        } catch(TooShortInputException|TooLongInputException ex) {
            logger.log(Level.WARNING, "Default task created caused an exception: {0}", ex.toString());
        }

        logger.log(Level.INFO, "Created a new CategoryEditorWindow window.");
    }

    public void setListCategoriesWindow(ListCategoriesWindow listCategoriesWindow) {
        this.listCategoriesWindow = listCategoriesWindow;
    }

    public void setTaskViewWindow(TaskViewWindow taskViewWindow) {
        this.taskViewWindow = taskViewWindow;
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

        int indexOfColor = ListItemColor.getIndexFromListItemColor(category.getListItemColor());
        this.comboboxColor.setSelectedIndex(indexOfColor);
    }

    private void attemptToCreateCategoryFromForm() {
        try {
            Category category = new Category(this.fieldName.getText(), this.fieldDescription.getText());
            category.setColor(ListItemColor.getListItemColorFromIndex(this.comboboxColor.getSelectedIndex()));

            databaseManager.getCategories().add(category);

            // If the ListCategoryWindow was added, update it
            if(this.listCategoriesWindow!=null) {
                listCategoriesWindow.updateList();
                listCategoriesWindow.attemptToUpdateTaskViewWindow();
            }

            // If TaskViewWindow was added, update it
            if(this.taskViewWindow!=null) {
                taskViewWindow.updateTable();
            }

            dispose();
        } catch(TooShortInputException ex) {
            ErrorWindow error = new ErrorWindow("Your category name is too short.");
            logger.log(Level.INFO, "Tried to add Category with too short input. User notified.");
        } catch(TooLongInputException ex) {
            ErrorWindow error = new ErrorWindow("Your category name or description is too long.");
            logger.log(Level.INFO, "Tried to add Category with too long input. User notified.");
        }
    }

    private void attemptToEditCategoryFromForm() {
        try {
            category.setName(this.fieldName.getText());
            category.setDescription(this.fieldDescription.getText());
            category.setColor(ListItemColor.getListItemColorFromIndex(this.comboboxColor.getSelectedIndex()));

            if(this.listCategoriesWindow!=null) {
                listCategoriesWindow.updateList();
                listCategoriesWindow.attemptToUpdateTaskViewWindow();
            }

            dispose();
        } catch(TooShortInputException ex) {
            ErrorWindow error = new ErrorWindow("Your category name is too short.");
            logger.log(Level.INFO, "Tried to add Category with too short input. User notified.");
        } catch(TooLongInputException ex) {
            ErrorWindow error = new ErrorWindow("Your category name or description is too long.");
            logger.log(Level.INFO, "Tried to add Category with too long input. User notified.");
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

    private void initComponents() {

        comboBoxPriority = new javax.swing.JComboBox(ListItemColor.values());
        labelDescription = new javax.swing.JLabel();
        labelCategoryName = new javax.swing.JLabel();
        labelIcon = new javax.swing.JLabel();
        fieldName = new javax.swing.JTextField();
        fieldDescription = new javax.swing.JTextField();
        buttonSave = new javax.swing.JButton();
        comboboxColor = new javax.swing.JComboBox(ListItemColor.getColorsInArray());

        FormListener formListener = new FormListener();

        comboBoxPriority.setName("comboBoxPriority");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form");
        setResizable(false);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("jtodo/ui/Bundle");
        labelDescription.setText(bundle.getString("CategoryEditorWindow.labelDescription.text"));
        labelDescription.setName("labelDescription");

        labelCategoryName.setText(bundle.getString("CategoryEditorWindow.labelCategoryName.text"));
        labelCategoryName.setName("labelCategoryName");

        labelIcon.setText(bundle.getString("CategoryEditorWindow.labelIcon.text"));
        labelIcon.setName("labelIcon");

        fieldName.setText(bundle.getString("CategoryEditorWindow.fieldName.text"));
        fieldName.setName("fieldName");

        fieldDescription.setText(bundle.getString("CategoryEditorWindow.fieldDescription.text"));
        fieldDescription.setName("fieldDescription");

        buttonSave.setText(bundle.getString("CategoryEditorWindow.buttonSave.text"));
        buttonSave.setName("buttonSave");
        buttonSave.addActionListener(formListener);

        comboboxColor.setToolTipText(bundle.getString("CategoryEditorWindow.comboboxColor.toolTipText"));
        comboboxColor.setName("comboboxColor");
        comboboxColor.setRenderer(new ColorChooserCellRenderer()); // Custom renderer to show the colors on the combobox
        comboboxColor.setSelectedIndex(ListItemColor.values().length-1); // Default value is white, the last one

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

        FormListener() {
        }

        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if(evt.getSource()==buttonSave) {
                CategoryEditorWindow.this.buttonSaveActionPerformed(evt);
            }
        }
    }

    /*
     * Saving the new task or saving changes to the old one
     */
    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {
        logEvent(evt);

        if(newCategory) {
            attemptToCreateCategoryFromForm();
        } else {
            attemptToEditCategoryFromForm();
        }
    }

    /*
     * Logs the ActionEvents that the user performs.
     */
    private void logEvent(ActionEvent evt) {
        logger.log(Level.INFO, "User performed action: {0}", evt.toString());
    }

    private javax.swing.JButton buttonSave;
    private javax.swing.JComboBox comboBoxPriority;
    private javax.swing.JComboBox comboboxColor;
    private javax.swing.JTextField fieldDescription;
    private javax.swing.JTextField fieldName;
    private javax.swing.JLabel labelCategoryName;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelIcon;
}
