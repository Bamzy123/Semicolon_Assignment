package Dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyMapTest {

    @Test
    public void testThatMyMapIsEmpty() {
        MyMap myMap = new MyMap();
        myMap.isEmpty();
        assertTrue(myMap.isEmpty());
    }

    @Test
    public void testThatMyMapIsNotEmpty() {
        MyMap myMap = new MyMap();

        myMap.put("stephen", 20);
        myMap.put("sam", 30);
        myMap.put("ayo", 19);
        assertEquals(3,myMap.size());
    }

    @Test
    public void testToGetObject() {
        MyMap myMap = new MyMap();
        myMap.put("stephen", 20);
        myMap.put("sam", 30);
        myMap.put("ayo", 19);
        myMap.get("sam");
        assertEquals(3,myMap.size());
    }

    @Test
    public void testThatMyMapContainsKey() {
        MyMap myMap = new MyMap();
        myMap.put("stephen", 20);
        myMap.put("sam", 30);
        myMap.put("ayo", 19);
        assertTrue(myMap.contains("ayo"));
    }

    @Test
    public void testThatMyMapContainsValue() {
        MyMap myMap = new MyMap();
        myMap.put("stephen", 20);
        myMap.put("sam", 30);
        myMap.put("ayo", 19);
        assertTrue(myMap.containsValue(19));
    }

    @Test
    public void testThatKeyAndValueCanBeRemoved() {
        MyMap myMap = new MyMap();
        myMap.put("stephen", 20);
        myMap.put("sam", 30);
        myMap.put("ayo", 19);
        myMap.remove("stephen");
        assertEquals(2,myMap.size());
    }

    @Test
    public void testForTheReturnOfAllKeysInTheMap() {
        MyMap myMap = new MyMap();
        myMap.put("stephen", 20);
        myMap.put("sam", 30);
        myMap.put("ayo", 19);
        myMap.key();
        assertEquals(3,myMap.size());
    }

    @Test
    public void testForTheReturnOfAllValuesInTheMap() {
        MyMap myMap = new MyMap();
        myMap.put("stephen", 20);
        myMap.put("sam", 30);
        myMap.put("ayo", 19);
        myMap.values();
        assertEquals(3,myMap.size());
    }

    @Test
    public void testForTheReturnOfAllValuesInTheMapWithKeys() {
        MyMap myMap = new MyMap();
        myMap.put("stephen", 20);
        myMap.put("sam", 30);
        myMap.put("ayo", 19);
        myMap.keyValue();
        assertEquals(3,myMap.size());
    }
}