package com.duokan.reader.ui.reading;

import android.graphics.RectF;
import com.duokan.core.app.IFeature;
import com.duokan.core.sys.af;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.hb;
import com.duokan.reader.domain.bookshelf.ke;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.C0917k;
import com.duokan.reader.domain.document.C0923m;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.p045a.C0818n;
import com.duokan.reader.domain.document.p045a.C0898a;
import com.duokan.reader.domain.document.p045a.C0918q;
import com.duokan.reader.domain.document.p045a.C0924u;
import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;
import com.duokan.reader.ui.general.ReaderUi;

public class ou extends qr implements C0818n {
    /* renamed from: a */
    static final /* synthetic */ boolean f10758a = (!ou.class.desiredAssertionStatus());

    public ou(IFeature mFeature, C0800c c0800c, C0896a c0896a) {
        super(mFeature, c0800c, c0896a);
    }

    /* renamed from: m */
    protected void mo2462m() {
        if (this.o) {
            super.mo2462m();
        }
    }

    /* renamed from: a */
    protected void mo1979a() {
        mo2462m();
        super.mo1979a();
    }

    /* renamed from: c */
    protected sv mo2235c() {
        return new ow(getContext(), m12850o(), this.e);
    }

    /* renamed from: d */
    protected wy mo2236d() {
        return new pf(getContext(), this);
    }

    /* renamed from: e */
    protected si mo2237e() {
        return new ov(this);
    }

    /* renamed from: f */
    protected C0917k mo2238f() {
        C0917k c0918q = new C0918q();
        c0918q.f = m14836D();
        mo2348a(c0918q);
        return c0918q;
    }

    /* renamed from: k */
    protected C0923m mo2239k() {
        C0923m c0924u = new C0924u();
        mo2349a(c0924u);
        return c0924u;
    }

    /* renamed from: a */
    protected void mo2348a(C0917k c0917k) {
        c0917k = (C0918q) c0917k;
        super.mo2348a(c0917k);
        c0917k.f = m14836D();
        if (this.c.mo2145g()) {
            c0917k.a = -1;
            c0917k.b = -1;
        } else {
            c0917k.f4340l = (((float) c0917k.f) / ((float) this.c.ae().m12499f())) * 2.6f;
        }
        c0917k.f4341m = m14835C();
    }

    /* renamed from: a */
    protected void mo2349a(C0923m c0923m) {
        super.mo2349a(c0923m);
        if (this.c.mo2145g()) {
            c0923m.f4353a = null;
        }
    }

    /* renamed from: a */
    protected ak mo2234a(C0901g c0901g) {
        return this.h.mo1235e(c0901g.mo1204g());
    }

    /* renamed from: a */
    protected float mo2233a(ak akVar) {
        if (f10758a || akVar.m5777b()) {
            return Math.max(0.0f, Math.min((((float) (((C0898a) akVar.mo1198g()).m5795g() + 1)) / ((float) this.h.mo1236f())) * 100.0f, 100.0f));
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    protected void mo2461a(ke keVar) {
        super.mo2461a(keVar);
        keVar.f3450f = this.c.mo2095b();
        keVar.f3450f.m4617a(this.c.am() ? ReadingOrientation.LANDSCAPE : ReadingOrientation.PORTRAIT);
    }

    /* renamed from: l */
    protected void mo2240l() {
        if (ReaderEnv.get().forHd()) {
            getActivity().setRequestedOrientation(2);
        } else if (this.f.m4152E().m4819b().m4625f() == ReadingOrientation.LANDSCAPE) {
            ReaderUi.m10153a(getActivity(), 11);
        } else {
            getActivity().setRequestedOrientation(1);
        }
    }

    public void chooseStatusBarStyle(af<Boolean> afVar) {
        if (this.c.mo2145g()) {
            afVar.mo975a(Boolean.valueOf(m14834B().getPageScaleType() == PageScaleType.MATCH_WIDTH));
        } else {
            super.chooseStatusBarStyle(afVar);
        }
    }

    /* renamed from: B */
    private pf m14834B() {
        return (pf) this.e;
    }

    /* renamed from: C */
    private RectF[] m14835C() {
        return this.f.m4152E().m4819b().m4623d();
    }

    /* renamed from: D */
    private int m14836D() {
        hb b = this.f.m4152E().m4819b();
        int b2 = b.m4621b();
        if (b2 != 0) {
            return b2;
        }
        b2 = this.d.m12499f();
        b.m4614a(b2);
        return b2;
    }
}
