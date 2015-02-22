/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import jtodo.excptions.*;

/**
 * Defines items (Task/Category) in a a TaskList
 *
 * @author Ooppa
 * @param <E> Elements contained by this element
 *
 * @see Task
 * @see Category
 */
public abstract class AbstractListItem<E> implements Serializable {

    private String name, description;
    private final ArrayList<E> subElements;
    private ListItemColor color;

    /**
     * Creates a new AbstractListItem
     *
     * @param name        Name for the item
     * @param description Description for the item
     *
     * @throws TooShortInputException if the input is too short.
     * @throws TooLongInputException  if the input is too long.
     * @see ListItemColor
     */
    public AbstractListItem(String name, String description) throws TooShortInputException, TooLongInputException {
        setName(name);
        setDescription(description);
        this.color = ListItemColor.WHITE;
        this.subElements = new ArrayList<>();
    }

    /**
     * Returns the name of the AbstractListItem
     *
     * @return String Name of the AbstractListItem
     */
    public String getName() {
        return name;
    }

    /**
     * Set a new name for the AbstractListItem
     *
     * @param name New name
     *
     * @throws TooLongInputException  if the input is too long.
     * @throws TooShortInputException if the input is too short.
     */
    public void setName(String name) throws TooLongInputException, TooShortInputException {
        if(name==null||name.length()<=3) {
            throw new TooShortInputException("You have to have a name that is atleast 3 characters long.");
        }

        if(name.length()>100) {
            throw new TooLongInputException("Name can't be over 100 characters long.");
        }

        this.name = name;
    }

    /**
     * Returns the description of the AbstractListItem
     *
     * @return String Description of the AbstractListItem
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set a new description for the AbstractListItem
     *
     * @param description New description
     *
     * @throws TooShortInputException if the input is too short.
     * @throws TooLongInputException  if the input is too long.
     */
    public void setDescription(String description) throws TooShortInputException, TooLongInputException {
        if(description==null) {
            // Description can be null, but then it's saved as empty string
            this.description = "";
        } else {
            if(description.length()>1000) {
                throw new TooLongInputException("Description can only be 1000 characters long.");
            }

            this.description = description;
        }
    }

    /**
     * Returns an ArrayList of this AbstractListItem's sub-elements
     *
     * @return ArrayList Sub-elements of this AbstractListItem
     */
    public ArrayList<E> getSubElements() {
        return subElements;
    }

    /**
     * Return the ListItemColor of this AbstractListItem
     *
     * @return ListItemColor Color of the AbstractListItem
     *
     * @see ListItemColor
     */
    public ListItemColor getListItemColor() {
        return color;
    }

    /**
     * Set a new ListItemColor for AbstractListItem
     *
     * @param listItemColor New ListItemColor
     *
     * @see ListItemColor
     */
    public void setColor(ListItemColor listItemColor) {
        if(listItemColor==null) {
            this.color = ListItemColor.WHITE;
        } else {
            this.color = listItemColor;
        }

    }

    /**
     * Adds the given sub-element as a child to this object as long as: 1) there
     * aren't too many sub-elements already 2) the sub-element is not already a
     * child to this object 3) the sub-element is not child it itself
     *
     * @param subElement Sub-element to add
     *
     * @throws TooManySubElementsException    if there are already maximum
     *                                        amount of sub-elements.
     * @throws CouldNotAddSubElementException if the sub-element is null or the
     *                                        parent is the same as child.
     * @throws WrongTypeOfSubElementException if the parent is Task and child is
     *                                        Category.
     */
    public void addSubElement(E subElement) throws TooManySubElementsException, CouldNotAddSubElementException, WrongTypeOfSubElementException {
        if(this.subElements.size()>100) {
            throw new TooManySubElementsException("You can't have more than 100 subelements per item.");
        }

        if(subElement==null) {
            throw new CouldNotAddSubElementException("Sub-element can't be null.");
        }

        if(this.subElements.contains(subElement)) {
            throw new CouldNotAddSubElementException("Sub-element is already a child of this item.");
        }

        if(this.equals(subElement)) {
            throw new CouldNotAddSubElementException("Sub-element can't be sub-element for itself.");
        }

        // If you try to add Category as a subelement to Task
        if(subElement instanceof Category&&this instanceof Task) {
            throw new WrongTypeOfSubElementException("Category can't be sub-element to Task");
        }

        this.subElements.add(subElement);
    }

    /**
     * Removes a sub-element of the AbstractListItem
     *
     * @param subElement Sub-Element to remove
     */
    public void removeSubElement(E subElement) {
        if(subElements.contains(subElement)) {
            this.subElements.remove(subElement);
        }
    }

    /**
     * Deletes all current sub-elements of this AbstractListItem
     */
    public void clearSubElements() {
        this.subElements.clear();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37*hash+Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) {
            return false;
        }
        if(getClass()!=obj.getClass()) {
            return false;
        }
        final AbstractListItem<?> other = (AbstractListItem<?>) obj;
        return Objects.equals(this.name, other.name);
    }

}
