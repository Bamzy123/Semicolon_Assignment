package Dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MySetTest {

    @Test
    public void testThatSetIsEmpty() {
        MySetFunction mySetFunction = new MySetFunction();
        assertTrue(mySetFunction.isEmpty());
    }

    @Test
    public void testThatSetIsNotEmpty() {
        MySetFunction mySetFunction = new MySetFunction();
        mySetFunction.add("stephen");
        assertEquals(1,mySetFunction.size());
    }

    @Test
    public void testThatSetContainsElement() {
        MySetFunction mySetFunction = new MySetFunction();
        mySetFunction.contains("stephen");
        assertEquals(1,mySetFunction.size());
    }

    @Test
    public void testThatSetElementCanBeRemoved() {
        MySetFunction mySetFunction = new MySetFunction();
        mySetFunction.add("stephen");
        mySetFunction.clear();
        assertEquals(0,mySetFunction.size());
    }
}
