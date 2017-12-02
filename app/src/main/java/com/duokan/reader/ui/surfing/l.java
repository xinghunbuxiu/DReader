package com.duokan.reader.ui.surfing;

import com.duokan.core.sys.j;

class l implements Runnable {
    final /* synthetic */ j a;

    l(j jVar) {
        this.a = jVar;
    }

    public void run() {
        j.a(new m(this), 2000);
    }
}
