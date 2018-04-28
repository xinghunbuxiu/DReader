package com.duokan.reader.domain.bookshelf;

import java.util.Iterator;

class hr implements Runnable {
    /* renamed from: a */
    final /* synthetic */ an f3320a;
    /* renamed from: b */
    final /* synthetic */ int f3321b;
    /* renamed from: c */
    final /* synthetic */ hp f3322c;

    hr(hp hpVar, an anVar, int i) {
        this.f3322c = hpVar;
        this.f3320a = anVar;
        this.f3321b = i;
    }

    public void run() {
        Iterator it = this.f3322c.f3316b.f2752q.iterator();
        while (it.hasNext()) {
            ((ip) it.next()).onItemChanged(this.f3320a, this.f3321b);
        }
    }
}
