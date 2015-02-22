/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import jtodo.excptions.*;
import org.junit.*;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Ooppa
 */
public class CategoryTest {

    private final String EXCEPTIONMESSAGE = "Exception during a test: ";

    public CategoryTest() {
    }

    @Test
    public void testCategoryCreation() throws TooShortInputException, TooLongInputException {
        Category category = new Category("Name", "Description");

        assertTrue(category.getName().equals("Name")
                &&category.getDescription().equals("Description")
        );
    }

    @Test
    public void testCategoryToString() throws TooShortInputException, TooLongInputException {
        Category category = new Category("Name", "Description");
        String toString = category.toString();

        assertTrue(toString.contains("Category")
                &&toString.contains(category.getName())
                &&toString.contains(category.getDescription()));
    }

    @Test
    public void testRemoveAllTaskAssociations() throws TooShortInputException, TooLongInputException, TooManySubElementsException, CouldNotAddSubElementException, WrongTypeOfSubElementException {
        Category category = new Category("Example Category", "Just an example.");

        Task dishes = new Task("Dishes", "Do the dishes.");
        Task cook = new Task("Cook food", "Cook some delicious food.");

        category.addSubElement(dishes);
        dishes.setCategory(category);

        category.addSubElement(cook);
        cook.setCategory(category);

        category.removeAllTaskAssociations();

        assertTrue(cook.getCategory()!=category&&dishes.getCategory()!=category);
    }

}
