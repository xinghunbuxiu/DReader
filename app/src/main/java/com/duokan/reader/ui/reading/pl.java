package com.duokan.reader.ui.reading;

import com.duokan.core.app.b;
import com.duokan.core.app.m;
import com.duokan.core.ui.dv;

class pl implements Runnable {
    final /* synthetic */ pk a;

    pl(pk pkVar) {
        this.a = pkVar;
    }

    public void run() {
        ((m) b.a(this.a.b.j.getContext())).unlockCurrentOrientation();
        this.a.b.b.setVisibility(4);
        this.a.b.j.b.dismiss();
        this.a.b.j.b = null;
        this.a.b.j.c = false;
        dv.m.a(true);
    }
}
