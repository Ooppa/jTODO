/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import jtodo.excptions.TooLongInputException;
import jtodo.excptions.TooShortInputException;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Ooppa
 */
public class TaskTest {

    private Task testTask;

    private final String EXCEPTIONFAILTEXT = "Exception failed the test.";
    private final String EXCEPTIONMESSAGE = "Exception during a test: ";

    public TaskTest() {
    }

    @Before
    public void setUp() {
        try {
            testTask = new Task("Task Name", "Task Description");
            testTask.setPriority(Priority.HIGH);
            testTask.setDeadline("01.01.2015 12:00");
        } catch(TooShortInputException|TooLongInputException ex) {
            System.out.println("Exception during a setup process: "+ex.toString());
        }
    }

    @After
    public void tearDown() {
        testTask = null;
    }

    @Test
    public void testGetPriority() {
        assertTrue(testTask.getPriority()==Priority.HIGH);
    }

    @Test
    public void testSetPriority() {
        testTask.setPriority(Priority.LOW);
        assertTrue(testTask.getPriority()==Priority.LOW);
    }

    @Test
    public void testIfDeadlineIsActive() {
        assertTrue(testTask.isDeadlineActive()==true);
    }

    @Test
    public void testSetDeadlineActive() {
        testTask.setDeadlineActive(false);
        assertTrue(testTask.isDeadlineActive()==false);
    }

    @Test
    public void testGetDeadlineAsString() {
        assertEquals(testTask.getDeadlineAsString(), "01.01.2015 12:00");
    }
    
    @Test
    public void testGetDeadlineAsStringWhenNotActive() {
        testTask.setDeadlineActive(false);
        assertEquals(testTask.getDeadlineAsString(), "None");
    }

    @Test
    public void testSetDeadline() {
        testTask.setDeadline("02.02.2015 20:20");
        assertEquals(testTask.getDeadlineAsString(), "02.02.2015 20:20");
    }

}
