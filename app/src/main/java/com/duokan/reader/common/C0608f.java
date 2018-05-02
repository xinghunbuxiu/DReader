package com.duokan.reader.common;

import java.util.Iterator;

/* renamed from: com.duokan.reader.common.f */
class C0608f implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0590d f2031a;

    C0608f(C0590d c0590d) {
        this.f2031a = c0590d;
    }

    public void run() {
        Iterator it = this.f2031a.f1927f.iterator();
        while (it.hasNext()) {
            ((C0610h) it.next()).mo1595a(this.f2031a.f1929h);
        }
    }
}
