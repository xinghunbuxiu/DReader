package com.duokan.reader.ui.store;

import com.duokan.core.sys.t;

class bn implements Runnable {
    final /* synthetic */ bl a;

    bn(bl blVar) {
        this.a = blVar;
    }

    public void run() {
        t.a(new bo(this));
    }
}
