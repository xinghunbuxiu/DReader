package com.duokan.reader.ui.store;

import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.im;

class av implements im {
    /* renamed from: a */
    final /* synthetic */ Runnable f11331a;
    /* renamed from: b */
    final /* synthetic */ as f11332b;

    av(as asVar, Runnable runnable) {
        this.f11332b = asVar;
        this.f11331a = runnable;
    }

    /* renamed from: a */
    public void mo1021a(C0800c c0800c) {
        this.f11331a.run();
    }

    /* renamed from: a */
    public void mo1022a(String str) {
        this.f11332b.f11326a.dismiss();
        C1502o.m15426d(str);
    }
}
