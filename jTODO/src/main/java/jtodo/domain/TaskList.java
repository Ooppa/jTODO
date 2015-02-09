/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import java.util.ArrayList;

/**
 * Used to save, load and use Tasks and Categories
 *
 * @author Ooppa
 */
public class TaskList {

    private ArrayList<Category> categories;
    private ArrayList<Task> tasks;

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

    public void loadDB() {

    }

    public void saveDB() {

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

    /*
     * Clears all saved Tasks and Categories
     */
    public void clearAll() {
        this.categories.clear();
        this.tasks.clear();
    }

}
