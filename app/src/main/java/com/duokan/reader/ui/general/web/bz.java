package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.UThread;

class bz implements Runnable {
    /* renamed from: a */
    final /* synthetic */ by f7656a;

    bz(by byVar) {
        this.f7656a = byVar;
    }

    public void run() {
        if (this.f7656a.f7655c.f7652a.mPageLoadingView.getAnimation() == this.f7656a.f7653a) {
            this.f7656a.f7655c.f7652a.mPageLoadingView.setVisibility(4);
            this.f7656a.f7655c.f7652a.mPageLoadingView.clearAnimation();
        }
        UThread.runOnThread(this.f7656a.f7654b);
    }
}
