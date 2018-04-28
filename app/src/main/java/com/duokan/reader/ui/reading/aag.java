package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ah;
import com.duokan.reader.domain.bookshelf.ee;

class aag implements Runnable {
    /* renamed from: a */
    final /* synthetic */ abd f9326a;
    /* renamed from: b */
    final /* synthetic */ ee f9327b;
    /* renamed from: c */
    final /* synthetic */ aab f9328c;

    aag(aab aab, abd abd, ee eeVar) {
        this.f9328c = aab;
        this.f9326a = abd;
        this.f9327b = eeVar;
    }

    public void run() {
        ah.m865a(new aah(this));
    }
}
