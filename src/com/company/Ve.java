package com.company;

import java.util.HashMap;
import java.util.Map;

public class Ve<V>{
    private V struct;
    private Map<Ve<V>, Double> veDoubleMap = new HashMap<>();

    public Ve(V info) {
        this.struct = info;
    }

    public void MapADD(Ve<V> finP, double w){
        veDoubleMap.put(finP, w);
    }

    public Map<Ve<V>, Double> MapADD() {
        return veDoubleMap;
    }

    public V getS() {
        return struct;
    }
}
