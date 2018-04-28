package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class cm implements Runnable {
    /* renamed from: a */
    final /* synthetic */ as f7681a;
    /* renamed from: b */
    final /* synthetic */ ci f7682b;

    cm(ci ciVar, as asVar) {
        this.f7682b = ciVar;
        this.f7681a = asVar;
    }

    public void run() {
        if (this.f7682b.f7581b.isAttached()) {
            this.f7682b.m11020b(this.f7681a);
        }
    }
}
