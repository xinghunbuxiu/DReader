package com.duokan.reader.ui.reading;

import com.duokan.reader.common.webservices.duokan.C0650x;

class qi implements Runnable {
    /* renamed from: a */
    final /* synthetic */ qh f10863a;

    qi(qh qhVar) {
        this.f10863a = qhVar;
    }

    public void run() {
        String I = this.f10863a.f10861a.getId();
        if (this.f10863a.f10861a.al()) {
            I = new C0650x(this.f10863a.f10861a.getId()).m3046a();
        }
        su a = this.f10863a.f10862b.f10853a;
        int i = this.f10863a.f10861a.al() ? 4 : this.f10863a.f10861a.mo1038k() ? 2 : 1;
        a.mo2037a(I, i);
    }
}
