/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Ooppa
 */
public class DeadlineTest {

    private Deadline future;
    private Deadline past;
    private Deadline disabled;

    public DeadlineTest() {
    }

    @Before
    public void setUp() {
        org.joda.time.format.DateTimeFormatter formatter;
        formatter = DateTimeFormat.forPattern("dd.MM.YYYY HH:mm");
        future = new Deadline(formatter.parseDateTime("01.01.2099 12:12"));
        past = new Deadline(formatter.parseDateTime("01.01.1999 12:12"));

        // Not active
        disabled = new Deadline();
    }

    @After
    public void tearDown() {
        future = null;
        past = null;
        disabled = null;
    }

    @Test
    public void testReturnsTrueIfActive() {
        assertFalse(disabled.isActive());
    }

    @Test
    public void testReturnsFalseIfNotActive() {
        assertTrue(future.isActive()&&past.isActive());
    }

    @Test
    public void testSetActive() {
        future.setActive(false);
        disabled.setActive(true);
        assertTrue(
                future.isActive()==false
                &&disabled.isActive()==true
        );
    }

    @Test
    public void testGetDateTimeNotNull() {
        Deadline nulled = new Deadline(null);
        assertTrue(nulled.getDateTime()!=null);
    }

    @Test
    public void testSetDateTime() {
        DateTime previous = future.getDateTime();
        future.setDateTime(new DateTime().plusYears(42));
        assertTrue(previous!=future.getDateTime());
    }

    @Test
    public void testIsPastDeadline() {
        assertTrue(
                future.isPastDeadline()==false
                &&past.isPastDeadline()==true
        );
    }

    @Test
    public void testToString() {
        System.out.println("Eka: "+ disabled.toString());
        System.out.println("Toka: "+ future.toString());
        assertTrue(
                disabled.toString().contains("None")
                &&future.toString().contains("01.01.2099 12:12")
        );
    }

    @Test
    public void testHashCode() {
        assertTrue(future.hashCode()!=past.hashCode()
                &&future.hashCode()==future.hashCode());
    }

    @Test
    public void testEquals() {
        assertTrue(future.equals(future)==true);
    }

}
