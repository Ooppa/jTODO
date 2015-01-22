/*
 * Aineopintojen harjoitustyö: Ohjelmointi 2015 Kevät
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

/**
 *
 * @author Ooppa
 * @param <E>
 * @see AbstractListItem
 */
public class Category<E> extends AbstractListItem {

    public Category(String name, String description) {
        super(name, description);
    }

}
