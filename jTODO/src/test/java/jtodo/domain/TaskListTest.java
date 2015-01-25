/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import java.lang.reflect.Method;
import org.junit.*;
import static org.junit.Assert.assertTrue;

/**
 * Tests if TaskList properly extends ArrayList
 *
 * @author Ooppa
 * @see ArrayList
 */
public class TaskListTest {

    private final Method[] methods;

    public TaskListTest() {
        methods = TaskList.class.getMethods();
    }

    @Test
    public void TaskListContainsMethodAdd() {
        assertTrue(arrayContainsMethod("add"));
    }

    @Test
    public void TaskListContainsMethodRemove() {
        assertTrue(arrayContainsMethod("remove"));
    }

    @Test
    public void TaskListContainsMethodSize() {
        assertTrue(arrayContainsMethod("size"));
    }

    private boolean arrayContainsMethod(String methodName) {
        for(Method method : methods) {
            if(method.getName()==methodName) {
                return true;
            }
        }

        return false;
    }

}
