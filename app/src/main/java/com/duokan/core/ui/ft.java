package com.duokan.core.ui;

import com.duokan.core.sys.UThread;
import java.lang.ref.WeakReference;

class ft implements Runnable {
    /* renamed from: a */
    private final WeakReference<DkWebView> f1273a;

    ft(DkWebView webView) {
        this.f1273a = new WeakReference(webView);
    }

    public void run() {
        UThread.addIdleHandlerListener(new fu(this));
    }
}
