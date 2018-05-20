package com.duokan.reader.ui.reading;

import com.duokan.reader.DkPublic;

class ec implements Runnable {
    /* renamed from: a */
    final /* synthetic */ dg f10067a;

    ec(dg dgVar) {
        this.f10067a = dgVar;
    }

    public void run() {
        DkPublic.exchangeNewIdThenDo(this.f10067a.f10025z.getId(), this.f10067a.f9998G, new ed(this), null);
    }
}
