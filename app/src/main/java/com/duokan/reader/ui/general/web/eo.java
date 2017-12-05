package com.duokan.reader.ui.general.web;

import com.duokan.reader.common.classc;

import java.util.concurrent.Callable;

class eo implements Callable {
    final /* synthetic */ PageController a;

    eo(PageController cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Boolean a() {
        return Boolean.valueOf(classc.ConnectivityReceiver.b().e());
    }
}
