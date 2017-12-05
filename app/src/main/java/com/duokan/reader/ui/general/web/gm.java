package com.duokan.reader.ui.general.web;

import com.duokan.reader.common.webservices.duokan.p;

import java.util.concurrent.Callable;

class gm implements Callable {
    final /* synthetic */ PageController a;

    gm(PageController cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Integer a() {
        return Integer.valueOf(p.i().m());
    }
}
