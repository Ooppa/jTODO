/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.ui;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import jtodo.domain.Category;
import jtodo.excptions.TooLongInputException;
import jtodo.excptions.TooShortInputException;

/**
 * Window displayed during creation and editing of a Category
 *
 * @author Ooppa
 * @see Category
 */
public class CategoryEditorWindow extends JFrame {
    
    private Category category;
    private static final Logger logger = Logger.getLogger(CategoryEditorWindow.class.getName());

    public CategoryEditorWindow() {
        try {
            this.category = new Category("Name", "Description");
            setTitle("New Category");
            initComponents();
            
        } catch(TooShortInputException|TooLongInputException ex) {
            logger.log(Level.WARNING, "Failed to create Task in TaskEditorWindow");
        }
    }

    public CategoryEditorWindow(Category category) throws HeadlessException {
        setTitle("Edit Category");
        this.category = category;
        initComponents();
    }

    private void initComponents() {
        // TODO components
        pack();
    }
    
    // TODO This
    private void windowSettings() {
        Dimension minimum = new Dimension(500, 300);
        Dimension preferred = new Dimension(1000, 600);

        setSize(preferred);
        setPreferredSize(preferred);
        setMaximumSize(minimum);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
