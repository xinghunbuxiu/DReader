package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.bookshelf.C0800c;

class ir implements Runnable {
    /* renamed from: a */
    final /* synthetic */ iq f10397a;

    ir(iq iqVar) {
        this.f10397a = iqVar;
    }

    public void run() {
        C0800c G = this.f10397a.f10396a.f.mo1992G();
        if (!G.ak() || G.al()) {
            return;
        }
        if (G.m4170W()) {
            G.ac();
        } else {
            ((hy) this.f10397a.f10396a.f).mo2190c();
        }
    }
}
