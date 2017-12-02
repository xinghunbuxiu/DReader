package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class fn implements as {
    final /* synthetic */ boolean a;
    final /* synthetic */ cg b;

    fn(cg cgVar, boolean z) {
        this.b = cgVar;
        this.a = z;
    }

    public void a() {
        this.b.b.mWebView.setPullDownRefreshEnabled(this.a);
    }
}
