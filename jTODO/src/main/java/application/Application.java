/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package application;

import domain.Category;
import domain.Task;
import domain.TaskList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.MainWindow;

/**
 * Starting point for the application.
 * @author Ooppa
 */
public class Application {
    
    private static final Logger logger = Logger.getLogger(Application.class.getName());
    
    /**
     * Main-method for the program
     * @param args Select what level logger you want to run with the program.
     */
    public static void main(String[] args) {
        
        try {
            logger.setLevel(Level.parse(args[0]));
        } catch ( IllegalArgumentException | ArrayIndexOutOfBoundsException exception ) {
            logger.setLevel(Level.OFF);
        }
        
        MainWindow gui = new MainWindow();
        
        TaskList list = new TaskList();
        
        Task task = new Task("Vie pyykit", "Muista viedä pyykit");
        Category category = new Category("OTM", "Ohjelmistotekniikan menetelmät");
        category.addSubElement(task);
        
        list.add(category);
        
        
    }
    
}
