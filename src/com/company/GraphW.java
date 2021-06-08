package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class GraphW<T> {
    private boolean ifa;
    public ArrayList<Ve<T>> ves = new ArrayList<>();

    public GraphW() {
        this.ifa = true;
    }

    public GraphW(boolean ifa) {
        if (ifa) this.ifa = true;
        else this.ifa = false;
    }

    public void pl1(T v) {
        ves.add(new Ve<T>(v));
    }

    public void pl2(T tVer, T finP, double w) {
        if (!ifVer(tVer)) {
            pl1(tVer);
        }
        if (!ifVer(finP))
            pl1(finP);
        if (ifEdge(tVer, finP)
                || tVer.equals(finP) || !ves.contains(new Ve<T>(tVer))) return;

        ves.get(ves.indexOf(new Ve<T>(tVer))).MapADD(new Ve<T>(finP), w);


        if (ifa) {
            ves.get(ves.indexOf(new Ve<T>(finP))).MapADD(new Ve<T>(tVer), w);
        }
    }

    public int vCG() {
        return ves.size();
    }

    public int eCG() {
        int i = 0;

        for (Iterator<Ve<T>> iterator = ves.iterator(); iterator.hasNext(); ) {
            Ve<T> to = iterator.next();
            i += to.MapADD().size();
        }

        if (ifa)i /= 2;

        return i;
    }


    public boolean ifVer(T v) {
        if (ves.contains(new Ve<T>(v))) return true;
        else return false;
    }

    public boolean ifEdge(T t, T dest) {
        return ifVer(t) && ves.get(ves.indexOf(new Ve<T>(t))).MapADD().containsKey(new Ve<T>(dest));
    }
}
