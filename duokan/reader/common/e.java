package com.duokan.reader.common;

import com.duokan.reader.ReaderEnv.PrivatePref;

class e implements Runnable {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void run() {
        this.a.h = this.a.d.getPrefInt(PrivatePref.PERSONAL, "feedback_count", 0);
    }
}
