package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class jy implements Runnable {
    final /* synthetic */ as a;
    final /* synthetic */ cg b;

    jy(cg cgVar, as asVar) {
        this.b = cgVar;
        this.a = asVar;
    }

    public void run() {
        if (this.b.b.isAttached()) {
            this.b.b(this.a);
        }
    }
}
