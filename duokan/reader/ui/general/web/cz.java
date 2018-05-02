package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class cz implements as {
    final /* synthetic */ String a;
    final /* synthetic */ PageController b;

    cz(PageController cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        this.b.pageController.registerEventOnCurrentUrl(this.a);
    }
}
