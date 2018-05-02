package com.duokan.reader.ui.reading;

import com.duokan.core.app.ActivatedController;

class kj implements Runnable {
    final /* synthetic */ ActivatedController a;
    final /* synthetic */ kd b;

    kj(kd kdVar, ActivatedController activatedControllerVar) {
        this.b = kdVar;
        this.a = activatedControllerVar;
    }

    public void run() {
        this.b.activate(this.a);
    }
}
