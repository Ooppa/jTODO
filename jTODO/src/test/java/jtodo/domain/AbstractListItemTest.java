/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import java.util.UUID;
import jtodo.excptions.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 *
 * @author Ooppa
 */
public class AbstractListItemTest {

    private AbstractListItem listItem;

    private final String EXCEPTIONFAILTEXT = "Exception failed the test.";
    private final String EXCEPTIONMESSAGE = "Exception during a test: ";

    public AbstractListItemTest() {
    }

    @Before
    public void setUp() {
        try {
            listItem = new AbstractListItem("Test Name", "Test Description") {
            };
        } catch(Exception ex) {
            System.out.println("Exception during a setup process: "+ex);
        }
    }

    @After
    public void tearDown() {
        listItem = null;
    }

    @Test
    public void testGetName() {
        assertTrue(listItem.getName().contains("Test Name"));
    }

    @Test
    public void testSetName() {
        try {
            listItem.setName("Edited");
            assertTrue(listItem.getName().equals("Edited"));
        } catch(TooShortInputException|TooLongInputException ex) {
            fail(EXCEPTIONMESSAGE+ex.toString());
        }
    }

    @Test
    public void testSetNameToNull() {
        try {
            listItem.setName(null);
            fail("Was able to set null name.");
        } catch(TooShortInputException ex) {
            assertTrue("Could not add set name to null", true);
        } catch(TooLongInputException ex) {
            fail(EXCEPTIONMESSAGE+ex.toString());
        }
    }

    @Test(expected = TooShortInputException.class)
    public void testSetTooShortName() throws TooLongInputException, TooShortInputException {
        listItem.setName("a");
    }

    @Test(expected = TooLongInputException.class)
    public void testSetTooLongName() throws TooLongInputException, TooShortInputException {
        listItem.setName(getTooLongString(101));
    }

    @Test
    public void testGetDescription() {
        assertTrue(listItem.getDescription().equals("Test Description"));
    }

    @Test
    public void testSetDescription() throws TooShortInputException, TooLongInputException {
        listItem.setDescription("Edited");
        assertTrue(listItem.getDescription().equals("Edited"));
    }

    @Test
    public void testSetDescriptionNull() throws TooShortInputException, TooLongInputException {
        listItem.setDescription(null);
        assertTrue(listItem.getDescription().equals(""));
    }

    @Test(expected = TooLongInputException.class)
    public void testSetTooLongDescription() throws TooLongInputException, TooShortInputException {
        listItem.setDescription(getTooLongString(9999));
    }

    @Test
    public void testGetSubElementsWhenNone() {
        assertEquals(listItem.getSubElements().size(), 0);
    }

    @Test
    public void testGetSubElementsWhenSome() throws TooShortInputException, TooLongInputException, CouldNotAddSubElementException, WrongTypeOfSubElementException, TooManySubElementsException {
        AbstractListItem first = new AbstractListItem("Test Name", "Test Description") {
        };
        AbstractListItem second = new AbstractListItem("Test Name", "Test Description") {
        };

        listItem.addSubElement(first);
        listItem.addSubElement(second);

        assertTrue(
                listItem.getSubElements().contains(first)
                &&listItem.getSubElements().contains(second));
    }

    @Test
    public void testGetColorNotNull() {
        assertTrue(listItem.getListItemColor()!=null);
    }

    @Test
    public void testSetColor() {
        listItem.setColor(ListItemColor.RED);
        assertEquals(listItem.getListItemColor(), ListItemColor.RED);
    }

    @Test
    public void testSetColorToNull() {
        listItem.setColor(null);
        assertEquals(listItem.getListItemColor(), ListItemColor.WHITE);
    }

    @Test(expected = CouldNotAddSubElementException.class)
    public void testAddSelfAsASubElement() throws TooManySubElementsException, CouldNotAddSubElementException, WrongTypeOfSubElementException {
        listItem.addSubElement(listItem);
    }

