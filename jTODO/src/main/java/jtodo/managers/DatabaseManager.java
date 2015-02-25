/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.managers;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import jtodo.domain.Category;
import jtodo.domain.Database;
import jtodo.domain.Task;
import jtodo.ui.ErrorWindow;
import jtodo.ui.TaskTableModel;

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
     * Loads a database file into Database object
     */
    public void loadDB() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if(returnValue==JFileChooser.APPROVE_OPTION) {
            attemptToLoadDB(fileChooser.getSelectedFile());
        } else {
            if(returnValue!=JFileChooser.CANCEL_OPTION) {
                ErrorWindow error = new ErrorWindow("FileChooser doesn't approve option given.");
                logger.log(Level.INFO, "FileChooser doesn''t approve option given ({0}).", returnValue);
            }
        }
    }

    /*
     * Save current Database object in a savefile
     */
    public void saveDB() {
        if(getDatabaseFile()==null) {
            // No database found
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);

            if(returnValue==JFileChooser.APPROVE_OPTION) {
                attemptToSaveDB(fileChooser.getSelectedFile());
            } else {
                if(returnValue!=JFileChooser.CANCEL_OPTION) {
                    ErrorWindow error = new ErrorWindow("FileChooser doesn't approve option given.");
                    logger.log(Level.INFO, "FileChooser doesn''t approve option given ({0}).", returnValue);
                }
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
     * @see Database
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
     * @see Database
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
            ErrorWindow error = new ErrorWindow("File was not found.");
            logger.log(Level.WARNING, "File was not found: {0}", ex.toString());
        } catch(IOException ex) {
            ErrorWindow error = new ErrorWindow("File could not be read.");
            logger.log(Level.WARNING, "File could not be read: {0}", ex.toString());
        } finally {
            // Finally we close the connection no matter what
            try {
                fileOutputStream.close();
            } catch(IOException ex) {
                logger.log(Level.WARNING, "Could not close File Output Stream: {0}", ex.toString());
            }
        }
    }

    /*
     * Attempts to load the Database object from file given
     */
    private void attemptToLoadDB(File file) {
        FileInputStream fileInputStream = null;

        try {
            // Remember what file we opened
            setDatabaseFile(file);

            fileInputStream = new FileInputStream(file);
            try(ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                this.database = (Database) objectInputStream.readObject();
            }
        } catch(FileNotFoundException ex) {
            ErrorWindow error = new ErrorWindow("File was not found.");
            logger.log(Level.WARNING, "File was not found: {0}", ex.toString());
        } catch(IOException ex) {
            ErrorWindow error = new ErrorWindow("File could not be read. Might not be proper savefile.");
            logger.log(Level.WARNING, "File could not be read (might not be proper savefile): {0}", ex.toString());
        } catch(ClassNotFoundException ex) {
            ErrorWindow error = new ErrorWindow("Could not close File Output Stream.");
            logger.log(Level.WARNING, "Could not close File Output Stream: {0}", ex.toString());
        } finally {
            // Finally we close the connection no matter what
            try {
                fileInputStream.close();
            } catch(IOException ex) {
                logger.log(Level.WARNING, "Could not close File Output Stream.");
            }
        }
    }

    /*
     * Creates new Database object on top of the existing one.
     */
    public void createNewDatabase() {
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

    /**
     * Returns the task at the given index
     *
     * @param index Index to get
     *
     * @return Task
     */
    public Task getTaskAtIndex(int index) {
        return database.getTasks().get(index);
    }

    /**
     * Converts tasks to JTable readable form
     *
     * @return TaskTableModel
     */
    public TaskTableModel getTasksAsTaskTableModel() {
        return new TaskTableModel(database.getTasks());
    }

    /**
     * Converts tasks to JTable readable form, but
     * only displays the tasks that meet with given filter
     *
     * @param filter Filter results based on String
     *
     * @return TaskTableModel
     */
    public TaskTableModel getTasksAsDefaultTableModelWithFilter(String filter) {
        return new TaskTableModel(database.getTasksWithFilter(filter));
    }

}
