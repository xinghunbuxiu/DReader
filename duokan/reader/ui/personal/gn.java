package com.duokan.reader.ui.personal;

import com.duokan.reader.ReaderEnv;

class gn implements Runnable {
    final /* synthetic */ fl a;

    gn(fl flVar) {
        this.a = flVar;
    }

    public void run() {
        this.a.c(true);
        if (!ReaderEnv.get().getShowPurchasedHint()) {
            this.a.activate(this.a.b);
        } else if (!this.a.v()) {
            this.a.u();
        }
    }
}