    @Test(expected = CouldNotAddSubElementException.class)
    public void testAddNullAsSubElement() throws TooManySubElementsException, CouldNotAddSubElementException, WrongTypeOfSubElementException {
        listItem.addSubElement(null);
    }

    @Test(expected = CouldNotAddSubElementException.class)
    public void testAddDuplicateSubElement() throws TooShortInputException, TooLongInputException, TooManySubElementsException, CouldNotAddSubElementException, WrongTypeOfSubElementException {
        AbstractListItem first = new AbstractListItem("Test Name", "Test Description") {
        };
        AbstractListItem second = new AbstractListItem("Test Name", "Test Description") {
        };

        listItem.addSubElement(first);
        listItem.addSubElement(second);
        listItem.addSubElement(second);
    }

    @Test(expected = WrongTypeOfSubElementException.class)
    public void testAddWrongTypeOfSubElement() throws TooShortInputException, TooLongInputException, TooManySubElementsException, CouldNotAddSubElementException, WrongTypeOfSubElementException {
        Category category = new Category("Name", "Description");
        Task task = new Task("Name", "Description");

        // Category can't be sub-element to Task 
        task.addSubElement(category);
    }

    @Test(expected = TooManySubElementsException.class)
    public void testAddTooManySubElements() throws TooShortInputException, TooLongInputException, TooManySubElementsException, CouldNotAddSubElementException, WrongTypeOfSubElementException {
        for(int i = 0; i<105; i++) {
            listItem.addSubElement(
                    new AbstractListItem(UUID.randomUUID().toString(), "Test Description") {
                    }
            );
        }
    }

    @Test
    public void testRemoveSubElement() throws TooShortInputException, TooLongInputException, TooManySubElementsException, CouldNotAddSubElementException, WrongTypeOfSubElementException {
        AbstractListItem first = new AbstractListItem("Test Name", "Test Description") {
        };
        AbstractListItem second = new AbstractListItem("Test Name", "Test Description") {
        };

        listItem.addSubElement(first);
        listItem.addSubElement(second);

        listItem.removeSubElement(first);

        assertTrue(
                listItem.getSubElements().contains(first)==false
                &&listItem.getSubElements().contains(second)==true
        );
    }

    @Test
    public void testClearSubElements() throws TooShortInputException, TooLongInputException, TooManySubElementsException, CouldNotAddSubElementException, WrongTypeOfSubElementException {
        AbstractListItem first = new AbstractListItem("Test Name", "Test Description") {
        };
        AbstractListItem second = new AbstractListItem("Test Name", "Test Description") {
        };

        listItem.addSubElement(first);
        listItem.addSubElement(second);

        listItem.clearSubElements();

        assertTrue(
                listItem.getSubElements().contains(first)==false
                &&listItem.getSubElements().contains(second)==false
        );
    }

    @Test
    public void testEquals() {
        assertTrue(listItem.equals(listItem));
    }

    @Test
    public void testNotEquals() throws TooShortInputException, TooLongInputException {
        AbstractListItem first = new AbstractListItem("Different name", "Same Description") {
        };
        AbstractListItem second = new AbstractListItem("will change the result.", "Same Description") {
        };

        assertFalse(first.equals(second));
    }

    @Test
    public void testHashCode() {
        assertEquals(listItem.hashCode(), listItem.hashCode());
    }

    @Test
    public void testHashCodeWhenNotEqual() throws TooShortInputException, TooLongInputException {
        AbstractListItem first = new AbstractListItem("Different name", "Same Description") {
        };
        AbstractListItem second = new AbstractListItem("will change the result.", "Same Description") {
        };

        assertFalse(first.hashCode()==second.hashCode());
    }

    @Test
    public void testNotEqualNull() {
        assertFalse(listItem.equals(null));
    }

    private String getTooLongString(int length) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<length; i++) {
            sb.append("a");
        }

        return sb.toString();
    }

}
