/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

/**
 * Priority given to a Task
 * 
 * @author Ooppa
 * @see Task
 */
public enum Priority {
    
    VERY_HIGH(1.5),
    HIGH(1.25),
    NORMAL(1.0),
    LOW(0.75),
    VERY_LOW(0.5),
    IGNORE(0.0);

    private final double value;

    private Priority(double value) {
        this.value = value;
    }

    /**
     * Get priority value as double
     *
     * @return value returns the value as double
     */
    public double getValueAsDouble() {
        return this.value;
    }
    
}
