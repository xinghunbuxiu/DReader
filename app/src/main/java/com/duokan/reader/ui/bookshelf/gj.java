package com.duokan.reader.ui.bookshelf;

import com.duokan.core.sys.UThread;

class gj implements Runnable {
    /* renamed from: a */
    final /* synthetic */ gi f6516a;

    gj(gi giVar) {
        this.f6516a = giVar;
    }

    public void run() {
        UThread.post(this.f6516a.f6514a);
    }
}
