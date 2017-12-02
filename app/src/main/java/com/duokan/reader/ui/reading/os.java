package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.t;

class os implements Runnable {
    final /* synthetic */ or a;

    os(or orVar) {
        this.a = orVar;
    }

    public void run() {
        ((t) this.a.a.getContext().queryFeature(t.class)).pushHalfPageSmoothly(new ip(this.a.a.getContext(), this.a.a.f, new ot(this)), null);
    }
}
