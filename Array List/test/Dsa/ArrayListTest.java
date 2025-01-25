package Dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayListTest {

    @Test
    public void testThatArrayIsEmpty() {
        MyArrayList list = new MyArrayList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testThatItemsCanBeAdded() {
        MyArrayList list = new MyArrayList();
        list.add("samuel");
        assertEquals(1, list.size());
    }

    @Test
    public void testThatItemsCanBeRemoved() {
        MyArrayList list = new MyArrayList();
        list.add("samuel");
        list.remove("samuel");
        assertEquals(0, list.size());
    }

    @Test
    public void testThatItemsIsNotEmpty() {
        MyArrayList list = new MyArrayList();
        list.add("samuel");
        assertTrue(list.isNotEmpty());
    }

    @Test
    public void TestForItemsIndex() {
        MyArrayList list = new MyArrayList();
        list.add("samuel");
        list.add("john");
        assertEquals(1, list.index());
    }
}