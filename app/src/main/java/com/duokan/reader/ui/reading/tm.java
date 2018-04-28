package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.bookshelf.ea;
import com.duokan.reader.ui.account.cp;

class tm implements cp {
    /* renamed from: a */
    final /* synthetic */ C0798a f10986a;
    /* renamed from: b */
    final /* synthetic */ tf f10987b;

    tm(tf tfVar, C0798a c0798a) {
        this.f10987b = tfVar;
        this.f10986a = c0798a;
    }

    /* renamed from: a */
    public void mo2506a(String str, String str2, boolean z) {
        if (z) {
            C0798a c0798a = (ea) this.f10986a;
            if (!str2.equals(c0798a.m4384m())) {
                c0798a.m4380e(str2);
                this.f10987b.f10968a.f9656a.mo1992G().m4216c(c0798a);
            }
        }
    }
}
