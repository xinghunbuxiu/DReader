package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.at;

/* renamed from: com.duokan.reader.domain.document.txt.h */
class C0993h implements C0992n {
    /* renamed from: a */
    final /* synthetic */ C0990f f4969a;

    C0993h(C0990f c0990f) {
        this.f4969a = c0990f;
    }

    /* renamed from: a */
    public void mo1464a(C0999o c0999o) {
        at c0994i = new C0994i(this);
        ah ahVar = new ah(this.f4969a.f4955f);
        ahVar.m = false;
        ahVar.n = false;
        ah ahVar2 = new ah(this.f4969a.f4955f);
        ahVar2.l = false;
        ahVar2.n = false;
        this.f4969a.f4962m = new aj(this.f4969a.f4953d, this.f4969a.f4954e.m7562l(), ahVar2, this.f4969a.f4956g, c0994i);
        this.f4969a.f4961l = new aj(this.f4969a.f4953d, this.f4969a.f4954e.m7561k(), ahVar, this.f4969a.f4956g, c0994i);
        this.f4969a.f4965p = true;
        synchronized (this.f4969a) {
            if (this.f4969a.f4966q != null) {
                this.f4969a.f4966q.countDown();
            }
        }
        this.f4969a.m6122a(new C0995j(this));
    }

    /* renamed from: b */
    public void mo1465b(C0999o c0999o) {
    }

    /* renamed from: c */
    public void mo1466c(C0999o c0999o) {
    }
}
