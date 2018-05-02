package com.duokan.reader.ui.reading;

import com.duokan.core.io.FileUtil;

class xe implements Runnable {
    /* renamed from: a */
    final /* synthetic */ wy f11140a;

    xe(wy wyVar) {
        this.f11140a = wyVar;
    }

    public void run() {
        FileUtil.deleteFile(this.f11140a.m13646o());
    }
}
