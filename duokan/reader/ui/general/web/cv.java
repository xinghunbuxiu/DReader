package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class cv implements as {
    final /* synthetic */ String a;
    final /* synthetic */ PageController b;

    cv(PageController cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        this.b.pageController.doShowToast(this.a);
    }
}
