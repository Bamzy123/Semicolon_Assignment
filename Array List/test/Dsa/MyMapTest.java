package Dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(myMap.isEmpty());
        myMap.containsKey(10);
        assertFalse( myMap.isEmpty());
    }
}
