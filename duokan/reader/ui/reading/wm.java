package com.duokan.reader.ui.reading;

import java.io.File;

class wm implements Runnable {
    final /* synthetic */ wl a;

    wm(wl wlVar) {
        this.a = wlVar;
    }

    public void run() {
        for (File d : this.a.n()) {
            a.d(d);
        }
    }
}
