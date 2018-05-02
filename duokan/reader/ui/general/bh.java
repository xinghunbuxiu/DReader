package com.duokan.reader.ui.general;

import com.duokan.core.ui.Scrollable.ScrollState;

class bh implements Runnable {
    final /* synthetic */ bg a;

    bh(bg bgVar) {
        this.a = bgVar;
    }

    public void run() {
        if (this.a.a.getScrollState() == ScrollState.IDLE) {
            this.a.a.e();
        }
    }
}
