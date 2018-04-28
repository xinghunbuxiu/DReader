package com.duokan.reader.ui.reading;

import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.ui.general.PagesView;

class av implements Runnable {
    /* renamed from: a */
    final /* synthetic */ aq f9807a;

    av(aq aqVar) {
        this.f9807a = aqVar;
    }

    public void run() {
        this.f9807a.f9797p = false;
        if (!this.f9807a.f9782a.mo1994K()) {
            PagesView showingPagesView = this.f9807a.f9787f.getShowingPagesView();
            for (int i = 0; i < showingPagesView.getPageViews().length; i++) {
                if (((gx) showingPagesView.getPageViews()[i]).getPage().mo2331g().mo1188a(this.f9807a.f9782a.mo2009Z())) {
                    this.f9807a.f9793l = C0544a.m2438a(showingPagesView.getPageViews()[i]);
                    this.f9807a.f9801t = (float) ((this.f9807a.f9793l.getHeight() - this.f9807a.f9791j) - 1);
                    this.f9807a.f9799r = 1;
                    this.f9807a.f9784c.invalidate();
                    return;
                }
                if (i == showingPagesView.getPageViews().length - 1) {
                    this.f9807a.f9801t = (float) this.f9807a.f9790i;
                    this.f9807a.f9784c.invalidate();
                    this.f9807a.f9782a.mo2179u();
                }
            }
        }
    }
}
