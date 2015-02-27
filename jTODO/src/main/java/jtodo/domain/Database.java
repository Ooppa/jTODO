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

    /**
     * Creates a new Database object
     */
    public Database() {
        categories = new ArrayList<>();
        tasks = new ArrayList<>();
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

    public ArrayList<Task> getTasksWithFilter(String filter) {
        ArrayList<Task> filtered = new ArrayList<>();

        for(Task task : tasks) {
            if(doesTaskFitTheFilter(task, filter.toLowerCase())) {
                filtered.add(task);
            }
        }

        return filtered;
    }

    /*
     * Check if the filter String matches anything in the task
     */
    private boolean doesTaskFitTheFilter(Task task, String string) {
        if(task.getName().toLowerCase().contains(string)) {
            return true;
        }

        if(task.getDescription().toLowerCase().contains(string)) {
            return true;
        }

        if(task.getDeadlineAsString().toLowerCase().contains(string)) {
            return true;
        }

        if(task.getPriority().toString().toLowerCase().contains(string)) {
            return true;
        }

        if(task.getCategory()!=null) {
            if(task.getCategory().getName().toLowerCase().contains(string)) {
                return true;
            }
        }

        return false;
    }

}
