package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.ViewGroup;
import com.duokan.reader.ui.general.PagesView.PageLayout;
import com.duokan.reader.ui.general.gb;
import com.duokan.reader.ui.general.gc;

class yk extends fv {
    /* renamed from: c */
    final /* synthetic */ yg f11195c;

    private yk(yg ygVar) {
        this.f11195c = ygVar;
        super(ygVar);
    }

    /* renamed from: a */
    protected gx mo2393a() {
        return new yf(this.f11195c.getContext(), this.f11195c);
    }

    /* renamed from: b */
    public boolean mo2322b(gc gcVar) {
        return this.f11195c.f11188a.mo2139e(((gs) gcVar).mo2331g());
    }

    /* renamed from: a */
    protected gc mo2319a(gb gbVar, View view, ViewGroup viewGroup) {
        gc a = super.mo2319a(gbVar, view, viewGroup);
        ((gx) a.mo2328d()).setZoomEnabled(this.f11195c.getPageLayout() != PageLayout.TOP_TO_BOTTOM);
        return a;
    }

    /* renamed from: h */
    public void mo2519h(int i, int i2) {
        if (this.f11195c.f11189b != null && i <= this.f11195c.f11190c && i + i2 > this.f11195c.f11190c) {
            this.f11195c.f11189b = null;
            this.f11195c.f11190c = -1;
        }
        super.mo2519h(i, i2);
        if (i2 == 1) {
            this.f11195c.f11191d = false;
        }
    }
}
