package com.duokan.reader.ui.reading;

import android.view.View;
import com.duokan.reader.domain.document.as;

class xi extends xj {
    /* renamed from: a */
    final /* synthetic */ wy f11146a;

    private xi(wy wyVar) {
        this.f11146a = wyVar;
        super(wyVar);
    }

    /* renamed from: a */
    protected void mo2511a(boolean z) {
        if (z) {
            View[] pageViews = this.f11146a.getShowingPagesView().getPageViews();
            int i = 0;
            while (i < pageViews.length) {
                as pageDrawable = ((gx) pageViews[i]).getPageDrawable();
                if (pageDrawable == null || z || !pageDrawable.m6098C()) {
                    i++;
                } else {
                    return;
                }
            }
            super.mo2511a(z);
        }
    }
}
