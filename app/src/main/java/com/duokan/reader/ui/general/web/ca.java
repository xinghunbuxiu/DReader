package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.t;

class ca implements Runnable {
    final /* synthetic */ bz a;

    ca(bz bzVar) {
        this.a = bzVar;
    }

    public void run() {
        if (this.a.c.a.mPageLoadingView.getAnimation() == this.a.a) {
            this.a.c.a.mPageLoadingView.setVisibility(4);
            this.a.c.a.mPageLoadingView.clearAnimation();
        }
        t.a(this.a.b);
    }
}
