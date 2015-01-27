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

}
