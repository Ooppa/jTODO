/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import jtodo.excptions.CouldNotAddSubElementException;
import jtodo.excptions.TooLongInputException;
import jtodo.excptions.TooManySubElementsException;
import jtodo.excptions.TooShortInputException;
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
    
    @Test
    public void testSetTooShortName() {
        try {
            listItem.setName("a");
            fail("Was able to set too short name.");
        } catch(TooShortInputException ex) {
            assertTrue("Could not set too short name", true);
        } catch(TooLongInputException ex) {
            fail(EXCEPTIONMESSAGE+ex.toString());
        }

    }

    @Test
    public void testSetTooLongName() {
        try {

            AbstractListItem testItem = new AbstractListItem(getTooLongString(1000), "Test Description") {
            };
            fail("Was able to set too long name.");

        } catch(TooShortInputException ex) {
            fail(EXCEPTIONMESSAGE+ex.toString());
        } catch(TooLongInputException ex) {
            assertTrue("Could not add too long name", true);
        }

    }

    @Test
    public void testGetDescription() {
        assertTrue(listItem.getDescription().equals("Test Description"));
    }

    @Test
    public void testSetDescription() {
        try {
            listItem.setDescription("Edited");
            assertTrue(listItem.getDescription().equals("Edited"));
        } catch(TooShortInputException|TooLongInputException ex) {
            fail(EXCEPTIONMESSAGE+ex.toString());
        }

    }
    
    @Test
    public void testSetDescriptionNull() {
        try {
            listItem.setDescription(null);
            assertTrue(listItem.getDescription().equals(""));
        } catch(TooShortInputException|TooLongInputException ex) {
            assertTrue("Could not set description to null", true);
        } 

    }


    @Test
    public void testGetSubElementsWhenNone() {
        assertEquals(listItem.getSubElements().size(), 0);
    }

    @Test
    public void testGetSubElementsWhenSome() {
        try {
            AbstractListItem first = new AbstractListItem("Test Name", "Test Description") {
            };
            AbstractListItem second = new AbstractListItem("Test Name", "Test Description") {
            };

            listItem.addSubElement(first);
            listItem.addSubElement(second);

            assertTrue(
                    listItem.getSubElements().contains(first)
                    &&listItem.getSubElements().contains(second)
            );
        } catch(TooManySubElementsException|
                TooShortInputException|
                TooLongInputException|CouldNotAddSubElementException ex) {
            fail(EXCEPTIONMESSAGE+ex.toString());
        }
    }

    @Test
    public void testGetColorNotNull() {
        assertTrue(listItem.getColor()!=null);
    }

    @Test
    public void testSetColor() {
        listItem.setColor(ListItemColor.RED);
        assertEquals(listItem.getColor(), ListItemColor.RED);
    }

    @Test
    public void testSetColorToNull() {
        listItem.setColor(null);
        assertEquals(listItem.getColor(), ListItemColor.WHITE);
    }

    /**
     * Attempts to add itself as a sub-element.
     */
    @Test
    public void testAddSelfAsASubElement() {
        try {
            listItem.addSubElement(listItem);
            assertTrue(listItem.getSubElements().contains(listItem));
        } catch(CouldNotAddSubElementException ex) {
            assertTrue("Could not add self as a subelement.", true);
        } catch(TooManySubElementsException ex) {
            fail("Could add self as a sub-element.");
        }
    }

    /**
     * Attempts to add too many sub-elements.
     */
    @Test
    public void testAddTooManySubElements() {
        try {
            for(int i = 0; i<101; i++) {
                AbstractListItem addItem = new AbstractListItem("Test Item number "+i,
                        "Test Description") {
                        };
                listItem.addSubElement(addItem);
            }
        } catch(TooManySubElementsException ex) {
            assertTrue("Sub elements are limited properly", true);
        } catch(CouldNotAddSubElementException|TooShortInputException|TooLongInputException ex) {
            fail(EXCEPTIONMESSAGE+ex.toString());
        }

    }

    @Test
    public void testRemoveSubElement() {
        try {
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
        } catch(TooManySubElementsException|
                TooShortInputException|
                TooLongInputException|CouldNotAddSubElementException ex) {
            fail(EXCEPTIONMESSAGE+ex.toString());
        }
    }

    @Test
    public void testClearSubElements() {
        try {
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
        } catch(TooManySubElementsException|
                TooShortInputException|
                TooLongInputException|CouldNotAddSubElementException ex) {
            fail(EXCEPTIONMESSAGE+ex.toString());
        }
    }

    @Test
    public void testHashCode() {
        try {
            AbstractListItem first = new AbstractListItem("Test Name", "Test Description") {
            };
            AbstractListItem second = new AbstractListItem("Other Test Name", "Test Description") {
            };

            assertTrue(first.hashCode()!=second.hashCode());
        } catch(TooShortInputException|TooLongInputException ex) {
            fail(EXCEPTIONMESSAGE+ex.toString());
        }
    }

    @Test
    public void testEquals() {
        assertTrue(listItem.equals(listItem));
    }

    @Test
    public void testNotEquals() {
        try {
            AbstractListItem first = new AbstractListItem("Different name", "Same Description") {
            };
            AbstractListItem second = new AbstractListItem("will change the result.", "Same Description") {
            };

            assertFalse(first.equals(second));
        } catch(TooShortInputException|TooLongInputException ex) {
            fail(EXCEPTIONMESSAGE+ex.toString());
        }
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
