package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.PushHalfPage;

class os implements Runnable {
    final /* synthetic */ or a;

    os(or orVar) {
        this.a = orVar;
    }

    public void run() {
        ((PushHalfPage) this.a.a.getContext().queryFeature(PushHalfPage.class)).pushHalfPageSmoothly(new ip(this.a.a.getContext(), this.a.a.f, new ot(this)), null);
    }
}
