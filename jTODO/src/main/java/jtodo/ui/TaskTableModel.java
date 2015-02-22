/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.ui;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import jtodo.domain.Task;

/**
 * Defines the TableModel used in the TaskViewWindow
 *
 * @author Ooppa
 *
 * @see Task
 * @see TaskViewWindow#tableTasks
 * @see AbstractTableModel
 */
public class TaskTableModel extends AbstractTableModel {

    /*
     * Header names for the JTable
     */
    private String[] headers;

    private JTable table;

    /*
     * ArrayList of content
     */
    private ArrayList<Task> tasks;

    private static final Logger logger = Logger.getLogger(TaskTableModel.class.getName());

    /**
     * Creates new TaskTableModel
     *
     * @param tasks Tasks to add, headers are automatically added
     *
     * @see Task
     */
    public TaskTableModel(ArrayList<Task> tasks) {
        this.tasks = new ArrayList<>(tasks);
        this.headers = new String[] {"Name", "Description", "Priority", "Deadline"};
    }

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return 4; // Name, Description, Priority, Deadline
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Task task = tasks.get(rowIndex);

            if(columnIndex==0) {
                return task.getName(); // String
            }

            if(columnIndex==1) {
                return task.getDescription(); // String
            }

            if(columnIndex==2) {
                return task.getPriority().toString(); // String
            }

            if(columnIndex==3) {
                return task.getDeadlineAsString(); // String
            }
        } catch(IndexOutOfBoundsException ex) {
            logger.log(Level.WARNING, "Tried to retrieve a row from table with an empty index.");
        }

        logger.log(Level.WARNING, "Tried to retrieve a column from table with an empty index.");
        return "None";
    }

    @Override
    public String getColumnName(int columnIndex) {
        try {
            return headers[columnIndex];
        } catch(ArrayIndexOutOfBoundsException ex) {
            logger.log(Level.WARNING, "Tried to retrieve a colmuns header from table with an empty index.");
            return "None";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(tasks.isEmpty()) {
            return Object.class;
        }

        return this.getValueAt(0, columnIndex).getClass();
    }

    /**
     * Returns the tasks associated with this TableModle
     *
     * @return The tasks
     *
     * @see Task
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Set new ArrayList of tasks for this TableModle
     *
     * @param tasks The tasks to set
     *
     * @see Task
     */
    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns the task at specified row
     *
     * @param rowIndex Row of the task
     *
     * @return Task
     *
     * @see Task
     */
    public Task getTask(int rowIndex) {
        return tasks.get(rowIndex);
    }

    /**
     * Returns the relative task at specified row
     *
     * @param rowIndex Row of the task
     *
     * @return Task
     *
     * @see Task
     */
    public Task getRelativeTask(int rowIndex) {
        return tasks.get(table.convertRowIndexToModel(rowIndex));
    }

    /**
     * Returns the table given to the TaskTableModel
     *
     * @return the table
     */
    public JTable getTable() {
        return table;
    }

    /**
     * Set new table to the TaskTableModel
     *
     * @param table the table to set
     */
    public void setTable(JTable table) {
        this.table = table;
    }

}
