/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package excptions;

/**
 * Exception thrown when the user input was too short.
 * 
 * @author Ooppa
 */
public class TooShortInputException extends Exception {

    public TooShortInputException() {
        super("The input was too short.");
    }

    public TooShortInputException(String message) {
        super(message);
    }

    public TooShortInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooShortInputException(Throwable cause) {
        super(cause);
    }

}
