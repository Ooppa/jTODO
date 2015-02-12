/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 * Used to save, load and use Tasks and Categories
 *
 * @author Ooppa
 */
public class TaskList implements Serializable {

    private ArrayList<Category> categories;
    private ArrayList<Task> tasks;
    private File databaseFile;

    /**
     * Creates a new empty list of Tasks and Categories
     *
     * @see Task
     * @see Category
     */
    public TaskList() {
        categories = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    /**
     * Loads a database file into ArrayList
     */
    public void loadDB() {
        // TODO
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        
        if(returnValue==JFileChooser.APPROVE_OPTION) {
            setDatabaseFile(fileChooser.getSelectedFile());
            clearAll();
        } else {
            // TODO ERROR
        }
    }

    /*
     * Save current ArrayList in a database file
     */
    public void saveDB() {
        // TODO
    }

    /**
     * Returns a list of Categories saved
     *
     * @return List of Categories
     *
     * @see Category
     */
    public ArrayList<Category> getCategories() {
        return categories;
    }

    /**
     * Returns a list of Tasks saved
     *
     * @return List of Tasks
     *
     * @see Task
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Sets new Database file. Used to remember what file to override when saving.
     * @param databaseFile File that is currently used as a database.
     */
    public void setDatabaseFile(File databaseFile) {
        this.databaseFile = databaseFile;
    }

    /**
     * Returns the File that is currently used as a database.
     * @return File that is currently used as a database.
     */
    public File getDatabaseFile() {
        return databaseFile;
    }
    
    /*
     * Converts a databasefile to object
     */
    private void fileToObject(File file){
        // TODO
    }

    /*
     * Clears all saved Tasks and Categories
     */
    public void clearAll() {
        this.categories.clear();
        this.tasks.clear();
    }

}
