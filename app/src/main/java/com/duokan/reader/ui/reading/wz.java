package com.duokan.reader.ui.reading;

import com.duokan.core.io.FileUtil;
import java.io.File;

class wz implements Runnable {
    /* renamed from: a */
    final /* synthetic */ wy f11131a;

    wz(wy wyVar) {
        this.f11131a = wyVar;
    }

    public void run() {
        for (File f : this.f11131a.m13645n()) {
            FileUtil.deleteFile(f);
        }
    }
}
