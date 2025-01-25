package Dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {

    @Test
    public void tetThatMyStackIsEmpty() {
        MyStack myStack = new MyStack();
        myStack.isEmpty();
        assertTrue(myStack.isEmpty());
    }

    @Test
    public void tetThatMyStackIsNotEmpty() {
        MyStack myStack = new MyStack();
        assertTrue(myStack.isEmpty());
        myStack.push(10);
        myStack.push(20);
        assertFalse( myStack.isEmpty());
    }

    @Test
    public void testForThePeekElement() {
        MyStack myStack = new MyStack();
        myStack.push(10);
        myStack.push(20);
        myStack.peek();
        assertEquals(20, myStack.peek());
    }

    @Test
    public void testForThePopElement() {
        MyStack myStack = new MyStack();
        myStack.push(10);
        myStack.push(20);
        myStack.pop();
        assertEquals(1, myStack.size());
    }

    @Test
    public void testFoSearchObject() {
        MyStack myStack = new MyStack();
        myStack.push(10);
        myStack.push(20);
        assertEquals(2, myStack.search(10));
        assertEquals(1, myStack.search(20));
        assertEquals(-1,myStack.search(100));

    }
}