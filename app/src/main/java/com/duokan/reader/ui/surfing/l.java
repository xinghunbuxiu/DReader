package com.duokan.reader.ui.surfing;

import com.duokan.core.sys.AIdleOperation;

class l implements Runnable {
    final /* synthetic */ AIdleOperation a;

    l(AIdleOperation jVar) {
        this.a = jVar;
    }

    public void run() {
        AIdleOperation.ShowOrHide(new m(this), 2000);
    }
}
