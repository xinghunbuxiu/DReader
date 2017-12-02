package com.duokan.reader.ui.general.web;

import java.util.concurrent.Callable;

class ik implements Callable {
    final /* synthetic */ cg a;

    ik(cg cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Integer a() {
        return Integer.valueOf(this.a.b.js_getPagePaddingBottom());
    }
}
