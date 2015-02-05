/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.excptions;

/**
 *
 * @author Ooppa
 */
public class WrongTypeOfSubElementException extends Exception {

    public WrongTypeOfSubElementException() {
        super("Wrong type of sub-element!");
    }

    public WrongTypeOfSubElementException(String message) {
        super(message);
    }

    public WrongTypeOfSubElementException(Throwable cause) {
        super(cause);
    }

    public WrongTypeOfSubElementException(String message, Throwable cause) {
        super(message, cause);
    }

}
