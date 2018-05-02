package com.duokan.reader.ui.general.web;

import com.duokan.reader.common.classc;

import java.util.concurrent.Callable;

class fp implements Callable {
    final /* synthetic */ PageController a;

    fp(PageController cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Boolean a() {
        return Boolean.valueOf(classc.ConnectivityReceiver.b().d());
    }
}
