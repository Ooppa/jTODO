/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.application;

import java.util.logging.Level;
import java.util.logging.Logger;
import jtodo.domain.DatabaseManager;
import jtodo.ui.TaskViewWindow;

/**
 * Starting point for the application.
 *
 * @author Ooppa
 */
public class Application {

    private static final Logger logger = Logger.getLogger(Application.class.getName());

    /**
     * Main-method for the application
     *
     * @param args Select what level logger you want to run the program with
     */
    public static void main(String[] args) {

        try {
            logger.setLevel(Level.parse(args[0]));
        } catch(IllegalArgumentException|ArrayIndexOutOfBoundsException exception) {
            logger.setLevel(Level.OFF);
        }

        logger.log(Level.INFO, "Application started with class path: {0}",
                System.getProperty("java.class.path"));

        DatabaseManager taskList = new DatabaseManager();
        TaskViewWindow taskview = new TaskViewWindow(taskList);

    }

}
