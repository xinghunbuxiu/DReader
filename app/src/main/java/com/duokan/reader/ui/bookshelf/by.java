package com.duokan.reader.ui.bookshelf;

import com.duokan.core.sys.UThread;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.general.ja;

class by implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f6233a;
    /* renamed from: b */
    final /* synthetic */ ja f6234b;
    /* renamed from: c */
    final /* synthetic */ bx f6235c;

    by(bx bxVar, boolean z, ja jaVar) {
        this.f6235c = bxVar;
        this.f6233a = z;
        this.f6234b = jaVar;
    }

    public void run() {
        ai.m3980a().mo969a(this.f6235c.f6229c, this.f6233a);
        UThread.runOnThread(new bz(this));
    }
}
