package Dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MyQueueTest {

    @Test
    public void testThatQueueIsEmpty() {
        MyQueue myQueue = new MyQueue();
        myQueue.isEmpty();
        assertTrue(myQueue.isEmpty());
    }

    @Test
    public void testThatElementCanBeAddedToTheQueue() {
        MyQueue myQueue = new MyQueue();
        assertTrue(myQueue.add("hello"));
    }

    @Test
    public void thatElementIndexCanBeFindFromTheQueue() {
        MyQueue myQueue = new MyQueue();
        myQueue.add("hello");
        myQueue.add("world");
        myQueue.add("semicolon");
        myQueue.add("africa");
        assertEquals("semicolon",myQueue.elements());
    }

    @Test
    public void thatElementCanBeRemovedFromTheQueue() {
        MyQueue myQueue = new MyQueue();
        myQueue.add("hello");
        myQueue.add("world");
        myQueue.add("semicolon");
        myQueue.remove("world");
        assertEquals(2,myQueue.size());
    }

    @Test
    public void ForOffer() {
        MyQueue myQueue = new MyQueue();
        myQueue.add("hello");
        myQueue.add("world");
        assertTrue(myQueue.isOffer());
    }

    @Test
    public void testForPoll() {
        MyQueue myQueue = new MyQueue();
        myQueue.add("hello");
        myQueue.add("world");
        myQueue.add("semicolon");
        assertEquals("hello",myQueue.poll());
    }
}