package com.duokan.reader.ui.reading;

import android.graphics.Rect;
import android.graphics.RectF;

import com.duokan.reader.domain.bookshelf.hh;
import com.duokan.reader.domain.document.a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;

class ol extends rx {
    final /* synthetic */ ok a;
    private boolean d = true;

    public ol(ok okVar) {
        this.a = okVar;
        super(okVar);
        this.d = okVar.f.D().b().a();
    }

    public int j_() {
        if (g()) {
            return -16777216;
        }
        return 0;
    }

    public void b(boolean z) {
        if (this.d != z) {
            a Z = Z();
            this.a.B().getShowingDocPresenter().a(null, null);
            this.d = z;
            if (this.d) {
                this.a.B().c();
            } else {
                this.a.B().b();
            }
            this.a.a(this.a.f(), this.a.k());
            if (this.a.B().getShowingDocPresenter().getDocument() == null) {
                this.a.B().getShowingDocPresenter().a(this.a.h, Z);
                this.a.B().getShowingDocPresenter().setAnnotations(this.a.f.aq());
            } else {
                c((ak) Z);
            }
            this.a.f.D().b().a(z);
            this.a.z();
        }
    }

    public boolean g() {
        return this.d;
    }

    public hh b() {
        ov ovVar = (ov) this.a.e;
        hh b = G().D().b();
        b.a(ovVar.getZoomFactor());
        if (g()) {
            Rect currentPageVisiableRect = ovVar.getCurrentPageVisiableRect();
            b.a((float) currentPageVisiableRect.left, (float) currentPageVisiableRect.top);
        }
        return b;
    }

    public void a(RectF[] rectFArr) {
        this.a.f.D().b().a(rectFArr);
        this.a.B().setPageContentMargins(this.a.C());
        this.a.a(this.a.f(), null);
        aN();
    }

    public void a(PageScaleType pageScaleType) {
        this.a.f.D().b().a(pageScaleType);
        this.a.B().setPageScaleType(pageScaleType);
        aN();
    }

    public boolean h_() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean k_() {
        hh b = G().D().b();
        int b2 = b.b();
        int a = this.a.d.a(b2);
        if (a <= b2) {
            return false;
        }
        b.a(a);
        this.a.a(this.a.f(), null);
        aN();
        return true;
    }

    public boolean l() {
        hh b = G().D().b();
        int b2 = b.b();
        int b3 = this.a.d.b(b2);
        if (b3 >= b2) {
            return false;
        }
        b.a(b3);
        this.a.a(this.a.f(), null);
        aN();
        return true;
    }

    public boolean m() {
        int b = G().D().b().b();
        if (this.a.d.a(b) <= b) {
            return true;
        }
        return false;
    }

    public boolean n() {
        int b = G().D().b().b();
        if (this.a.d.b(b) >= b) {
            return true;
        }
        return false;
    }

    public boolean o() {
        return false;
    }
}
