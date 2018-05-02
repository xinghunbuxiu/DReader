package com.duokan.reader.ui.surfing;

import com.duokan.core.sys.IdleHandlerListener;

/* renamed from: com.duokan.reader.ui.surfing.t */
class C1533t implements IdleHandlerListener {
    /* renamed from: a */
    final /* synthetic */ C1532s f11583a;

    C1533t(C1532s c1532s) {
        this.f11583a = c1532s;
    }

    public boolean idleRun() {
        if (this.f11583a.f11582a.f11580a.isAttached()) {
            this.f11583a.f11582a.f11580a.m15510r();
        }
        return false;
    }
}
