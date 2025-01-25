package Dsa;

import java.util.HashSet;
import java.util.Set;

public class MySetFunction {

    private Set<String> set;
    private int size;

    public MySetFunction() {
        set = new HashSet<String>();
        size = 0;
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public void add(String element) {
        set.add(element);
        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        set.clear();
        size = 0;
    }

    public void contains(String name) {
        set.contains(name);
        size++;
    }
}
