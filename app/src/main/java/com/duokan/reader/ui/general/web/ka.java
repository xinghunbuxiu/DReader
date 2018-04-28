package com.duokan.reader.ui.general.web;

import java.util.concurrent.Callable;

class ka implements Callable<Integer> {
    /* renamed from: a */
    final /* synthetic */ ci f8083a;

    ka(ci ciVar) {
        this.f8083a = ciVar;
    }

    public /* synthetic */ Object call() {
        return m11247a();
    }

    /* renamed from: a */
    public Integer m11247a() {
        return Integer.valueOf(this.f8083a.f7581b.js_getPagePaddingBottom());
    }
}
