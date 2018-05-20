package com.duokan.core.ui;

import com.duokan.core.sys.IdleHandlerListener;

class fu implements IdleHandlerListener {
    /* renamed from: a */
    final /* synthetic */ ft f1274a;

    fu(ft ftVar) {
        this.f1274a = ftVar;
    }

    public boolean idleRun() {
        DkWebView webView = (DkWebView) this.f1274a.f1273a.get();
        if (webView != null) {
            webView.m2138a();
        }
        return false;
    }
}
