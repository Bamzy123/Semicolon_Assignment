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
}