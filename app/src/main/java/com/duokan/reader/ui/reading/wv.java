package com.duokan.reader.ui.reading;

import android.view.View;

import com.duokan.reader.domain.document.as;

class wv extends ww {
    final /* synthetic */ wl a;

    private wv(wl wlVar) {
        this.a = wlVar;
        super(wlVar);
    }

    protected void a(boolean z) {
        if (z) {
            View[] pageViews = this.a.getShowingPagesView().getPageViews();
            int i = 0;
            while (i < pageViews.length) {
                as pageDrawable = ((gs) pageViews[i]).getPageDrawable();
                if (pageDrawable == null || z || !pageDrawable.C()) {
                    i++;
                } else {
                    return;
                }
            }
            super.a(z);
        }
    }
}
