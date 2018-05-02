package com.duokan.reader.domain.document;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public abstract class g {
    private g[] a = null;

    public abstract int c();

    public abstract int d();

    public abstract String e();

    public abstract av f();

    public abstract ak g();

    public abstract int h();

    public abstract int i();

    public abstract g[] j();

    public abstract boolean k();

    public int a() {
        l();
        return this.a.length;
    }

    public g[] b() {
        l();
        return this.a;
    }

    public boolean a(g gVar) {
        if (gVar == this) {
            return true;
        }
        for (g a : j()) {
            if (a.a(gVar)) {
                return true;
            }
        }
        return false;
    }

    private void l() {
        if (this.a == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(Arrays.asList(j()));
            ListIterator listIterator = linkedList.listIterator();
            while (listIterator.hasNext()) {
                g[] j = ((g) listIterator.next()).j();
                for (int length = j.length - 1; length >= 0; length--) {
                    listIterator.add(j[length]);
                    listIterator.previous();
                }
            }
            this.a = (g[]) linkedList.toArray(new g[0]);
        }
    }
}
