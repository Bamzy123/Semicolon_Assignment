package Dsa;

import java.util.HashMap;
import java.util.Map;

public class MyMap {

    private final Map<Integer,Integer> map;

    public MyMap() {
        map = new HashMap<Integer,Integer>();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public void containsKey(int number) {
        map.containsKey(number);
    }
}
