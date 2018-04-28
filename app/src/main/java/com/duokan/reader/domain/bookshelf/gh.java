package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.epub.C0952s;
import com.duokan.reader.domain.document.epub.af;

class gh implements af {
    /* renamed from: a */
    final /* synthetic */ af f3227a;
    /* renamed from: b */
    final /* synthetic */ fp f3228b;

    gh(fp fpVar, af afVar) {
        this.f3228b = fpVar;
        this.f3227a = afVar;
    }

    /* renamed from: a */
    public void mo1050a(C0903n c0903n, aa aaVar) {
        if (this.f3227a != null) {
            this.f3227a.mo1050a(c0903n, aaVar);
        }
    }

    /* renamed from: a */
    public void mo1049a(C0903n c0903n) {
        String B = ((C0952s) c0903n).m7025B();
        if (!(TextUtils.isEmpty(B) || B.equals(this.f3228b.m4157J()))) {
            this.f3228b.m4227f(B);
        }
        if (!(TextUtils.isEmpty(this.f3228b.m4157J()) || this.f3228b.m4157J().equals(this.f3228b.m4161N()))) {
            this.f3228b.m4232h(this.f3228b.m4157J());
        }
        if (this.f3227a != null) {
            this.f3227a.mo1049a(c0903n);
        }
    }

    /* renamed from: b */
    public void mo1051b(C0903n c0903n) {
        this.f3228b.a.decrementAndGet();
        if (this.f3227a != null) {
            this.f3227a.mo1051b(c0903n);
        }
        this.f3228b.bx();
    }

    /* renamed from: c */
    public void mo1052c(C0903n c0903n) {
        this.f3228b.a.decrementAndGet();
        if (this.f3227a != null) {
            this.f3227a.mo1052c(c0903n);
        }
        this.f3228b.bx();
        if (this.f3228b.mo1038k()) {
            DkUserPurchasedFictionsManager.m5072a().m5109d(this.f3228b.m4156I());
        } else {
            DkUserPurchasedBooksManager.m5029a().m5071e(this.f3228b.m4156I());
        }
    }

    /* renamed from: d */
    public void mo1053d(C0903n c0903n) {
        if (this.f3227a != null) {
            this.f3227a.mo1053d(c0903n);
        }
    }

    /* renamed from: e */
    public void mo1054e(C0903n c0903n) {
        if (this.f3227a != null) {
            this.f3227a.mo1054e(c0903n);
        }
    }

    /* renamed from: f */
    public void mo1055f(C0903n c0903n) {
        if (this.f3227a != null) {
            this.f3227a.mo1055f(c0903n);
        }
    }
}
