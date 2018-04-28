package com.duokan.reader.domain.bookshelf;

import java.util.Iterator;

class hu implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0800c f3327a;
    /* renamed from: b */
    final /* synthetic */ hc f3328b;

    hu(hc hcVar, C0800c c0800c) {
        this.f3328b = hcVar;
        this.f3327a = c0800c;
    }

    public void run() {
        Iterator it = this.f3328b.f2754s.iterator();
        while (it.hasNext()) {
            ((in) it.next()).mo1683a(this.f3327a);
        }
    }
}
