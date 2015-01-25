/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import org.joda.time.format.DateTimeFormat;

/**
 *
 * @author Ooppa
 * @param <E>
 * @see AbstractListItem
 */
public class Task<E> extends AbstractListItem {
    
    private Priority priority;
    private final Deadline deadline;

    public Task(String name, String description) {
        super(name, description);
        this.priority = Priority.NORMAL;
        this.deadline = new Deadline();
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public boolean isDeadlineActive(){
        return this.deadline.isActive();
    }
    
    public void setDeadlineActive(boolean state) {
        this.deadline.setActive(state);
    }
    
    public String getDeadlineAsString() {
        return this.deadline.toString();
    }
    
    public void setDeadline(String dateTime) {
        org.joda.time.format.DateTimeFormatter formatter;
        formatter = DateTimeFormat.forPattern("dd.MM.YYYY hh:mm");
        
        this.deadline.setActive(true); // forced active
        this.deadline.setDateTime(formatter.parseDateTime(dateTime));
    }
    
}
