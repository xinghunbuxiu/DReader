package com.duokan.reader.ui.reading;

import com.duokan.core.sys.t;

class le implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ lc b;

    le(lc lcVar, Runnable runnable) {
        this.b = lcVar;
        this.a = runnable;
    }

    public void run() {
        t.b(this.a);
    }
}
