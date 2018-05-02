package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class fn implements as {
    final /* synthetic */ boolean a;
    final /* synthetic */ PageController b;

    fn(PageController cgVar, boolean z) {
        this.b = cgVar;
        this.a = z;
    }

    public void a() {
        this.b.pageController.mWebView.setPullDownRefreshEnabled(this.a);
    }
}
