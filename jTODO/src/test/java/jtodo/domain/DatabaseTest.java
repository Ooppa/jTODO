/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import java.util.ArrayList;
import jtodo.excptions.TooLongInputException;
import jtodo.excptions.TooShortInputException;
import static junit.framework.Assert.assertEquals;
import org.junit.*;

/**
 *
 * @author Ooppa
 */
public class DatabaseTest {
    
    private Database database;
    
    public DatabaseTest() {
    }
    
    @Before
    public void setUp() throws TooLongInputException, TooShortInputException {
        database = new Database();

        database.getTasks().add(new Task("Test", "This is simply a test."));
        database.getTasks().add(new Task("Example", "This is only an example."));
        database.getTasks().add(new Task("Temporary", "This is only temporary."));
        
        Task task = new Task("Advanced Task", "This is really advanced.");
        task.setDeadline("01.01.2022 12:15");
        task.setPriority(Priority.VERY_LOW);
        database.getTasks().add(task);
    }
    
    @After
    public void tearDown() {
        database = null;
    }

    @Test
    public void testGetTasksWithFilterContainsAll() {
        ArrayList<Task> results = database.getTasksWithFilter(".");
        
        // all should be included since they have a dot in them
        assertEquals(4, results.size());
    }
    
    @Test
    public void testGetTasksWithFilterContainsSome() {
        ArrayList<Task> results = database.getTasksWithFilter("only");
        assertEquals(2, results.size());
    }
    
    @Test
    public void testGetTasksWithFilterContainsOne() {
        ArrayList<Task> results = database.getTasksWithFilter("Temporary");
        assertEquals(1, results.size());
    }
    
    @Test
    public void testGetTasksWithFilterContainsNone() {
        ArrayList<Task> results = database.getTasksWithFilter("that");
        assertEquals(0, results.size());
    }
    
    @Test
    public void testGetTasksWithFilterIncludesDeadline() {
        ArrayList<Task> results = database.getTasksWithFilter("2022");
        assertEquals(1, results.size());
    }
    
    @Test
    public void testGetTasksWithFilterIncludespriority() {
        ArrayList<Task> results = database.getTasksWithFilter("VERY LOW");
        assertEquals(1, results.size());
    }
    
}
