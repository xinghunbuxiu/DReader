package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.aa;
import com.duokan.reader.domain.document.p045a.C0818n;

class kd implements C0818n {
    /* renamed from: a */
    final /* synthetic */ C0818n f3443a;
    /* renamed from: b */
    final /* synthetic */ kb f3444b;

    kd(kb kbVar, C0818n c0818n) {
        this.f3444b = kbVar;
        this.f3443a = c0818n;
    }

    /* renamed from: a */
    public void mo1050a(C0903n c0903n, aa aaVar) {
        if (this.f3443a != null) {
            this.f3443a.mo1050a(c0903n, aaVar);
        }
    }

    /* renamed from: a */
    public void mo1049a(C0903n c0903n) {
        if (!(TextUtils.isEmpty(this.f3444b.m4157J()) || this.f3444b.m4157J().equals(this.f3444b.m4161N()))) {
            this.f3444b.m4232h(this.f3444b.m4157J());
        }
        if (this.f3443a != null) {
            this.f3443a.mo1049a(c0903n);
        }
    }

    /* renamed from: b */
    public void mo1051b(C0903n c0903n) {
        this.f3444b.a.decrementAndGet();
        if (this.f3443a != null) {
            this.f3443a.mo1051b(c0903n);
        }
    }

    /* renamed from: c */
    public void mo1052c(C0903n c0903n) {
        this.f3444b.a.decrementAndGet();
        if (this.f3443a != null) {
            this.f3443a.mo1052c(c0903n);
        }
    }

    /* renamed from: d */
    public void mo1053d(C0903n c0903n) {
        if (this.f3443a != null) {
            this.f3443a.mo1053d(c0903n);
        }
    }

    /* renamed from: e */
    public void mo1054e(C0903n c0903n) {
        if (this.f3443a != null) {
            this.f3443a.mo1054e(c0903n);
        }
    }

    /* renamed from: f */
    public void mo1055f(C0903n c0903n) {
        if (this.f3443a != null) {
            this.f3443a.mo1055f(c0903n);
        }
    }
}
