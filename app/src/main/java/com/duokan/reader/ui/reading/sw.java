package com.duokan.reader.ui.reading;

import com.duokan.core.sys.UIdleHandler;

class sw implements yu {
    /* renamed from: a */
    final /* synthetic */ sv f10957a;

    sw(sv svVar) {
        this.f10957a = svVar;
    }

    /* renamed from: a */
    public void mo2485a(int i) {
        this.f10957a.f9661f.requestDetach();
        this.f10957a.f9667l = i;
        UIdleHandler.addIdleHandler(new sx(this));
    }
}
