package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class ci implements as {
    final /* synthetic */ boolean a;
    final /* synthetic */ PageController b;

    ci(PageController cgVar, boolean z) {
        this.b = cgVar;
        this.a = z;
    }

    public void a() {
        this.b.pageController.mJsPageLoading = this.a;
        this.b.a(new cj(this));
    }
}
