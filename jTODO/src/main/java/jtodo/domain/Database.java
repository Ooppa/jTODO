/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Wrapper that can be saved to a file using Serializable class.
 *
 * @author Ooppa
 */
public class Database implements Serializable {

    private ArrayList<Category> categories;
    private ArrayList<Task> tasks;

    private long savetime;

    /**
     * Creates a new Database object
     */
    public Database() {
        categories = new ArrayList<>();
        tasks = new ArrayList<>();

        updateSavetime();
    }

    /**
     * Returns the Categories packed in ArrayList
     *
     * @return Categories
     *
     * @see Category
     */
    public ArrayList<Category> getCategories() {
        return categories;
    }

    /**
     * Returns the Tasks packed in ArrayList
     *
     * @return Tasks
     *
     * @see Task
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /*
     * Updates the "last edited" timestamp
     */
    public void updateSavetime() {
        savetime = System.nanoTime();
    }

}
