/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import org.joda.time.DateTime;

/**
 * Defines a deadline for a Task
 *
 * @author Ooppa
 * @see Task
 */
public class Deadline {

    private boolean active;
    private DateTime dateTime;

    /**
     * Creates a new Deadline with the following default values:
     * Active: Not active
     * DateTime: 1 week from now
     */
    public Deadline() {
        this.active = false;
        this.dateTime = new DateTime().plusWeeks(1);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Returns true if the deadline has passed else returns false
     *
     * @return boolean
     */
    public boolean isPastDeadline() {
        DateTime currentDateTime = new DateTime();
        return this.dateTime.isAfter(currentDateTime);
    }

    /*
     * If the deadline is set return the datetime, else return text ("None").
     */
    @Override
    public String toString() {
        if(this.active==false) {
            return "None";
        } else {
            return this.dateTime.toString();
        }
    }

}
