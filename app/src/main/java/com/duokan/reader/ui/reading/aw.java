package com.duokan.reader.ui.reading;

import com.duokan.reader.common.bitmap.a;

class aw implements Runnable {
    final /* synthetic */ aq a;

    aw(aq aqVar) {
        this.a = aqVar;
    }

    public void run() {
        this.a.q = false;
        if (!this.a.a.K()) {
            this.a.r = 0;
            this.a.l = a.a(this.a.a.X().d());
            this.a.t = (float) this.a.i;
            this.a.c.invalidate();
            this.a.a.u();
        }
    }
}
