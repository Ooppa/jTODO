/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import jtodo.excptions.TooLongInputException;
import jtodo.excptions.TooShortInputException;
import org.junit.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 *
 * @author Ooppa
 */
public class CategoryTest {

    private final String EXCEPTIONMESSAGE = "Exception during a test: ";

    public CategoryTest() {
    }

    @Test
    public void testCategoryCreation() {
        try {
            Category category = new Category("Name", "Description");

            assertTrue(category.getName().equals("Name")
                    &&category.getDescription().equals("Description")
            );

        } catch(TooShortInputException|TooLongInputException ex) {
            fail(EXCEPTIONMESSAGE+ex);
        }
    }

    @Test
    public void testCategoryToString() {
        try {
            Category category = new Category("Name", "Description");
            String toString = category.toString();

            assertTrue(toString.contains("Category")
                    &&toString.contains(category.getName())
                    &&toString.contains(category.getDescription()));

        } catch(TooShortInputException|TooLongInputException ex) {
            fail(EXCEPTIONMESSAGE+ex);
        }
    }
}
