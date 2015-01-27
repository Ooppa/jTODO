/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.excptions;

/**
 * Exception thrown when a specific sub-element could not be added to the AbstractListItem.
 * 
 * @author Ooppa
 */
public class CouldNotAddSubElementException extends Exception {

    public CouldNotAddSubElementException() {
        super("Could not add the given sub-element.");
    }
    
    public CouldNotAddSubElementException(String message) {
        super(message);
    }

    public CouldNotAddSubElementException(Throwable cause) {
        super(cause);
    }

    public CouldNotAddSubElementException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
