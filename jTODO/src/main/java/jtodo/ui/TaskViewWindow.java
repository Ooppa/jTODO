/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.ui;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import jtodo.domain.DatabaseManager;
import jtodo.domain.Task;

/**
 * TODO: Created using NetBeans, will clean up later.
 *
 * @author Ooppa
 */
public class TaskViewWindow extends JFrame {

    /*
     * Used to save the current tasks
     */
    private DatabaseManager databaseManager;

    private boolean autosave;

    private static final Logger logger = Logger.getLogger(TaskViewWindow.class.getName());

    /**
     * Creates new form TaskView window.
     *
     * @param tasklist DatabaseManager to view
     */
    public TaskViewWindow(DatabaseManager tasklist) {
        this.autosave = false; // On default this is off
        this.databaseManager = tasklist;

        this.setTitle("jTODO");
        this.initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        updateTable();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablePopupMenuContextMenu = new javax.swing.JPopupMenu();
        popupMenuItemEditTask = new javax.swing.JMenuItem();
        popupMenuItemDeleteTask = new javax.swing.JMenuItem();
        scrollPanelForTasks = new javax.swing.JScrollPane();
        tableTasks = new javax.swing.JTable();
        bottomPanel = new javax.swing.JPanel();
        buttonAdd = new javax.swing.JButton();
        textfieldFilter = new javax.swing.JTextField();
        menubarMain = new javax.swing.JMenuBar();
        submenuFile = new javax.swing.JMenu();
        menuItemNewTasklist = new javax.swing.JMenuItem();
        menuItemSaveTasklist = new javax.swing.JMenuItem();
        menuItemLoadTasklist = new javax.swing.JMenuItem();
        submenuEdit = new javax.swing.JMenu();
        menuItemRefresh = new javax.swing.JMenuItem();
        menuItemCheckboxAutosave = new javax.swing.JCheckBoxMenuItem();
        menuItemCheckboxAlwaysOnTop = new javax.swing.JCheckBoxMenuItem();
        submenuCategory = new javax.swing.JMenu();
        menuItemNewCategory = new javax.swing.JMenuItem();
        menuItemViewCategories = new javax.swing.JMenuItem();

        tablePopupMenuContextMenu.setName("tablePopupMenuContextMenu"); // NOI18N

        popupMenuItemEditTask.setText("Edit...");
        popupMenuItemEditTask.setToolTipText("");
        popupMenuItemEditTask.setName("popupMenuItemEditTask"); // NOI18N
        tablePopupMenuContextMenu.add(popupMenuItemEditTask);

        popupMenuItemDeleteTask.setText("Delete...");
        popupMenuItemDeleteTask.setToolTipText("");
        popupMenuItemDeleteTask.setName("popupMenuItemDeleteTask"); // NOI18N
        tablePopupMenuContextMenu.add(popupMenuItemDeleteTask);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("jTODO");
        setMinimumSize(new java.awt.Dimension(100, 100));
        setName("mainframe"); // NOI18N
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        scrollPanelForTasks.setName("scrollPanelForTasks"); // NOI18N

        tableTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Done", "Task Name", "Task Description", "Priority", "Deadline"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTasks.setColumnSelectionAllowed(true);
        tableTasks.setName("tableTasks"); // NOI18N
        tableTasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTasksMouseClicked(evt);
            }
        });
        scrollPanelForTasks.setViewportView(tableTasks);
        tableTasks.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tableTasks.getColumnModel().getColumnCount() > 0) {
            tableTasks.getColumnModel().getColumn(0).setResizable(false);
            tableTasks.getColumnModel().getColumn(0).setPreferredWidth(5);
        }
        // Rightclick menu
        tableTasks.setComponentPopupMenu(tablePopupMenuContextMenu);

        getContentPane().add(scrollPanelForTasks, java.awt.BorderLayout.CENTER);

        bottomPanel.setName("bottomPanel"); // NOI18N
        bottomPanel.setLayout(new java.awt.BorderLayout());

        buttonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png"))); // NOI18N
        buttonAdd.setText("New Task");
        buttonAdd.setName("buttonAdd"); // NOI18N
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });
        bottomPanel.add(buttonAdd, java.awt.BorderLayout.LINE_START);

        textfieldFilter.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        textfieldFilter.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textfieldFilter.setText("Filter...");
        textfieldFilter.setBorder(null);
        textfieldFilter.setName("textfieldFilter"); // NOI18N
        textfieldFilter.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                textfieldFilterCaretUpdate(evt);
            }
        });
        textfieldFilter.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfieldFilterFocusGained(evt);
            }
        });
        textfieldFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldFilterActionPerformed(evt);
            }
        });
        bottomPanel.add(textfieldFilter, java.awt.BorderLayout.CENTER);

        getContentPane().add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        menubarMain.setName("menubarMain"); // NOI18N

        submenuFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/database.png"))); // NOI18N
        submenuFile.setText("File");
        submenuFile.setName("submenuFile"); // NOI18N

        menuItemNewTasklist.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuItemNewTasklist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/newsave.png"))); // NOI18N
        menuItemNewTasklist.setText("New Tasklist");
        menuItemNewTasklist.setName("menuItemNewTasklist"); // NOI18N
        menuItemNewTasklist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNewTasklistActionPerformed(evt);
            }
        });
        submenuFile.add(menuItemNewTasklist);

        menuItemSaveTasklist.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuItemSaveTasklist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savesave.png"))); // NOI18N
        menuItemSaveTasklist.setText("Save Tasklist");
        menuItemSaveTasklist.setName("menuItemSaveTasklist"); // NOI18N
        menuItemSaveTasklist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaveTasklistActionPerformed(evt);
            }
        });
        submenuFile.add(menuItemSaveTasklist);

        menuItemLoadTasklist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loadsave.png"))); // NOI18N
        menuItemLoadTasklist.setText("Load Tasklist");
        menuItemLoadTasklist.setName("menuItemLoadTasklist"); // NOI18N
        menuItemLoadTasklist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLoadTasklistActionPerformed(evt);
            }
        });
        submenuFile.add(menuItemLoadTasklist);

        menubarMain.add(submenuFile);

        submenuEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cog.png"))); // NOI18N
        submenuEdit.setText("Edit");
        submenuEdit.setName("submenuEdit"); // NOI18N

        menuItemRefresh.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        menuItemRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        menuItemRefresh.setText("Refresh");
        menuItemRefresh.setName("menuItemRefresh"); // NOI18N
        menuItemRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRefreshActionPerformed(evt);
            }
        });
        submenuEdit.add(menuItemRefresh);

        menuItemCheckboxAutosave.setText("Autosave");
        menuItemCheckboxAutosave.setName("menuItemCheckboxAutosave"); // NOI18N
        menuItemCheckboxAutosave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCheckboxAutosaveActionPerformed(evt);
            }
        });
        submenuEdit.add(menuItemCheckboxAutosave);

        menuItemCheckboxAlwaysOnTop.setText("Always on top");
        menuItemCheckboxAlwaysOnTop.setName("menuItemCheckboxAlwaysOnTop"); // NOI18N
        menuItemCheckboxAlwaysOnTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCheckboxAlwaysOnTopActionPerformed(evt);
            }
        });
        submenuEdit.add(menuItemCheckboxAlwaysOnTop);

        menubarMain.add(submenuEdit);

        submenuCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/category.png"))); // NOI18N
        submenuCategory.setText("Categories");
        submenuCategory.setName("submenuCategory"); // NOI18N

        menuItemNewCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/categoryadd.png"))); // NOI18N
        menuItemNewCategory.setText("New Category");
        menuItemNewCategory.setName("menuItemNewCategory"); // NOI18N
        menuItemNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNewCategoryActionPerformed(evt);
            }
        });
        submenuCategory.add(menuItemNewCategory);

        menuItemViewCategories.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/categoryview.png"))); // NOI18N
        menuItemViewCategories.setText("View Categories");
        menuItemViewCategories.setName("menuItemViewCategories"); // NOI18N
        menuItemViewCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemViewCategoriesActionPerformed(evt);
            }
        });
        submenuCategory.add(menuItemViewCategories);

        menubarMain.add(submenuCategory);

        setJMenuBar(menubarMain);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemCheckboxAlwaysOnTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCheckboxAlwaysOnTopActionPerformed
        if(menuItemCheckboxAlwaysOnTop.isSelected()) {
            this.setAlwaysOnTop(true);
        } else {
            this.setAlwaysOnTop(false);
        }

        logEvent(evt);
    }//GEN-LAST:event_menuItemCheckboxAlwaysOnTopActionPerformed

    private void menuItemCheckboxAutosaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCheckboxAutosaveActionPerformed
        this.autosave = menuItemCheckboxAutosave.getState();
        logEvent(evt);
    }//GEN-LAST:event_menuItemCheckboxAutosaveActionPerformed

    private void menuItemLoadTasklistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLoadTasklistActionPerformed
        databaseManager.loadDB();
        logEvent(evt);
    }//GEN-LAST:event_menuItemLoadTasklistActionPerformed

    private void menuItemSaveTasklistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSaveTasklistActionPerformed
        databaseManager.saveDB();
        logEvent(evt);
    }//GEN-LAST:event_menuItemSaveTasklistActionPerformed

    private void menuItemNewTasklistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNewTasklistActionPerformed
        databaseManager.createNewDatabase();
        logEvent(evt);
    }//GEN-LAST:event_menuItemNewTasklistActionPerformed

    /*
     * When the filter field is focused - clear it
     */
    private void textfieldFilterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfieldFilterFocusGained
        textfieldFilter.setText("");
    }//GEN-LAST:event_textfieldFilterFocusGained

    /*
     * When the caret is update, run a check which tasks fit the given
     * requirements and only display those in the JTable
     */
    private void textfieldFilterCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_textfieldFilterCaretUpdate
        tableTasks.setModel(
                databaseManager.getTasksAsDefaultTableModelWithFilter(
                        textfieldFilter.getText()
                )
        );
    }//GEN-LAST:event_textfieldFilterCaretUpdate

    private void textfieldFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldFilterActionPerformed
        // TODO, onko turha?
        logEvent(evt);
    }//GEN-LAST:event_textfieldFilterActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        TaskEditorWindow taskEditorWindow = new TaskEditorWindow(this);
        logEvent(evt);
    }//GEN-LAST:event_buttonAddActionPerformed

    private void menuItemNewCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNewCategoryActionPerformed
        CategoryEditorWindow categoryEditorWindow = new CategoryEditorWindow(this);
        logEvent(evt);
    }//GEN-LAST:event_menuItemNewCategoryActionPerformed

    private void menuItemViewCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemViewCategoriesActionPerformed
        ListCategoriesWindow listCategories = new ListCategoriesWindow(this);
        logEvent(evt);
    }//GEN-LAST:event_menuItemViewCategoriesActionPerformed

    /*
     * Click menu trigger
     */
    private void tableTasksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTasksMouseClicked
        // TODO, toistaiseksi turha, myöhemmin muuttuuu
        logEvent(evt);
    }//GEN-LAST:event_tableTasksMouseClicked

    private void menuItemRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRefreshActionPerformed
        updateTable();
        logEvent(evt);
    }//GEN-LAST:event_menuItemRefreshActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        logEvent(evt);

        // If Ctrl+N is pressed
        if(evt.getKeyChar()==KeyEvent.VK_N&&evt.getModifiers()==InputEvent.CTRL_MASK) {

        }


    }//GEN-LAST:event_formKeyPressed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        logEvent(evt);

        // If Ctrl+N is pressed
        if(evt.getKeyChar()==KeyEvent.VK_N&&evt.getModifiers()==InputEvent.CTRL_MASK) {

        }
    }//GEN-LAST:event_formKeyTyped

    /**
     * Add a new task to table and update the table
     *
     * @param task Task to add
     */
    public void addNewTask(Task task) {
        databaseManager.getTasks().add(task);
        updateTable();

        logger.log(Level.INFO, "New task added to tasklist and JTable updated: "
                +task.toString());
    }

    /**
     * Updates the JTable that contains the tasks to match the data in the DB
     * If the automatic saving is turned on this will also save the DB.
     */
    public void updateTable() {
        if(autosave==true) {
            databaseManager.saveDB();
        }

        tableTasks.setModel(databaseManager.getTasksAsDefaultTableModel());
    }

    /**
     *
     *
     * @return Current DatabaseManager
     *
     * @see DatabaseManager
     */
    public DatabaseManager getTasklist() {
        return databaseManager;
    }

    /**
     * Set a new DatabaseManager
     *
     * @param tasklist the DatabaseManager to set
     *
     * @see DatabaseManager
     */
    public void setTasklist(DatabaseManager tasklist) {
        this.databaseManager = tasklist;
    }

    /*
     * Logs the ActionEvents that the user performs.
     */
    private void logEvent(ActionEvent evt) {
        logger.log(Level.INFO, "User performed action: "+evt.toString());
    }

    /*
     * Logs the MouseEvent that the user performs.
     */
    private void logEvent(MouseEvent evt) {
        logger.log(Level.INFO, "User performed mouse-action: "
                +"mousebutton_"+evt.getButton()+" at ["+evt.getXOnScreen()
                +","+evt.getYOnScreen()+"] with "+evt.getClickCount()+" clicks"
        );
    }

    /*
     * Logs the KeyEvent that the user performs.
     */
    private void logEvent(KeyEvent evt) {
        logger.log(Level.INFO, "User performed keyboard-action: "+evt.getKeyChar()+" with modifier "+evt.getModifiers());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JCheckBoxMenuItem menuItemCheckboxAlwaysOnTop;
    private javax.swing.JCheckBoxMenuItem menuItemCheckboxAutosave;
    private javax.swing.JMenuItem menuItemLoadTasklist;
    private javax.swing.JMenuItem menuItemNewCategory;
    private javax.swing.JMenuItem menuItemNewTasklist;
    private javax.swing.JMenuItem menuItemRefresh;
    private javax.swing.JMenuItem menuItemSaveTasklist;
    private javax.swing.JMenuItem menuItemViewCategories;
    private javax.swing.JMenuBar menubarMain;
    private javax.swing.JMenuItem popupMenuItemDeleteTask;
    private javax.swing.JMenuItem popupMenuItemEditTask;
    private javax.swing.JScrollPane scrollPanelForTasks;
    private javax.swing.JMenu submenuCategory;
    private javax.swing.JMenu submenuEdit;
    private javax.swing.JMenu submenuFile;
    private javax.swing.JPopupMenu tablePopupMenuContextMenu;
    private javax.swing.JTable tableTasks;
    private javax.swing.JTextField textfieldFilter;
    // End of variables declaration//GEN-END:variables

}
