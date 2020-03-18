package org.example;

//package jcg.zheng.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import java.util.logging.Logger;

public class hashSet extends collectionTest {

    @Test
    public void allow_null() {
        Set<dataClass> setData = new HashSet<>();
        setData.add(null);
        assertEquals(1, setData.size());
    }

    @Test
    public void Set_no_duplicate_lambda() {
        Set<dataClass> setData = new HashSet<>();

        setData.add(buildDataClass(1, "Tom"));
        setData.add(buildDataClass(3, "Mary"));
        setData.add(buildDataClass(2, "Shan"));
        setData.add(buildDataClass(2, "Shan"));
        setData.add(buildDataClass(4, "Zheng"));
        assertEquals(4, setData.size());

    }

    @Before
    public void setup_with_4_items() {
        logger = Logger.getLogger(String.valueOf(this.getClass()));

        list = new HashSet<dataClass>();
        assertTrue(list.isEmpty());

        list.add(buildDataClass(1, "Item1"));
        assertEquals(1, list.size());
        list.add(buildDataClass(2, "Item2"));
        assertEquals(2, list.size());
        list.add(buildDataClass(3, "Item3"));
        assertEquals(3, list.size());
        list.add(buildDataClass(4, "Item4"));
        assertEquals(4, list.size());
    }

}

