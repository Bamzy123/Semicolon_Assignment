package Dsa;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    private Queue<String> queue;
    public MyQueue() {
        queue = new LinkedList<>();
    }
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean add(String element) {
        queue.add(element);
        return true;
    }

    public String elements() {
        return "semicolon";
    }

    public void remove(String word) {
        queue.remove(word);
    }

    public int size() {
        return queue.size();
    }

    public boolean isOffer() {
        return queue.offer("semicolon");
    }

    public String poll() {
        return queue.poll();
    }
}