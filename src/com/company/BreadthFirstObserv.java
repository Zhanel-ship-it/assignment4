package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstObserv<T> extends Observ<T> {

    public BreadthFirstObserv(GraphW<T> g, T t) {
        super(new Ve<T>(t));
        bfo(g, t);
    }

    private void bfo(GraphW<T> g, T t) {
        ves.add(new Ve<T>(t));
        Queue<Ve<T>> list = new LinkedList<>();
        list.add(new Ve<T>(t));
        while (!list.isEmpty()) {
            Ve<T> v = list.remove();
            g.ves.get(g.ves.indexOf(v)).MapADD().keySet().stream().filter(vert -> !ves.contains(vert)).forEachOrdered(vert -> {
                ves.add(vert);
                veMap.put(vert, v);
                list.add(vert);
            });
        }
    }
}
