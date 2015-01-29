/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import java.lang.reflect.Method;
import java.util.Arrays;
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
    public void testCategoryExtendsAbstractListItemProperly() {
        Method[] categoryMethods = Category.class.getMethods();
        Method[] abstractListItemMethods = AbstractListItem.class.getMethods();

        assertTrue(Arrays.equals(categoryMethods, abstractListItemMethods));
    }

}
