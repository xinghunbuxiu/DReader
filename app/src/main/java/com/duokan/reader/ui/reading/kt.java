package com.duokan.reader.ui.reading;

import com.duokan.core.app.ActivatedController;

class kt implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ActivatedController f10528a;
    /* renamed from: b */
    final /* synthetic */ kn f10529b;

    kt(kn knVar, ActivatedController c0303e) {
        this.f10529b = knVar;
        this.f10528a = c0303e;
    }

    public void run() {
        this.f10529b.activate(this.f10528a);
    }
}
