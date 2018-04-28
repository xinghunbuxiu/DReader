package com.duokan.core.ui;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class aw implements av {
    /* renamed from: b */
    static final /* synthetic */ boolean f917b = (!aw.class.desiredAssertionStatus());
    /* renamed from: a */
    private final LinkedList<ax> f918a = new LinkedList();

    /* renamed from: f */
    public void m1397f(int i, int i2) {
        Iterator it = this.f918a.iterator();
        while (it.hasNext()) {
            ((ax) it.next()).a_(i, i2);
        }
    }

    /* renamed from: g */
    public void m1398g(int i, int i2) {
        Iterator it = this.f918a.iterator();
        while (it.hasNext()) {
            ((ax) it.next()).b_(i, i2);
        }
    }

    /* renamed from: b */
    public void m1393b(int i, int i2, int i3) {
        Iterator it = this.f918a.iterator();
        while (it.hasNext()) {
            ((ax) it.next()).mo440a(i, i2, i3);
        }
    }

    /* renamed from: h */
    public void mo2519h(int i, int i2) {
        Iterator it = this.f918a.iterator();
        while (it.hasNext()) {
            ((ax) it.next()).mo444d(i, i2);
        }
    }

    /* renamed from: d */
    public void mo1691d() {
        Iterator it = this.f918a.iterator();
        while (it.hasNext()) {
            ((ax) it.next()).a_(mo506c());
        }
    }

    /* renamed from: e */
    public int mo485e(int i, int i2) {
        return i - i2;
    }

    /* renamed from: a */
    public void mo483a(ax axVar) {
        if (!f917b && axVar == null) {
            throw new AssertionError();
        } else if (!this.f918a.contains(axVar)) {
            this.f918a.add(axVar);
        }
    }

    /* renamed from: b */
    public void mo484b(ax axVar) {
        if (f917b || axVar != null) {
            this.f918a.remove(axVar);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        return null;
    }
}
