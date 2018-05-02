package com.duokan.reader.domain.cloud.push;

import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.cloud.push.l */
class C0867l implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0857b f4132a;

    C0867l(C0857b c0857b) {
        this.f4132a = c0857b;
    }

    public void run() {
        Iterator it = this.f4132a.f4107h.iterator();
        while (it.hasNext()) {
            ((C0856a) it.next()).mo1594a();
        }
    }
}
