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

    public Database() {
        categories = new ArrayList<>();
        tasks = new ArrayList<>();
        
        updateSavetime();
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void updateSavetime() {
        savetime = System.nanoTime();
    }

}
