/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

/**
 * Defines a month.
 * Only used to replace functionality if not run in Java 8
 *
 * @author Ooppa
 */
public enum Month {

    JANUARY(1, "January"),
    FEBRUARY(2, "February"),
    MARCH(3, "March"),
    APRIL(4, "April"),
    MAY(5, "May"),
    JUNE(6, "June"),
    JULY(7, "July"),
    AUGUST(8, "August"),
    SEPTEMBER(9, "September"),
    OCTOBER(10, "October"),
    NOVEMBER(11, "November"),
    DECEMBER(12, "December");

    private final int number;
    private final String literal;

    private Month(int number, String literal) {
        this.number = number;
        this.literal = literal;
    }

    /**
     * Returns the numeric value of the Month
     * @return Value of the month
     */
    public int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return literal;
    }

}
