/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.ui;

import jtodo.domain.Category;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Window displayed during creation and editing of a Category
 *
 * @author Ooppa
 * @see Category
 */
public class CategoryEditorWindow extends JFrame {
    
    private Category category;

    public CategoryEditorWindow() {
        this.category = new Category("Name", "Description");
        setTitle("New Category");
        initComponents();
    }

    public CategoryEditorWindow(Category category) throws HeadlessException {
        setTitle("Edit Category");
        this.category = category;
    }

    private void initComponents() {
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
