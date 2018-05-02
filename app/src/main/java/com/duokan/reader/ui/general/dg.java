package com.duokan.reader.ui.general;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.diagnostic.WebLog;

class dg extends gd {
    /* renamed from: a */
    final /* synthetic */ FlowPagesView f7095a;

    private dg(FlowPagesView flowPagesView) {
        this.f7095a = flowPagesView;
        super(flowPagesView);
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f7095a.getCurrentPageIndicator() == null ? 0 : this.f7095a.f6848a.size();
    }

    /* renamed from: e */
    public int mo485e(int i, int i2) {
        return this.f7095a.m10115m(i) - this.f7095a.m10115m(i2);
    }

    /* renamed from: d */
    public Object mo509d(int i) {
        return null;
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        WebLog.init().w(this.f7095a.getCurrentPageIndicator() != null);
        int b = this.f7095a.f6852e;
        while (b <= this.f7095a.f6853f && this.f7095a.m10117n(b) != i) {
            b++;
        }
        df dfVar = (df) this.c.mo2319a(this.f7095a.getCurrentPageIndicator().mo2324a(b), view, viewGroup);
        View d = dfVar.mo2328d();
        d.setLayoutParams(new LayoutParams(-2, -2));
        this.f7095a.f6848a.set(i, dfVar);
        this.f7095a.m10012c((gc) dfVar);
        if (b == 0) {
            this.f7095a.setCurrentPagePresenter(dfVar);
        }
        return d;
    }

    public void a_(int i, int i2) {
        super.m1397f(i, i2);
        for (int i3 = 0; i3 < mo506c(); i3++) {
            this.f7095a.getCellsView().m1119a(i3, true);
        }
    }

    public void b_(int i, int i2) {
    }

    /* renamed from: a */
    public void mo440a(int i, int i2, int i3) {
    }

    /* renamed from: d */
    public void mo444d(int i, int i2) {
        super.mo2519h(i, i2);
    }

    public void a_(int i) {
        super.mo1691d();
        for (int i2 = 0; i2 < mo506c(); i2++) {
            this.f7095a.getCellsView().m1119a(i2, true);
        }
    }
}
