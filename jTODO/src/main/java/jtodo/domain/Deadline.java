/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import java.io.Serializable;
import java.util.Objects;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * Defines a deadline for a Task
 *
 * @author Ooppa
 * @see Task
 */
public class Deadline implements Serializable {

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

    /**
     * Creates a new Deadline with given date and status true.
     *
     * @param datetime
     */
    public Deadline(DateTime datetime) {
        if(datetime!=null) {
            this.active = true;
            this.dateTime = datetime;
        } else {
            this.dateTime = new DateTime().plusWeeks(1);
        }
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
        return currentDateTime.isAfter(this.dateTime);
    }

    /*
     * If the deadline is set return the datetime, else return text "None".
     */
    @Override
    public String toString() {
        if(this.active==false) {
            return "None";
        } else {
            org.joda.time.format.DateTimeFormatter formatter;
            formatter = DateTimeFormat.forPattern("dd.MM.YYYY HH:mm");

            return this.dateTime.toString(formatter);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83*hash+(this.active?1:0);
        hash = 83*hash+Objects.hashCode(this.dateTime);
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
        final Deadline other = (Deadline) obj;
        if(this.active!=other.active) {
            return false;
        }
        if(!Objects.equals(this.dateTime, other.dateTime)) {
            return false;
        }
        return true;
    }

}
