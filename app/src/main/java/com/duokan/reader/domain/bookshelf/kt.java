package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.sbk.C0820o;

class kt implements C0820o {
    /* renamed from: a */
    final /* synthetic */ C0820o f3480a;
    /* renamed from: b */
    final /* synthetic */ kh f3481b;

    kt(kh khVar, C0820o c0820o) {
        this.f3481b = khVar;
        this.f3480a = c0820o;
    }

    /* renamed from: a */
    public void mo1050a(C0903n c0903n, aa aaVar) {
        if (this.f3480a != null) {
            this.f3480a.mo1050a(c0903n, aaVar);
        }
    }

    /* renamed from: a */
    public void mo1049a(C0903n c0903n) {
        if (!(TextUtils.isEmpty(this.f3481b.m4157J()) || this.f3481b.m4157J().equals(this.f3481b.m4161N()))) {
            this.f3481b.m4232h(this.f3481b.m4157J());
        }
        if (this.f3480a != null) {
            this.f3480a.mo1049a(c0903n);
        }
    }

    /* renamed from: b */
    public void mo1051b(C0903n c0903n) {
        this.f3481b.a.decrementAndGet();
        if (this.f3480a != null) {
            this.f3480a.mo1051b(c0903n);
        }
        this.f3481b.bs();
    }

    /* renamed from: c */
    public void mo1052c(C0903n c0903n) {
        this.f3481b.a.decrementAndGet();
        if (this.f3480a != null) {
            this.f3480a.mo1052c(c0903n);
        }
        this.f3481b.bs();
        DkUserPurchasedFictionsManager.m5072a().m5109d(this.f3481b.m4156I());
    }

    /* renamed from: d */
    public void mo1053d(C0903n c0903n) {
        if (this.f3480a != null) {
            this.f3480a.mo1053d(c0903n);
        }
    }

    /* renamed from: e */
    public void mo1054e(C0903n c0903n) {
        if (this.f3480a != null) {
            this.f3480a.mo1054e(c0903n);
        }
    }

    /* renamed from: f */
    public void mo1055f(C0903n c0903n) {
        if (this.f3480a != null) {
            this.f3480a.mo1055f(c0903n);
        }
    }
}
