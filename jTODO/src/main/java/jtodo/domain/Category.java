/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import jtodo.excptions.TooLongInputException;
import jtodo.excptions.TooShortInputException;

/**
 * Category used to separate different Tasks
 *
 * @author Ooppa
 * @param <E>
 *
 * @see AbstractListItem
 */
public class Category<E> extends AbstractListItem implements Serializable {

    /**
     * Creates a new Category
     *
     * @param name        Name for the Category
     * @param description Description for the Category
     *
     * @throws TooShortInputException
     * @throws TooLongInputException
     * @see AbstractListItem
     */
    public Category(String name, String description) throws TooShortInputException, TooLongInputException {
        super(name, description);
    }

    /**
     * Removes all tasks associated with this category
     *
     * @see Task#setCategory(jtodo.domain.Category) 
     * @see Task#getCategory() 
     */
    public void removeAllTaskAssociations() {
        ArrayList subElements = this.getSubElements();

        for(Object subElement : subElements) {

            if(subElement instanceof Task) {
                Task task = (Task) subElement;
                task.setCategory(null); // TODO?
            }

        }
    }

    @Override
    public String toString() {
        return "Category "+this.getName()+": "+this.getDescription();
    }

}
