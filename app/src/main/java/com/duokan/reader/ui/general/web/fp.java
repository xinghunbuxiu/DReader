package com.duokan.reader.ui.general.web;

import com.duokan.reader.common.c.f;

import java.util.concurrent.Callable;

class fp implements Callable {
    final /* synthetic */ cg a;

    fp(cg cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Boolean a() {
        return Boolean.valueOf(f.b().d());
    }
}
