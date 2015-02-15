/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 * Used to save, load and use Tasks and Categories
 *
 * @author Ooppa
 */
public class DatabaseManager {

    private Database database;
    private File databaseFile;

    private static final Logger logger = Logger.getLogger(DatabaseManager.class.getName());

    /**
     * Creates a new manager for the Database
     *
     * @see Database
     */
    public DatabaseManager() {
        database = new Database();
    }

    /**
     * Loads a database file into ArrayList
     */
    public void loadDB() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if(returnValue==JFileChooser.APPROVE_OPTION) {
            FileInputStream fileInputStream = null;

            try {
                // Remember what file we opened
                setDatabaseFile(fileChooser.getSelectedFile());

                fileInputStream = new FileInputStream(fileChooser.getSelectedFile());
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                this.database = (Database) objectInputStream.readObject();
                objectInputStream.close();

            } catch(FileNotFoundException ex) {

                Error error = new Error("File was not found.");
                logger.log(Level.WARNING, "File was not found.");

            } catch(IOException ex) {

                Error error = new Error("File could not be read.");
                logger.log(Level.WARNING, "File could not be read.");

            } catch(ClassNotFoundException ex) {

                Error error = new Error("File was not found.");
                logger.log(Level.WARNING, "Could not close File Output Stream.");

            } finally {
                // Finally we close the connection no matter what
                try {
                    fileInputStream.close();
                } catch(IOException ex) {
                    logger.log(Level.WARNING, "Could not close File Output Stream.");
                }

            }

        } else {
            // TODO ERROR
        }
    }

    /*
     * Save current ArrayList in a database file
     */
    public void saveDB() {
        if(getDatabaseFile()==null) {
            // No database found
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);

            if(returnValue==JFileChooser.APPROVE_OPTION) {
                attemptToSaveDB(fileChooser.getSelectedFile());
            } else {
                logger.log(Level.INFO, "FileChooser doesn't approve option given.");
                // TODO
            }
        } else {
            // Database file already found, use that
            attemptToSaveDB(getDatabaseFile());
        }
    }

    /**
     * Returns the ArrayList of Categories in the database.
     *
     * @return Categories
     *
     * @see Category
     */
    public ArrayList<Category> getCategories() {
        return database.getCategories();
    }

    /**
     * Returns the ArrayList of Tasks in the database.
     *
     * @return Tasks
     *
     * @See Task
     */
    public ArrayList<Task> getTasks() {
        return database.getTasks();
    }

    /*
     * Attempts to save the current Database object to the file given
     */
    private void attemptToSaveDB(File file) {
        FileOutputStream fileOutputStream = null;

        try {
            // Let's remember what file we are currently using 
            setDatabaseFile(file);

            fileOutputStream = new FileOutputStream(this.getDatabaseFile());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(database);
            objectOutputStream.close();

        } catch(FileNotFoundException ex) {

            Error error = new Error("File was not found.");
            logger.log(Level.WARNING, "File was not found.");

        } catch(IOException ex) {

            Error error = new Error("File could not be read.");
            logger.log(Level.WARNING, "File could not be read.");

        } finally {
            // Finally we close the connection no matter what

            try {
                fileOutputStream.close();
            } catch(IOException ex) {
                logger.log(Level.WARNING, "Could not close File Output Stream.");
            }

        }
    }
    
    public void createNewDatabase(){
        this.saveDB(); // Save old work
        this.databaseFile = null;
        database = new Database();
        
        this.saveDB();
    }

    /**
     * Sets new Database file. Used to remember what file to override when
     * saving.
     *
     * @param databaseFile File that is currently used as a database.
     */
    public void setDatabaseFile(File databaseFile) {
        this.databaseFile = databaseFile;
    }

    /**
     * Returns the File that is currently used as a database.
     *
     * @return File that is currently used as a database.
     */
    public File getDatabaseFile() {
        return databaseFile;
    }

    /*
     * Converts tasks to JTable readable form
     */
    public DefaultTableModel getTasksAsDefaultTableModel() {

        String[] taskColumns = new String[] {
            "Done", "Task Name", "Task Description", "Priority", "Deadline"
        };

        Object[][] taskRows = new Object[getTasks().size()][taskColumns.length];
        int currentIndex = 0;

        for(Task task : database.getTasks()) {
            taskRows[currentIndex] = new Object[] {"DONE", task.getName(), task.getDescription(), task.getPriority(), task.getDeadlineAsString()};
            currentIndex++;
        }

        return new DefaultTableModel(taskRows, taskColumns);
    }
    
    /*
     * Only displays the tasks that meet with given filter
     */
    public DefaultTableModel getTasksAsDefaultTableModelWithFilter(String filter) {
        // TODO
        return null;
    }

}
