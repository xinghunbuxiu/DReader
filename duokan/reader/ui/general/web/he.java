package com.duokan.reader.ui.general.web;

import com.duokan.reader.DkPublic;

import java.util.concurrent.Callable;

class he implements Callable {
    final /* synthetic */ PageController a;

    he(PageController cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Boolean a() {
        return Boolean.valueOf(DkPublic.isMiui());
    }
}
