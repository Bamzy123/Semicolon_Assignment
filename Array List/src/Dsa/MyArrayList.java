package Dsa;

import java.util.ArrayList;
import java.util.List;

class MyArrayList {

    private List <String> items;
    private int size;

    public MyArrayList() {
        items = new ArrayList<>();
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(String name) {
        items.add(name);
        size++;
    }

    public int size() {
        return size;
    }

    public void remove(String name) {
        items.remove(name);
        size--;
    }

    public boolean isNotEmpty() {
        return !items.isEmpty();
    }

    public int index() {
        return items.indexOf(items.get(1));
    }
}