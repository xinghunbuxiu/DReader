package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class cw implements as {
    final /* synthetic */ PageController a;

    cw(PageController cgVar) {
        this.a = cgVar;
    }

    public void a() {
        this.a.pageController.mRequestBack = true;
        this.a.pageController.requestBack();
    }
}
