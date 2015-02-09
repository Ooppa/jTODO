/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.application;

import java.util.logging.Level;
import java.util.logging.Logger;
import jtodo.ui.TaskView;

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

        // Main interface for the application
        TaskView taskview = new TaskView();

    }

}
