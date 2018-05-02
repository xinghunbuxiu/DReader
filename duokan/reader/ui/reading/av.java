package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.general.PagesView;

class av implements Runnable {
    final /* synthetic */ aq a;

    av(aq aqVar) {
        this.a = aqVar;
    }

    public void run() {
        this.a.p = false;
        if (!this.a.a.K()) {
            PagesView showingPagesView = this.a.f.getShowingPagesView();
            for (int i = 0; i < showingPagesView.getPageViews().length; i++) {
                if (((gs) showingPagesView.getPageViews()[i]).getPage().g().a(this.a.a.Z())) {
                    this.a.l = a.a(showingPagesView.getPageViews()[i]);
                    this.a.t = (float) ((this.a.l.getHeight() - this.a.j) - 1);
                    this.a.r = 1;
                    this.a.c.invalidate();
                    return;
                }
                if (i == showingPagesView.getPageViews().length - 1) {
                    this.a.t = (float) this.a.i;
                    this.a.c.invalidate();
                    this.a.a.u();
                }
            }
        }
    }
}
