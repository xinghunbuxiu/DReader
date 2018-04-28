package com.duokan.reader.ui.personal;

import com.duokan.reader.common.async.work.C0523c;
import com.duokan.reader.common.async.work.C0531i;
import com.duokan.reader.domain.micloud.C1068i;

class dr extends C0531i<C1068i> {
    /* renamed from: a */
    final /* synthetic */ dm f8465a;

    dr(dm dmVar) {
        this.f8465a = dmVar;
    }

    /* renamed from: c */
    public /* synthetic */ void mo747c(C0523c c0523c) {
        m11709e((C1068i) c0523c);
    }

    /* renamed from: d */
    public /* synthetic */ void mo748d(C0523c c0523c) {
        m11703b((C1068i) c0523c);
    }

    /* renamed from: e */
    public /* synthetic */ void mo749e(C0523c c0523c) {
        m11705c((C1068i) c0523c);
    }

    /* renamed from: g */
    public /* synthetic */ void mo751g(C0523c c0523c) {
        m11707d((C1068i) c0523c);
    }

    /* renamed from: a */
    public void m11702a(C1068i c1068i) {
        super.mo745a(c1068i);
        this.f8465a.f8458c.post(new ds(this));
    }

    /* renamed from: b */
    public void m11703b(C1068i c1068i) {
        this.f8465a.f8458c.post(new dt(this, c1068i));
    }

    /* renamed from: c */
    public void m11705c(C1068i c1068i) {
        super.mo745a(c1068i);
        this.f8465a.f8458c.post(new du(this));
    }

    /* renamed from: d */
    public void m11707d(C1068i c1068i) {
        this.f8465a.f8458c.post(new dv(this, c1068i));
    }

    /* renamed from: e */
    public void m11709e(C1068i c1068i) {
        this.f8465a.f8458c.post(new dw(this, c1068i));
    }

    /* renamed from: f */
    public void m11711f(C1068i c1068i) {
        this.f8465a.f8458c.post(new dx(this, c1068i));
    }
}
