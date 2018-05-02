package com.duokan.reader.domain.document;

import java.util.Iterator;

/* renamed from: com.duokan.reader.domain.document.t */
class C0985t implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0903n f4873a;

    C0985t(C0903n c0903n) {
        this.f4873a = c0903n;
    }

    public void run() {
        if (!this.f4873a.f4273a) {
            Iterator it = this.f4873a.f4277e.iterator();
            while (it.hasNext()) {
                ((C0808w) it.next()).mo1054e(this.f4873a);
            }
        }
    }
}
