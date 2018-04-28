package com.duokan.core.ui;

import java.lang.ref.WeakReference;

class gb implements Runnable {
    /* renamed from: a */
    private final WeakReference<ga> f1289a;

    gb(ga gaVar) {
        this.f1289a = new WeakReference(gaVar);
    }

    public void run() {
        ga gaVar = (ga) this.f1289a.get();
        if (gaVar != null) {
            gaVar.m2147a(this);
        }
    }
}
