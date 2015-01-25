/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import java.util.ArrayList;

/**
 *
 * @author Ooppa
 * @param <E> Elements contained by this element
 */
public abstract class AbstractListItem<E> {

    private String name, description;
    private final ArrayList<E> subElements;
    private ListItemColor color;

    public AbstractListItem(String name, String description) {
        this.name = name;
        this.description = description;
        this.color = ListItemColor.WHITE;
        this.subElements = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<E> getSubElements() {
        return subElements;
    }

    public ListItemColor getColor() {
        return color;
    }

    public void setColor(ListItemColor color) {
        this.color = color;
    }

    public void addSubElement(E subElement) {
        // TODO
    }
    
    public void removeSubElement(E subElement) {
        // TODO
    }
    
    public void clearSubElements() {
        this.subElements.clear();
    }

}
