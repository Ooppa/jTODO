/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package jtodo.domain;

import java.awt.Color;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Testing few methods in ENUM class, basic functions not tested
 *
 * @author Ooppa
 */
public class ListItemColorTest {

    public ListItemColorTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetColorReturnsColor() {
        assertTrue(ListItemColor.BLUE.getColor() instanceof Color);
    }

    @Test
    public void testEquals() {
        assertTrue(ListItemColor.BLUE.equals(ListItemColor.BLUE));
    }

    @Test
    public void testNotEquals() {
        assertFalse(ListItemColor.GREEN.equals(ListItemColor.RED));
    }

    @Test
    public void testGetColorsInArrayReturnsAllColors() {
        assertEquals(ListItemColor.values().length, ListItemColor.getColorsInArray().length);
    }

    @Test
    public void testGetListItemColorFromIndex() {
        assertEquals(ListItemColor.getListItemColorFromIndex(2), ListItemColor.YELLOW);
    }

    @Test
    public void testGetListItemColorFromIndexReturnsWhiteWhenWrongIndex() {
        assertEquals(ListItemColor.getListItemColorFromIndex(-1), ListItemColor.WHITE);
    }
    
    @Test
    public void testGetIndexFromListItemColor(){
        assertEquals(ListItemColor.getIndexFromListItemColor(ListItemColor.WHITE), ListItemColor.getColorsInArray().length-1);
    }

}
