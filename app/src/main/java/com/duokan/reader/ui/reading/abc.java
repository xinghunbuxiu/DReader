package com.duokan.reader.ui.reading;

import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.im;
import com.duokan.reader.ui.general.be;

class abc implements im {
    /* renamed from: a */
    final /* synthetic */ Runnable f9377a;
    /* renamed from: b */
    final /* synthetic */ aaw f9378b;

    abc(aaw aaw, Runnable runnable) {
        this.f9378b = aaw;
        this.f9377a = runnable;
    }

    /* renamed from: a */
    public void mo1021a(C0800c c0800c) {
        this.f9377a.run();
    }

    /* renamed from: a */
    public void mo1022a(String str) {
        be.m10286a(this.f9378b.f9363d.getContext(), C0258j.general__shared__network_error, 1).show();
    }
}
