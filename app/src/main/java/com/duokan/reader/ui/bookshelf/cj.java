package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.bookshelf.an;

class cj implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f6272a;
    /* renamed from: b */
    final /* synthetic */ an f6273b;
    /* renamed from: c */
    final /* synthetic */ ce f6274c;

    cj(ce ceVar, boolean z, an anVar) {
        this.f6274c = ceVar;
        this.f6272a = z;
        this.f6273b = anVar;
    }

    public void run() {
        if (!this.f6272a) {
            this.f6274c.f6250a.m9275b(this.f6273b);
        }
        this.f6274c.m9391f(false);
    }
}
