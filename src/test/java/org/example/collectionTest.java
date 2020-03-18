package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class collectionTest {

    Collection<dataClass> list;

    protected Logger logger;

    protected dataClass buildDataClass(int id, String name) {
        dataClass dc = new dataClass();
        dc.setId(id);
        dc.setName(name);
        return dc;
    }

    @Test
    public void Collection_add() {
        list.add(buildDataClass(1, "test"));
        assertEquals(5, list.size());

        logger.info("The arraylist contains the following elements: " + list);
    }

    @After
    public void Collection_clear() {
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void Collection_contains() {
        assertTrue(list.contains(buildDataClass(1, "Item1")));
        assertFalse(list.contains(buildDataClass(5, "Item5")));
    }

    @Test
    public void Collection_getSize() {
        assertEquals(4, list.size());
    }

    @Test
    public void Collection_isEmpty() {
        assertFalse(list.isEmpty());
    }

    @Test
    public void Collection_loop_via_for() {
        logger.info("Retrieving items using for loop");
        for (dataClass str : list) {
            logger.info("Item is: " + str);
        }
    }

    @Test
    public void Collection_loop_via_foreach_lambda() {
        logger.info("Retrieving items using Java 8 Stream");
        list.forEach((item) -> {
            logger.info(item.toString());
        });
    }

    @Test
    public void Collection_loop_via_iterator_for() {
        logger.info("Retrieving items using iterator");
        for (Iterator<dataClass> it = list.iterator(); it.hasNext();) {
            logger.info("Item is: " + it.next().toString());
        }
    }

    @Test
    public void Collection_loop_via_iterator_while() {
        Iterator<dataClass> it = list.iterator();
        logger.info("Retrieving items using iterator");
        while (it.hasNext()) {
            logger.info("Item is: " + it.next().toString());
        }
    }

    @Test
    public void Collection_remove() {
        list.remove(buildDataClass(3, "Item3"));
        assertEquals(3, list.size());
    }

    @Test
    public void Collection_toArray() {
        dataClass[] simpleArray = list.toArray(new dataClass[list.size()]);
        logger.info("The array created after the conversion of our arraylist is: " + Arrays.toString(simpleArray));
    }
}
