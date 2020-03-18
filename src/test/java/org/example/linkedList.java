package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

public abstract class linkedList extends collectionTest {

    protected List<String> listItems;

    @Test
    public void Collections_sort_binarySearch() {
        listItems.add("Tom");
        listItems.add("Mary");
        listItems.add("Shan");
        listItems.add("Zheng");

        Collections.sort(listItems);
        assertEquals("Mary", listItems.get(0));
        assertEquals("Shan", listItems.get(1));
        assertEquals("Tom", listItems.get(2));
        assertEquals("Zheng", listItems.get(3));
        logger.info("Sorted List");
        for (int i = 0; i < listItems.size(); i++) {
            logger.info("Index: " + i + " - Item: " + listItems.get(i));
        }

        int foundTom = Collections.binarySearch(listItems, "Tom");
        assertEquals(2, foundTom);
    }

    @Test
    public void List_can_add_get_remove_via_index() {

        listItems.add(0, "Mary");
        assertEquals(1, listItems.size());

        int pos = listItems.indexOf("Mary");
        assertEquals(0, pos);

        String item0 = listItems.get(0);
        assertEquals("Mary", item0);

        listItems.set(0, "Zheng");
        assertEquals("Zheng", listItems.get(0));

        listItems.remove(0);
        assertTrue(listItems.isEmpty());

    }

    @Test
    public void List_copyOf_java10() {
        listItems.add("JCG");
        listItems.add("Demo");

        List<String> copiedValues = List.copyOf(listItems);
        assertEquals(2, copiedValues.size());
    }

    @Test
    public void List_loop_via_for_get_index() {
        listItems.add("Tom");
        listItems.add("Mary");
        listItems.add("Shan");
        listItems.add("Zheng");

        logger.info("Retrieving items with loop using index and size list");
        for (int i = 0; i < listItems.size(); i++) {
            logger.info("Index: " + i + " - Item: " + listItems.get(i));
        }
    }

    @Test
    public void List_of_java9() {
        List<String> emptyList = List.of();
        assertTrue(emptyList.isEmpty());

        List<String> itemList = List.of("Mary", "Zheng", "Developer");
        assertEquals(3, itemList.size());
    }

}
