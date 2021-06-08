package com.company;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Stream.*;

public class Observ<T> {
    protected int anInt;
    protected Set<Ve<T>> ves;
    protected Map<Ve<T>, Ve<T>> veMap;
    protected final Ve<T> tVe;

    public Observ(Ve<T> tVe) {
        this.tVe = tVe;
        ves = new HashSet<>();
        veMap = new HashMap<>();
    }

    public boolean toFinP(Ve<T> v) {
        return ves.contains(v);
    }

    public Iterable<Ve<T>> toFin(T v) {
        Iterable<Ve<T>> result;
        result = null;
        if (toFinP(new Ve<>(v))) {
            LinkedList<Ve<T>> ves = new LinkedList<>();
            iterate(new Ve<>(v), i -> {
                return !Objects.equals(i, tVe);
            }, i -> veMap.get(i)).forEachOrdered(ves::push);
            ves.push(tVe);
            result = ves;
        }

        return result;
    }
}
