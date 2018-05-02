package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.bookshelf.ec;

/* renamed from: com.duokan.reader.ui.bookshelf.p */
class C1302p implements ec {
    /* renamed from: a */
    final /* synthetic */ bo f6728a;
    /* renamed from: b */
    final /* synthetic */ Runnable f6729b;
    /* renamed from: c */
    final /* synthetic */ C1301o f6730c;

    C1302p(C1301o c1301o, bo boVar, Runnable runnable) {
        this.f6730c = c1301o;
        this.f6728a = boVar;
        this.f6729b = runnable;
    }

    /* renamed from: a */
    public void mo1728a(boolean z) {
        if (this.f6728a != null) {
            this.f6728a.mo1634a(new C1303q(this));
        }
    }

    /* renamed from: a */
    public void mo1727a() {
        if (this.f6729b != null) {
            this.f6730c.f6727a.post(this.f6729b);
        }
    }
}
