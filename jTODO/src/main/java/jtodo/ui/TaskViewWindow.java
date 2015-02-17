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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import jtodo.domain.Category;
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
     *
     * @see DatabaseManager
     */
    public TaskViewWindow(DatabaseManager tasklist) {
        this.autosave = false; // On default this is off
        this.databaseManager = tasklist;

        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);

        updateTable();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablePopupMenuContextMenu = new javax.swing.JPopupMenu();
        popupMenuItemEditTask = new javax.swing.JMenuItem();
        popupMenuSubmenuCategories = new javax.swing.JMenu();
        popupMenuSubMenuCategoryItemDefault = new javax.swing.JMenuItem();
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

        popupMenuItemEditTask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        popupMenuItemEditTask.setText("Edit...");
        popupMenuItemEditTask.setToolTipText("");
        popupMenuItemEditTask.setName("popupMenuItemEditTask"); // NOI18N
        popupMenuItemEditTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupMenuItemEditTaskActionPerformed(evt);
            }
        });
        tablePopupMenuContextMenu.add(popupMenuItemEditTask);

        popupMenuSubmenuCategories.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/category.png"))); // NOI18N
        popupMenuSubmenuCategories.setText("Set Category");
        popupMenuSubmenuCategories.setName("popupMenuSubmenuCategories"); // NOI18N

        popupMenuSubMenuCategoryItemDefault.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        popupMenuSubMenuCategoryItemDefault.setText("Default");
        popupMenuSubMenuCategoryItemDefault.setToolTipText("Default category for all tasks.");
        popupMenuSubMenuCategoryItemDefault.setName("popupMenuSubmenuCategoryItemDefault"); // NOI18N
        popupMenuSubMenuCategoryItemDefault.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupMenuSubMenuCategoryItemDefaultActionPerformed(evt);
            }
        });
        popupMenuSubmenuCategories.add(popupMenuSubMenuCategoryItemDefault);

        tablePopupMenuContextMenu.add(popupMenuSubmenuCategories);

        popupMenuItemDeleteTask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cross.png"))); // NOI18N
        popupMenuItemDeleteTask.setText("Delete...");
        popupMenuItemDeleteTask.setToolTipText("");
        popupMenuItemDeleteTask.setName("popupMenuItemDeleteTask"); // NOI18N
        popupMenuItemDeleteTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupMenuItemDeleteTaskActionPerformed(evt);
            }
        });
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

        TaskTableModel tableModel = new TaskTableModel(this.databaseManager.getTasks());
        tableTasks.setModel(tableModel);
        tableTasks.setColumnSelectionAllowed(true);
        tableTasks.setName("tableTasks"); // NOI18N
        tableTasks.setRowHeight(20);
        tableTasks.setAutoCreateRowSorter(true); // Automatically creates the row sorters
        tableTasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableTasksMouseReleased(evt);
            }
        });
        scrollPanelForTasks.setViewportView(tableTasks);
        tableTasks.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tableTasks.getColumnModel().getColumnCount() > 0) {
            tableTasks.getColumnModel().getColumn(0).setResizable(false);
            tableTasks.getColumnModel().getColumn(0).setPreferredWidth(5);
        }
        // Right-click popup menu
        //TODO tableTasks.setComponentPopupMenu(tablePopupMenuContextMenu);

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

    /*
     * Button at the menubar - Under Edit - Always on top
     */
    private void menuItemCheckboxAlwaysOnTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCheckboxAlwaysOnTopActionPerformed
        if(menuItemCheckboxAlwaysOnTop.isSelected()) {
            this.setAlwaysOnTop(true);
        } else {
            this.setAlwaysOnTop(false);
        }

        logEvent(evt);
    }//GEN-LAST:event_menuItemCheckboxAlwaysOnTopActionPerformed

    /*
     * Button at the menubar - Under Edit - Autosave
     */
    private void menuItemCheckboxAutosaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCheckboxAutosaveActionPerformed
        this.autosave = menuItemCheckboxAutosave.getState();
        logEvent(evt);
    }//GEN-LAST:event_menuItemCheckboxAutosaveActionPerformed

    /*
     * Button at the menubar - Under File - Load Tasklist
     */
    private void menuItemLoadTasklistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLoadTasklistActionPerformed
        databaseManager.loadDB();
        updateTable();

        logEvent(evt);
    }//GEN-LAST:event_menuItemLoadTasklistActionPerformed

    /*
     * Button at the menubar - Under File - Save Tasklist (shortcut: Ctrl+S)
     */
    private void menuItemSaveTasklistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSaveTasklistActionPerformed
        databaseManager.saveDB();
        logEvent(evt);
    }//GEN-LAST:event_menuItemSaveTasklistActionPerformed

    /*
     * Button at the menubar - Under File - New Tasklist (shortcut: Ctrl+N)
     */
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
     * When the caret is updated, run a check which tasks fit the given
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

    /*
     * Button at the bottom-right corner
     */
    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        TaskEditorWindow taskEditorWindow = new TaskEditorWindow(this);
        logEvent(evt);
    }//GEN-LAST:event_buttonAddActionPerformed

    /*
     * Button at the menubar - Under categories - New Category
     */
    private void menuItemNewCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNewCategoryActionPerformed
        CategoryEditorWindow categoryEditorWindow = new CategoryEditorWindow(this, databaseManager);
        categoryEditorWindow.setTaskViewWindow(this); // So we can update the list later

        logEvent(evt);
    }//GEN-LAST:event_menuItemNewCategoryActionPerformed

    /*
     * Button at the menubar - Under categories - View Categories
     */
    private void menuItemViewCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemViewCategoriesActionPerformed
        ListCategoriesWindow listCategories = new ListCategoriesWindow(this, databaseManager);

        logEvent(evt);
    }//GEN-LAST:event_menuItemViewCategoriesActionPerformed

    /*
     * Button at the menubar - Under Edit - Refresh (shortcut: F5)
     */
    private void menuItemRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRefreshActionPerformed
        updateTable();
        logEvent(evt);
    }//GEN-LAST:event_menuItemRefreshActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        logEvent(evt);

        // If Ctrl+N is pressed
        if(evt.getKeyChar()==KeyEvent.VK_N&&evt.getModifiers()==InputEvent.CTRL_MASK) {
            // Turha? :D TODO
        }


    }//GEN-LAST:event_formKeyPressed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        logEvent(evt);

        // If Ctrl+N is pressed
        if(evt.getKeyChar()==KeyEvent.VK_N&&evt.getModifiers()==InputEvent.CTRL_MASK) {
            // Turha? :D TODO
        }
    }//GEN-LAST:event_formKeyTyped

    /*
     * Button at the JTable rightclick popupmenu - Edit...
     */
    private void popupMenuItemEditTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupMenuItemEditTaskActionPerformed
        // Only if row is selected
        if(tableTasks.convertRowIndexToModel(tableTasks.getSelectedRow())!=-1) {
            TaskEditorWindow taskEditorWindow = new TaskEditorWindow(this, databaseManager.getTaskAtIndex(tableTasks.convertRowIndexToModel(tableTasks.getSelectedRow())));
        }

        logEvent(evt);
    }//GEN-LAST:event_popupMenuItemEditTaskActionPerformed

    /*
     * Button at the JTable rightclick popupmenu - Delete...
     */
    private void popupMenuItemDeleteTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupMenuItemDeleteTaskActionPerformed
        // Only if row is selected
        if(tableTasks.convertRowIndexToModel(tableTasks.getSelectedRow())!=-1) {
            databaseManager.getTasks().remove(databaseManager.getTaskAtIndex(tableTasks.convertRowIndexToModel(tableTasks.getSelectedRow())));
            updateTable(); // TODO?
        }

        logEvent(evt);
    }//GEN-LAST:event_popupMenuItemDeleteTaskActionPerformed

    private void tableTasksMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTasksMouseReleased
        int rowPoint = tableTasks.rowAtPoint(evt.getPoint());

        if(rowPoint>=0&&rowPoint<tableTasks.getRowCount()) {
            tableTasks.setRowSelectionInterval(rowPoint, rowPoint);
        } else {
            tableTasks.clearSelection();
        }

        int rowindex = tableTasks.convertRowIndexToModel(tableTasks.getSelectedRow());

        if(rowindex<0) {
            return; // -1 is mark for empty selection
        }

        if(evt.isPopupTrigger()&&evt.getComponent() instanceof JTable) {
            JPopupMenu popup = this.tablePopupMenuContextMenu;
            popup.show(evt.getComponent(), evt.getX(), evt.getY());
        }

        logEvent(evt);
    }//GEN-LAST:event_tableTasksMouseReleased

    /*
     * Button at the JTable rightclick popupmenu - Set Category - Default
     */
    private void popupMenuSubMenuCategoryItemDefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupMenuSubMenuCategoryItemDefaultActionPerformed
        // Only if row is selected
        if(tableTasks.convertRowIndexToModel(tableTasks.getSelectedRow())!=-1) {

            // TODO this, maybe?
            /*
             * TableModel model = tableTasks.getModel();
             * TaskTableModel taskTableModel = (TaskTableModel) model;
             * taskTableModel.getTask(tableTasks.getSelectedRow());
             */
            Task taskSelected = databaseManager.getTaskAtIndex(tableTasks.convertRowIndexToModel(tableTasks.getSelectedRow()));
            taskSelected.setCategory(null); // No category is the default category
        }

        logEvent(evt);
    }//GEN-LAST:event_popupMenuSubMenuCategoryItemDefaultActionPerformed

    /**
     * Add a new task to table and update the table
     *
     * @param task Task to add
     *
     * @see Task
     * @see DatabaseManager#getTasks()
     */
    public void addNewTask(Task task) {
        databaseManager.getTasks().add(task);
        updateTable();

        logger.log(Level.INFO, "New task added to tasklist and JTable updated: {0}", task.toString());
    }

    /**
     * Updates the JTable that contains the tasks to match the data in the DB
     * If the automatic saving is turned on this will also save the DB.
     *
     * @see TaskViewWindow#tableTasks
     * @see TaskViewWindow#databaseManager
     * @see TaskViewWindow#autosave
     */
    public void updateTable() {
        if(autosave==true) {
            databaseManager.saveDB();
        }

        TaskTableModel generatedTaskTableModel = databaseManager.getTasksAsTaskTableModel();
        generatedTaskTableModel.setTable(tableTasks);
        tableTasks.setModel(generatedTaskTableModel);

        // Name
        tableTasks.getColumnModel().getColumn(0).setCellRenderer(new TaskTableCategoryBasedCellRenderer(generatedTaskTableModel));

        // Description
        tableTasks.getColumnModel().getColumn(1).setCellRenderer(new TaskTableCategoryBasedCellRenderer(generatedTaskTableModel));

        // Priority
        tableTasks.getColumnModel().getColumn(2).setCellRenderer(new TaskTableCategoryBasedCellRenderer(generatedTaskTableModel));

        // TODO Deadline
        tableTasks.getColumnModel().getColumn(3).setCellRenderer(new TaskTableDeadlineBasedCellRenderer(generatedTaskTableModel));

        updateCategoryPopupSubmenu(); // Also update the submenu that contains the categories
    }

    /**
     * Updates the pop-up menu which contains all the categories
     *
     * @see Category
     * @see TaskViewWindow#popupMenuSubMenuCategoryItemDefault
     */
    public void updateCategoryPopupSubmenu() {
        ArrayList<Category> categories = databaseManager.getCategories();

        // Clear the menu from old pop-up submenus
        popupMenuSubmenuCategories.removeAll();

        // Add the default menuitem
        popupMenuSubmenuCategories.add(popupMenuSubMenuCategoryItemDefault);

        // Add custom categories created by the user
        for(Category category : categories) {
            CustomCategoryJMenuItem jmenuItem = new CustomCategoryJMenuItem();
            jmenuItem.setCategory(category); // Associate the category

            // Name of the Category
            jmenuItem.setText(category.getName());

            // Description of the Category 
            if(category.getDescription().length()!=0) {
                jmenuItem.setToolTipText(category.getDescription());
            } else {
                jmenuItem.setToolTipText("No description");
            }

            // Color or the Category
            jmenuItem.setBackground(category.getListItemColor().getColor());

            jmenuItem.addActionListener(new java.awt.event.ActionListener() {

                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    logEvent(evt);

                    if(tableTasks.convertRowIndexToModel(tableTasks.convertRowIndexToModel(tableTasks.getSelectedRow()))!=-1) {
                        Object sourceObject = evt.getSource();
                        CustomCategoryJMenuItem customCategoryJMenuItem = (CustomCategoryJMenuItem) sourceObject;

                        Task taskSelected = databaseManager.getTaskAtIndex(tableTasks.convertRowIndexToModel(tableTasks.getSelectedRow()));
                        taskSelected.setCategory(customCategoryJMenuItem.getCategory());

                        logger.log(Level.INFO, "Changing the category of '"+taskSelected.toString()+"' to '"+customCategoryJMenuItem.getCategory().toString()+"'");
                    }
                }

            });

            popupMenuSubmenuCategories.add(jmenuItem);
        }
    }

    /**
     * Returns the DatabaseManager
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
        logger.log(Level.INFO, "User performed action: {0}", evt.toString());
    }

    /*
     * Logs the MouseEvent that the user performs.
     */
    private void logEvent(MouseEvent evt) {
        logger.log(Level.INFO, "User performed mouse-action: "+"mousebutton_{0} at [{1},{2}] with {3} clicks", new Object[] {evt.getButton(), evt.getXOnScreen(), evt.getYOnScreen(), evt.getClickCount()});
    }

    /*
     * Logs the KeyEvent that the user performs.
     */
    private void logEvent(KeyEvent evt) {
        logger.log(Level.INFO, "User performed keyboard-action: {0} with modifier {1}", new Object[] {evt.getKeyChar(), evt.getModifiers()});
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
    private javax.swing.JMenuItem popupMenuSubMenuCategoryItemDefault;
    private javax.swing.JMenu popupMenuSubmenuCategories;
    private javax.swing.JScrollPane scrollPanelForTasks;
    private javax.swing.JMenu submenuCategory;
    private javax.swing.JMenu submenuEdit;
    private javax.swing.JMenu submenuFile;
    private javax.swing.JPopupMenu tablePopupMenuContextMenu;
    private javax.swing.JTable tableTasks;
    private javax.swing.JTextField textfieldFilter;
    // End of variables declaration//GEN-END:variables

}
