/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import jtodo.excptions.TooLongInputException;
import jtodo.excptions.TooShortInputException;
import org.joda.time.format.DateTimeFormat;

/**
 *
 * @author Ooppa
 * @param <E>
 *
 * @see AbstractListItem
 */
public class Task<E> extends AbstractListItem {

    private Priority priority;
    private final Deadline deadline;

    /**
     * Creates a new Task
     *
     * @param name        Name for the Task
     * @param description Description for the Task
     *
     * @throws TooShortInputException
     * @throws TooLongInputException
     * @see AbstractListItem
     */
    public Task(String name, String description) throws TooShortInputException, TooLongInputException {
        super(name, description);
        this.priority = Priority.NORMAL;
        this.deadline = new Deadline();
    }

    /**
     * Returns the priority of the Task
     *
     * @return Priority
     *
     * @see Priority
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Set new priority for this Task
     *
     * @param priority New priority
     *
     * @see Priority
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /**
     * Returns true if deadline is active and false if it's not
     *
     * @return boolean
     */
    public boolean isDeadlineActive() {
        return this.deadline.isActive();
    }

    /**
     * Set deadline to active or not active mode
     *
     * @param state New state for the Deadline
     */
    public void setDeadlineActive(boolean state) {
        this.deadline.setActive(state);
    }

    /**
     * Returns the deadline represented as a String
     *
     * @return String
     */
    public String getDeadlineAsString() {
        return this.deadline.toString();
    }

    /**
     * Set new DateTime as the Deadline time from a string input.
     *
     * @param dateTime DateTime as a String
     *
     * @see DateTime
     */
    public void setDeadline(String dateTime) {
        org.joda.time.format.DateTimeFormatter formatter;
        formatter = DateTimeFormat.forPattern("dd.MM.YYYY HH:mm");

        this.deadline.setActive(true); // forced active
        this.deadline.setDateTime(formatter.parseDateTime(dateTime));
    }

    @Override
    public String toString() {
        return "Task "+this.getName()+": "+this.getDescription()
                +" (Priority: "+this.getPriority().toString()+" Deadline: + "
                +this.getDeadlineAsString()+")";
    }
}
