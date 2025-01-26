package Dsa;

import java.util.HashMap;
import java.util.Map;

public class MyMap {

    private final Map<String,Integer> map;

    public MyMap() {
        map = new HashMap<String,Integer>();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public void put(String key, int value) {
        map.put(key, value);
    }

    public int size() {
        return map.size();
    }

    public void get(String sam) {
        map.get(sam);
    }

    public boolean contains(String ayo) {
        return map.containsKey(ayo);
    }
}
