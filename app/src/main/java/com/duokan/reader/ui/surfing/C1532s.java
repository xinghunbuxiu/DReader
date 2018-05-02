package com.duokan.reader.ui.surfing;

import com.duokan.core.sys.UIdleHandler;

/* renamed from: com.duokan.reader.ui.surfing.s */
class C1532s implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1530q f11582a;

    C1532s(C1530q c1530q) {
        this.f11582a = c1530q;
    }

    public void run() {
        UIdleHandler.addIdleHandlerDelayed(new C1533t(this), 2000);
    }
}
