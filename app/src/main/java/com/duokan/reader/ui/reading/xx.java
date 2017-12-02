package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.ViewGroup;

import com.duokan.reader.ui.general.PagesView.PageLayout;
import com.duokan.reader.ui.general.gh;
import com.duokan.reader.ui.general.gi;

class xx extends fq {
    final /* synthetic */ xt c;

    private xx(xt xtVar) {
        this.c = xtVar;
        super(xtVar);
    }

    protected gs a() {
        return new xs(this.c.getContext(), this.c);
    }

    public boolean b(gi giVar) {
        return this.c.a.e(((gn) giVar).g());
    }

    protected gi a(gh ghVar, View view, ViewGroup viewGroup) {
        gi a = super.a(ghVar, view, viewGroup);
        ((gs) a.d()).setZoomEnabled(this.c.getPageLayout() != PageLayout.TOP_TO_BOTTOM);
        return a;
    }

    public void h(int i, int i2) {
        if (this.c.b != null && i <= this.c.c && i + i2 > this.c.c) {
            this.c.b = null;
            this.c.c = -1;
        }
        super.h(i, i2);
        if (i2 == 1) {
            this.c.d = false;
        }
    }
}
