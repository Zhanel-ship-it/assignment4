package com.company;

public class DepthFirstObserv<T> extends Observ<T> {

    public DepthFirstObserv(GraphW<T> graph, T source) {
        super(new Ve<T>(source));
        dfs(graph, source);
    }

    private void dfs(GraphW<T> g, T t) {
        ves.add(new Ve<T>(t));
        anInt++;

        Ve<T> cur = new Ve<T>(t);
        g.ves.get(g.ves.indexOf(cur)).MapADD().keySet().stream().filter(vert -> !ves.contains(vert)).forEachOrdered(vert -> {
            veMap.put(vert, new Ve<>(t));
            dfs(g, vert.getS());
        });
    }

}
