/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import java.awt.Color;

/**
 * Defines a highlight color for AbstractListItem.
 *
 * @author Ooppa
 * @see AbstractListItem
 * @see Color
 */
public enum ListItemColor {

    RED(Color.decode("#ffbfbf")),
    ORANGE(Color.decode("#ffdfbf")),
    YELLOW(Color.decode("#ffff40")),
    GREEN(Color.decode("#bfffbf")),
    BLUE(Color.decode("#bfbfff")),
    PURPLE(Color.decode("#dfbfff")),
    GREY(Color.decode("#bfbfbf")),
    WHITE(Color.decode("#ffffff"));

    private final Color color;

    private ListItemColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    /**
     * Returns true if this is the same color as the other.
     *
     * @param ListItemColor Color to compare to
     *
     * @return boolean
     */
    public boolean equals(ListItemColor otherColor) {
        return this.getColor().equals(otherColor.getColor());
    }

    /**
     * Returns all ListItemColors as Color
     *
     * @return Colors
     */
    public static Color[] getColorsInArray() {
        Color[] colors = new Color[ListItemColor.values().length];
        int currentIndex = 0;

        for(ListItemColor colorToAdd : ListItemColor.values()) {
            colors[currentIndex] = colorToAdd.getColor();
            currentIndex++;
        }

        return colors;
    }

    /**
     * Returns ListItemColors from given index.
     * If not in range - returns white.
     *
     * @return ListItemColor
     */
    public static ListItemColor getListItemColorFromIndex(int index) {
        ListItemColor[] listItemColors = ListItemColor.values();

        try {
            return listItemColors[index];
        } catch(ArrayIndexOutOfBoundsException ex) {
            return ListItemColor.WHITE;
        }
    }
    
    public static int getIndexFromListItemColor(ListItemColor color) {
        ListItemColor[] values = ListItemColor.values();
        
        for(int i = 0; i<values.length; i++) {
            if(values[i].equals(color)){
                return i;
            }
        }
        
        return values.length-1;
    }

}
