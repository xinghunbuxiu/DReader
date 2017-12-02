package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class fq implements as {
    final /* synthetic */ boolean a;
    final /* synthetic */ cg b;

    fq(cg cgVar, boolean z) {
        this.b = cgVar;
        this.a = z;
    }

    public void a() {
        this.b.b.mWebView.requestDisallowInterceptTouchEvent(this.a);
    }
}
