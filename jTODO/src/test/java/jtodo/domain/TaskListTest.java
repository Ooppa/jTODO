/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import org.junit.*;

/**
 * 
 * @author Ooppa
 */
public class TaskListTest {

    private DatabaseManager tasklist;

    public TaskListTest() {
    }

    @Before
    public void setUp() {
        tasklist = new DatabaseManager();
    }

    @After
    public void tearDown() {
        tasklist = null;
    }

    @Test
    public void testLoadDB() {
        // TODO
    }

    @Test
    public void testSaveDB() {
        // TODO
    }

    @Test
    public void testGetCategories() {
        // TODO
    }

    @Test
    public void testGetTasks() {
        // TODO
    }

    @Test
    public void testClearAll() {
        // TODO
    }

}
