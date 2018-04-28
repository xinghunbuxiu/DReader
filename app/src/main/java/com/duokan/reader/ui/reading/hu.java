package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.ui.store.aq;

class hu implements C0666x {
    /* renamed from: a */
    final /* synthetic */ long f10352a;
    /* renamed from: b */
    final /* synthetic */ ht f10353b;

    hu(ht htVar, long j) {
        this.f10353b = htVar;
        this.f10352a = j;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        if (this.f10353b.f10351a.f.al()) {
            aq.m15257a(this.f10353b.f10351a.getContext(), (hy) this.f10353b.f10351a.c, this.f10352a);
        }
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
    }
}
