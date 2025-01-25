package Dsa;

import java.util.Stack;

public class MyStack {

    private final Stack<Integer> stack;

    public MyStack() {
        stack = new Stack<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(int number) {
        stack.push(number);
    }

    public int peek() {
        return stack.peek();
    }

    public int size() {
        return stack.size();
    }

    public void pop() {
        stack.pop();
    }

    public int search(int number) {
        return stack.search(number);
    }
}
