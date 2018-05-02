package com.duokan.reader.ui.general.web;

import java.util.concurrent.Callable;

class ik implements Callable {
    final /* synthetic */ PageController a;

    ik(PageController cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Integer a() {
        return Integer.valueOf(this.a.pageController.js_getPagePaddingBottom());
    }
}
