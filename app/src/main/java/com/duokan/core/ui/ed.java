package com.duokan.core.ui;

import com.duokan.core.sys.j;

class ed implements Runnable {
    final /* synthetic */ ec a;

    ed(ec ecVar) {
        this.a = ecVar;
    }

    public void run() {
        if (this.a.a.requestFocus()) {
            j.a(new ee(this));
        }
    }
}
