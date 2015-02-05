/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import jtodo.excptions.TooLongInputException;
import jtodo.excptions.TooShortInputException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 *
 * @author Ooppa
 */
public class DeadlineTest {

    private Deadline future;
    private Deadline past;
    private Deadline disabled;
    
    private final String EXCEPTIONMESSAGE = "Exception during a test: ";

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
        assertTrue(future.equals(future));
    }
    
    @Test
    public void testNotEquals() {
        assertFalse(future.equals(past));
    }
    
    @Test
    public void testEqualsWrongClass() {
        try {
            Task task = new Task("TODO", "Something");
            assertFalse(future.equals(task));
            
        } catch(TooShortInputException|TooLongInputException ex) {
            fail(EXCEPTIONMESSAGE+ex.toString());
        }
    }
    
    @Test
    public void testEqualsNull() {
        assertFalse(future.equals(null));
    }

}
