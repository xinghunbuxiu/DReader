package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class da implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    da(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        this.b.b.unregisterEventOnCurrentUrl(this.a);
    }
}
