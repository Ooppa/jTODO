/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.ui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import jtodo.domain.Category;
import jtodo.managers.DatabaseManager;

/**
 * List categories saved in the system, allows the user to add and edit.
 *
 * @author Ooppa
 * @see Category
 */
public class ListCategoriesWindow extends JFrame {

    private DatabaseManager databaseManager;
    private TaskViewWindow taskViewWindow;

    private static final Logger logger = Logger.getLogger(ListCategoriesWindow.class.getName());

    /**
     * Creates a new ListCategories with it's location relative to window
     *
     * @param taskViewWindow  TaskViewWindow to update on edit
     * @param databaseManager Database to update on edit
     */
    public ListCategoriesWindow(TaskViewWindow taskViewWindow, DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
        this.taskViewWindow = taskViewWindow;

        initComponents();
        setVisible(true);
        setLocationRelativeTo(taskViewWindow);

        logger.log(Level.INFO, "Created a new ListCategories window.");
    }

    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        categoryListScrollPane = new javax.swing.JScrollPane();
        categoryList = new javax.swing.JList();
        buttonAdd = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        jSeparator1.setName("jSeparator1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("jtodo/ui/Bundle");
        setTitle(bundle.getString("ListCategoriesWindow.title"));
        setName("Form");
        addWindowListener(formListener);
        addKeyListener(formListener);

        categoryListScrollPane.setName("categoryListScrollPane");

        categoryList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = getCategoryAsStringArray();

            public int getSize() {
                return strings.length;
            }

            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        categoryList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        categoryList.setName("categoryList");
        categoryListScrollPane.setViewportView(categoryList);

        buttonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/categoryadd.png")));
        buttonAdd.setText(bundle.getString("ListCategoriesWindow.buttonAdd.text"));
        buttonAdd.setName("buttonAdd");
        buttonAdd.addActionListener(formListener);

        buttonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/categoryedit.png")));
        buttonEdit.setText(bundle.getString("ListCategoriesWindow.buttonEdit.text"));
        buttonEdit.setName("buttonEdit");
        buttonEdit.addActionListener(formListener);

        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cross.png")));
        buttonDelete.setText(bundle.getString("ListCategoriesWindow.buttonDelete.text"));
        buttonDelete.setName("buttonDelete");
        buttonDelete.addActionListener(formListener);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(categoryListScrollPane)
                                .add(layout.createSequentialGroup()
                                        .add(buttonAdd)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(buttonEdit)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(buttonDelete)
                                        .add(0, 101, Short.MAX_VALUE)))
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(categoryListScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 255, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(buttonAdd)
                                .add(buttonEdit)
                                .add(buttonDelete))
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.
    private class FormListener implements java.awt.event.ActionListener,
            java.awt.event.KeyListener, java.awt.event.WindowListener {

        FormListener() {
        }

        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if(evt.getSource()==buttonAdd) {
                ListCategoriesWindow.this.buttonAddActionPerformed(evt);
            } else if(evt.getSource()==buttonEdit) {
                ListCategoriesWindow.this.buttonEditActionPerformed(evt);
            } else if(evt.getSource()==buttonDelete) {
                ListCategoriesWindow.this.buttonDeleteActionPerformed(evt);
            }
        }

        public void keyPressed(java.awt.event.KeyEvent evt) {
        }

        public void keyReleased(java.awt.event.KeyEvent evt) {
            if(evt.getSource()==ListCategoriesWindow.this) {
                ListCategoriesWindow.this.formKeyReleased(evt);
            }
        }

        public void keyTyped(java.awt.event.KeyEvent evt) {
        }

        public void windowActivated(java.awt.event.WindowEvent evt) {
        }

        public void windowClosed(java.awt.event.WindowEvent evt) {
        }

        public void windowClosing(java.awt.event.WindowEvent evt) {
            if(evt.getSource()==ListCategoriesWindow.this) {
                ListCategoriesWindow.this.formWindowClosing(evt);
            }
        }

        public void windowDeactivated(java.awt.event.WindowEvent evt) {
        }

        public void windowDeiconified(java.awt.event.WindowEvent evt) {
        }

        public void windowIconified(java.awt.event.WindowEvent evt) {
        }

        public void windowOpened(java.awt.event.WindowEvent evt) {
        }
    }

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if(this.categoryList.getSelectedIndex()!=-1) {
            Category selectedCategory = this.databaseManager.getCategories().get(this.categoryList.getSelectedIndex());

            // Removes the category from all tasks that it is associated to
            selectedCategory.removeAllTaskAssociations();

            this.databaseManager.getCategories().remove(selectedCategory);
            updateList();

            if(taskViewWindow!=null) {
                taskViewWindow.updateTable();
                taskViewWindow.updateCategoryPopupSubmenu();
            }
        }

        logEvent(evt);
    }

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {
        CategoryEditorWindow categoryEditorWindow = new CategoryEditorWindow(this, databaseManager);
        categoryEditorWindow.setListCategoriesWindow(this); // Make the list auto-updateable

        logEvent(evt);
    }

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {
        if(this.categoryList.getSelectedIndex()!=-1) {
            Category selectedCategory = this.databaseManager.getCategories().get(this.categoryList.getSelectedIndex());

            CategoryEditorWindow categoryEditorWindow = new CategoryEditorWindow(this, selectedCategory);
            categoryEditorWindow.setListCategoriesWindow(this); // Make the list auto-updateable
        }

        logEvent(evt);
    }

    /*
     * When closing the window update the table in TaskViewWindow one last time
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        taskViewWindow.updateTable();
        dispose();
    }

    private void formKeyReleased(java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode()==KeyEvent.VK_F5) {
            updateList();
        }
    }

    /*
     * Updates the list found on the ListCategoriesWindow
     * @see AbstractListModel
     */
    public void updateList() {
        categoryList.setModel(new AbstractListModel() {
            String[] strings = getCategoryAsStringArray();

            public int getSize() {
                return strings.length;
            }

            public Object getElementAt(int i) {
                return strings[i];
            }
        });
    }

    /*
     * Converts a list of categories into a String array containing only their
     * names
     */
    private String[] getCategoryAsStringArray() {
        ArrayList<Category> categories = this.databaseManager.getCategories();

        String[] strings = new String[categories.size()];
        int currentIndex = 0;
        for(Category category : categories) {
            strings[currentIndex] = category.getName();
            currentIndex++;
        }

        return strings;
    }

    /*
     * Attempts to update TaskViewWindow
     *
     * @see TaskViewWindow
     */
    public void attemptToUpdateTaskViewWindow() {
        if(taskViewWindow!=null) {
            taskViewWindow.updateTable();
        }
    }

    private void logEvent(ActionEvent evt) {
        logger.log(Level.INFO, "User performed action: "+evt.toString());
    }

    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JList categoryList;
    private javax.swing.JScrollPane categoryListScrollPane;
    private javax.swing.JSeparator jSeparator1;
}
