package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.bookshelf.ee;
import java.util.List;

class aas implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f9347a;
    /* renamed from: b */
    final /* synthetic */ ee f9348b;
    /* renamed from: c */
    final /* synthetic */ ag f9349c;
    /* renamed from: d */
    final /* synthetic */ aab f9350d;

    aas(aab aab, List list, ee eeVar, ag agVar) {
        this.f9350d = aab;
        this.f9347a = list;
        this.f9348b = eeVar;
        this.f9349c = agVar;
    }

    public void run() {
        this.f9350d.f9309P.addAll(this.f9347a);
        this.f9348b.mo1029a(this.f9347a, this.f9350d.f9307N.m861b() ? ((Boolean) this.f9350d.f9307N.m858a()).booleanValue() : true, new aat(this));
    }
}
