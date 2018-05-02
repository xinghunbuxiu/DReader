package com.duokan.reader.common;

import com.duokan.reader.ReaderEnv.PrivatePref;

/* renamed from: com.duokan.reader.common.e */
class C0607e implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0590d f2030a;

    C0607e(C0590d c0590d) {
        this.f2030a = c0590d;
    }

    public void run() {
        this.f2030a.f1929h = this.f2030a.f1925d.getPrefInt(PrivatePref.PERSONAL, "feedback_count", 0);
    }
}
