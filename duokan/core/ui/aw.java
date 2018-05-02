package com.duokan.core.ui;

import android.view.View;
import android.view.ViewGroup;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class aw implements av {
    static final /* synthetic */ boolean b = (!aw.class.desiredAssertionStatus());
    private final LinkedList a = new LinkedList();

    public void f(int i, int i2) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((ax) it.next()).a_(i, i2);
        }
    }

    public void g(int i, int i2) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((ax) it.next()).b_(i, i2);
        }
    }

    public void b(int i, int i2, int i3) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((ax) it.next()).a(i, i2, i3);
        }
    }

    public void h(int i, int i2) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((ax) it.next()).d(i, i2);
        }
    }

    public void d() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((ax) it.next()).a_(c());
        }
    }

    public int e(int i, int i2) {
        return i - i2;
    }

    public void a(ax axVar) {
        if (!b && axVar == null) {
            throw new AssertionError();
        } else if (!this.a.contains(axVar)) {
            this.a.add(axVar);
        }
    }

    public void b(ax axVar) {
        if (b || axVar != null) {
            this.a.remove(axVar);
            return;
        }
        throw new AssertionError();
    }

    public View a(View view, ViewGroup viewGroup) {
        return null;
    }
}
