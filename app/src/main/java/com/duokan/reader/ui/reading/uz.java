package com.duokan.reader.ui.reading;

import com.duokan.core.sys.UThread;

class uz implements Runnable {
    /* renamed from: a */
    final /* synthetic */ uy f11038a;

    uz(uy uyVar) {
        this.f11038a = uyVar;
    }

    public void run() {
        UThread.postDelayed(new va(this), 500);
    }
}
