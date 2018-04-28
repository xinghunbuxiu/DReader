package com.duokan.reader.ui.reading;

import com.duokan.core.sys.UThread;

class tw implements Runnable {
    /* renamed from: a */
    final /* synthetic */ tp f10996a;

    tw(tp tpVar) {
        this.f10996a = tpVar;
    }

    public void run() {
        UThread.postDelayed(new tx(this), 300);
    }
}
