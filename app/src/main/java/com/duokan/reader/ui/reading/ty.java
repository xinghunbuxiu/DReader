package com.duokan.reader.ui.reading;

import com.duokan.core.sys.UThread;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.ak;

class ty implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ak f10998a;
    /* renamed from: b */
    final /* synthetic */ C0903n f10999b;
    /* renamed from: c */
    final /* synthetic */ tp f11000c;

    ty(tp tpVar, ak akVar, C0903n c0903n) {
        this.f11000c = tpVar;
        this.f10998a = akVar;
        this.f10999b = c0903n;
    }

    public void run() {
        if (this.f10998a == this.f11000c.f9695v && this.f10998a.mo1187a(2000)) {
            UThread.runOnThread(new tz(this));
        }
    }
}
