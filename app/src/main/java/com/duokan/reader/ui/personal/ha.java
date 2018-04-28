package com.duokan.reader.ui.personal;

import com.duokan.reader.ReaderEnv;

class ha implements Runnable {
    /* renamed from: a */
    final /* synthetic */ fz f8631a;

    ha(fz fzVar) {
        this.f8631a = fzVar;
    }

    public void run() {
        this.f8631a.m11868c(true);
        if (!ReaderEnv.get().getShowPurchasedHint()) {
            this.f8631a.activate(this.f8631a.f8575b);
        } else if (!this.f8631a.m11903u()) {
            this.f8631a.m11902t();
        }
    }
}
