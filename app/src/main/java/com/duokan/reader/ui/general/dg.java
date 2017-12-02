package com.duokan.reader.ui.general;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.core.diagnostic.a;

class dg extends gj {
    final /* synthetic */ FlowPagesView a;

    private dg(FlowPagesView flowPagesView) {
        this.a = flowPagesView;
        super(flowPagesView);
    }

    public int c() {
        return this.a.getCurrentPageIndicator() == null ? 0 : this.a.a.size();
    }

    public int e(int i, int i2) {
        return this.a.m(i) - this.a.m(i2);
    }

    public Object d(int i) {
        return null;
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        a.c().b(this.a.getCurrentPageIndicator() != null);
        int b = this.a.e;
        while (b <= this.a.f && this.a.n(b) != i) {
            b++;
        }
        df dfVar = (df) this.c.a(this.a.getCurrentPageIndicator().a(b), view, viewGroup);
        View d = dfVar.d();
        d.setLayoutParams(new LayoutParams(-2, -2));
        this.a.a.set(i, dfVar);
        this.a.c((gi) dfVar);
        if (b == 0) {
            this.a.setCurrentPagePresenter(dfVar);
        }
        return d;
    }

    public void a_(int i, int i2) {
        super.f(i, i2);
        for (int i3 = 0; i3 < c(); i3++) {
            this.a.getCellsView().a(i3, true);
        }
    }

    public void b_(int i, int i2) {
    }

    public void a(int i, int i2, int i3) {
    }

    public void d(int i, int i2) {
        super.h(i, i2);
    }

    public void a_(int i) {
        super.d();
        for (int i2 = 0; i2 < c(); i2++) {
            this.a.getCellsView().a(i2, true);
        }
    }
}
