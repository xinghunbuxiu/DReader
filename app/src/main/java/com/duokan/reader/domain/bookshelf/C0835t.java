package com.duokan.reader.domain.bookshelf;

import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.bookshelf.t */
class C0835t implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0800c f3580a;

    C0835t(C0800c c0800c) {
        this.f3580a = c0800c;
    }

    public void run() {
        if (this.f3580a.f2893A != null) {
            Iterator it = this.f3580a.f2893A.iterator();
            while (it.hasNext()) {
                ((C0837w) it.next()).mo2474a(this.f3580a.as());
            }
        }
    }
}
