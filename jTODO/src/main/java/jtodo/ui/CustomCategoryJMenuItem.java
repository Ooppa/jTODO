/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.ui;

import java.awt.Color;
import javax.swing.JMenuItem;
import jtodo.domain.Category;
import jtodo.domain.ListItemColor;

/**
 * Custom JMenuItem that also contains the Category associated
 *
 * @author Ooppa
 *
 * @see Category
 * @see JMenuItem
 */
public class CustomCategoryJMenuItem extends JMenuItem {

    /**
     * The Category associated with this JMenuItem
     */
    private Category category;

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Returns the color associated with the Category
     *
     * @return Color associated with the Category
     *
     * @see Color
     * @see Category
     */
    public Color getCategoryColor() {
        if(category!=null) {
            return category.getListItemColor().getColor();
        } else {
            // White is the default color
            return ListItemColor.WHITE.getColor();
        }
    }
}
