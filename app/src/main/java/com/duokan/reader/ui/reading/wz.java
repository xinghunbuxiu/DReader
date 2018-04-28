package com.duokan.reader.ui.reading;

import com.duokan.core.io.C0336a;
import java.io.File;

class wz implements Runnable {
    /* renamed from: a */
    final /* synthetic */ wy f11131a;

    wz(wy wyVar) {
        this.f11131a = wyVar;
    }

    public void run() {
        for (File f : this.f11131a.m13645n()) {
            C0336a.m793f(f);
        }
    }
}
