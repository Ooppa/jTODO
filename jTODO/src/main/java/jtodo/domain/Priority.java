/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

/**
 * Priority given to a Task
 * 
 * @author Ooppa
 * @see Task
 */
public enum Priority {
    
    VERY_HIGH(1.5, "Very high"),
    HIGH(1.25, "High"),
    NORMAL(1.0, "Normal"),
    LOW(0.75, "Low"),
    VERY_LOW(0.5, "Very low"),
    IGNORE(0.0, "Ignored");

    private final double value;
    private final String literal;

    private Priority(double value, String literal) {
        this.value = value;
        this.literal = literal;
    }

    /**
     * Get priority value as double
     *
     * @return value returns the value as double
     */
    public double getValueAsDouble() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.literal;
    }
    
    

}
