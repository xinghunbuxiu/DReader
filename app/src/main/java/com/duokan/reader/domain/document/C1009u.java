package com.duokan.reader.domain.document;

import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.document.u */
class C1009u implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0903n f5016a;

    C1009u(C0903n c0903n) {
        this.f5016a = c0903n;
    }

    public void run() {
        if (!this.f5016a.f4273a) {
            Iterator it = this.f5016a.f4277e.iterator();
            while (it.hasNext()) {
                ((C0808w) it.next()).mo1055f(this.f5016a);
            }
        }
    }
}
