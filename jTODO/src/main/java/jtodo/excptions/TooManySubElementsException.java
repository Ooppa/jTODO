/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.excptions;

/**
 * Exception thrown when AbstractListItem has too many sub-elements.
 *
 * @author Ooppa
 */
public class TooManySubElementsException extends Exception {

    public TooManySubElementsException() {
        super("This item has too many subelements already.");
    }

    public TooManySubElementsException(String message) {
        super(message);
    }

    public TooManySubElementsException(Throwable cause) {
        super(cause);
    }

    public TooManySubElementsException(String message, Throwable cause) {
        super(message, cause);
    }

}
