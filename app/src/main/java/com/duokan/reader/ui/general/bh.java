package com.duokan.reader.ui.general;

import com.duokan.core.ui.Scrollable.ScrollState;

class bh implements Runnable {
    /* renamed from: a */
    final /* synthetic */ bg f6997a;

    bh(bg bgVar) {
        this.f6997a = bgVar;
    }

    public void run() {
        if (this.f6997a.f6996a.getScrollState() == ScrollState.IDLE) {
            this.f6997a.f6996a.m9946e();
        }
    }
}
