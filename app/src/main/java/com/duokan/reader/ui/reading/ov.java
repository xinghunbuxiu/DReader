package com.duokan.reader.ui.reading;

import android.graphics.Rect;
import android.graphics.RectF;
import com.duokan.reader.domain.bookshelf.hb;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;

class ov extends si {
    /* renamed from: a */
    final /* synthetic */ ou f10759a;
    /* renamed from: d */
    private boolean f10760d = true;

    public ov(ou ouVar) {
        this.f10759a = ouVar;
        super(ouVar);
        this.f10760d = ouVar.f.m4152E().m4819b().m4620a();
    }

    public int k_() {
        if (mo2145g()) {
            return -16777216;
        }
        return 0;
    }

    /* renamed from: b */
    public void mo2105b(boolean z) {
        if (this.f10760d != z) {
            C0896a Z = mo2009Z();
            this.f10759a.m14834B().getShowingDocPresenter().mo2028a(null, null);
            this.f10760d = z;
            if (this.f10760d) {
                this.f10759a.m14834B().mo2466c();
            } else {
                this.f10759a.m14834B().mo2465b();
            }
            this.f10759a.m12825a(this.f10759a.mo2238f(), this.f10759a.mo2239k());
            if (this.f10759a.m14834B().getShowingDocPresenter().getDocument() == null) {
                this.f10759a.m14834B().getShowingDocPresenter().mo2028a(this.f10759a.h, Z);
                this.f10759a.m14834B().getShowingDocPresenter().setAnnotations(this.f10759a.f.as());
            } else {
                m13116c((ak) Z);
            }
            this.f10759a.f.m4152E().m4819b().m4618a(z);
            this.f10759a.m12861z();
        }
    }

    /* renamed from: g */
    public boolean mo2145g() {
        return this.f10760d;
    }

    /* renamed from: b */
    public hb mo2095b() {
        pf pfVar = (pf) this.f10759a.e;
        hb b = mo1992G().m4152E().m4819b();
        b.m4612a(pfVar.getZoomFactor());
        if (mo2145g()) {
            Rect currentPageVisiableRect = pfVar.getCurrentPageVisiableRect();
            b.m4613a((float) currentPageVisiableRect.left, (float) currentPageVisiableRect.top);
        }
        return b;
    }

    /* renamed from: a */
    public void mo2038a(RectF[] rectFArr) {
        this.f10759a.f.m4152E().m4819b().m4619a(rectFArr);
        this.f10759a.m14834B().setPageContentMargins(this.f10759a.m14835C());
        this.f10759a.m12825a(this.f10759a.mo2238f(), null);
        aN();
    }

    /* renamed from: a */
    public void mo2029a(PageScaleType pageScaleType) {
        this.f10759a.f.m4152E().m4819b().m4615a(pageScaleType);
        this.f10759a.m14834B().setPageScaleType(pageScaleType);
        aN();
    }

    public boolean i_() {
        return false;
    }

    /* renamed from: d */
    public boolean mo2133d() {
        return false;
    }

    public boolean l_() {
        hb b = mo1992G().m4152E().m4819b();
        int b2 = b.m4621b();
        int a = this.f10759a.d.m12464a(b2);
        if (a <= b2) {
            return false;
        }
        b.m4614a(a);
        this.f10759a.m12825a(this.f10759a.mo2238f(), null);
        aN();
        return true;
    }

    /* renamed from: l */
    public boolean mo2163l() {
        hb b = mo1992G().m4152E().m4819b();
        int b2 = b.m4621b();
        int b3 = this.f10759a.d.m12477b(b2);
        if (b3 >= b2) {
            return false;
        }
        b.m4614a(b3);
        this.f10759a.m12825a(this.f10759a.mo2238f(), null);
        aN();
        return true;
    }

    /* renamed from: m */
    public boolean mo2165m() {
        int b = mo1992G().m4152E().m4819b().m4621b();
        if (this.f10759a.d.m12464a(b) <= b) {
            return true;
        }
        return false;
    }

    /* renamed from: n */
    public boolean mo2166n() {
        int b = mo1992G().m4152E().m4819b().m4621b();
        if (this.f10759a.d.m12477b(b) >= b) {
            return true;
        }
        return false;
    }

    /* renamed from: o */
    public boolean mo2167o() {
        return false;
    }
}
