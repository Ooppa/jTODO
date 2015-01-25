/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.excptions;

/**
 * Exception thrown when the user input was too long.
 * 
 * @author Ooppa
 */
public class TooLongInputException extends Exception {

    public TooLongInputException() {
        super("The input was too long.");
    }

    public TooLongInputException(String message) {
        super(message);
    }

    public TooLongInputException(Throwable cause) {
        super(cause);
    }

    public TooLongInputException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    
}
