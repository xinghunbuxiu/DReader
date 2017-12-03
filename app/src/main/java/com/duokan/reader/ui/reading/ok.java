package com.duokan.reader.ui.reading;

import android.graphics.RectF;

import com.duokan.core.app.IFeature;
import com.duokan.core.sys.af;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.hh;
import com.duokan.reader.domain.bookshelf.js;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.Document_a.n;
import com.duokan.reader.domain.document.Document_a.q;
import com.duokan.reader.domain.document.Document_a.u;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.g;
import com.duokan.reader.domain.document.k;
import com.duokan.reader.domain.document.m;
import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;
import com.duokan.reader.ui.general.ReaderUi;

public class ok extends qh implements n {
    static final /* synthetic */ boolean a = (!ok.class.desiredAssertionStatus());

    public ok(IFeature featrue, c cVar, Document_a aVar) {
        super(featrue, cVar, aVar);
    }

    protected void m() {
        if (this.o) {
            super.m();
        }
    }

    protected void a() {
        m();
        super.a();
    }

    protected si c() {
        return new om(getContext(), o(), this.e);
    }

    protected wl d() {
        return new ov(getContext(), this);
    }

    protected rx e() {
        return new ol(this);
    }

    protected k f() {
        k qVar = new q();
        qVar.f = D();
        a(qVar);
        return qVar;
    }

    protected m k() {
        m uVar = new u();
        a(uVar);
        return uVar;
    }

    protected void a(k kVar) {
        kVar = (q) kVar;
        super.a(kVar);
        kVar.f = D();
        if (this.c.g()) {
            kVar.a = -1;
            kVar.b = -1;
        } else {
            kVar.l = (((float) kVar.f) / ((float) this.c.ae().f())) * 2.6f;
        }
        kVar.m = C();
    }

    protected void a(m mVar) {
        super.a(mVar);
        if (this.c.g()) {
            mVar.a = null;
        }
    }

    protected ak a(g gVar) {
        return this.h.e(gVar.g());
    }

    protected float a(ak akVar) {
        if (a || akVar.b()) {
            return Math.max(0.0f, Math.min((((float) (((Document_a.a) akVar.g()).g() + 1)) / ((float) this.h.f())) * 100.0f, 100.0f));
        }
        throw new AssertionError();
    }

    protected void a(js jsVar) {
        super.a(jsVar);
        jsVar.f = this.c.b();
        jsVar.f.a(this.c.am() ? ReadingOrientation.LANDSCAPE : ReadingOrientation.PORTRAIT);
    }

    protected void l() {
        if (ReaderEnv.get().forHd()) {
            getActivity().setRequestedOrientation(2);
        } else if (this.f.D().b().f() == ReadingOrientation.LANDSCAPE) {
            ReaderUi.a(getActivity(), 11);
        } else {
            getActivity().setRequestedOrientation(1);
        }
    }

    public void chooseStatusBarStyle(af afVar) {
        if (this.c.g()) {
            afVar.a(Boolean.valueOf(B().getPageScaleType() == PageScaleType.MATCH_WIDTH));
        } else {
            super.chooseStatusBarStyle(afVar);
        }
    }

    private ov B() {
        return (ov) this.e;
    }

    private RectF[] C() {
        return this.f.D().b().d();
    }

    private int D() {
        hh b = this.f.D().b();
        int b2 = b.b();
        if (b2 != 0) {
            return b2;
        }
        b2 = this.d.f();
        b.a(b2);
        return b2;
    }
}
