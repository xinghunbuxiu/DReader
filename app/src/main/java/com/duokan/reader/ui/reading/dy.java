package com.duokan.reader.ui.reading;

import com.duokan.reader.DkPublic;

class dy implements Runnable {
    final /* synthetic */ de a;

    dy(de deVar) {
        this.a = deVar;
    }

    public void run() {
        DkPublic.exchangeNewIdThenDo(this.a.y.H(), this.a.F, new dz(this), null);
    }
}
