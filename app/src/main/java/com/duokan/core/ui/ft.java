package com.duokan.core.ui;

import com.duokan.core.sys.UThread;
import java.lang.ref.WeakReference;

class ft implements Runnable {
    /* renamed from: a */
    private final WeakReference<fz> f1273a;

    ft(fz fzVar) {
        this.f1273a = new WeakReference(fzVar);
    }

    public void run() {
        UThread.addIdleHandlerListener(new fu(this));
    }
}
