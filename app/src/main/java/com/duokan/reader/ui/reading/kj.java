package com.duokan.reader.ui.reading;

import com.duokan.core.app.e;

class kj implements Runnable {
    final /* synthetic */ e a;
    final /* synthetic */ kd b;

    kj(kd kdVar, e eVar) {
        this.b = kdVar;
        this.a = eVar;
    }

    public void run() {
        this.b.activate(this.a);
    }
}
