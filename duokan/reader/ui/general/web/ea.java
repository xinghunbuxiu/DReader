package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.i;

import java.util.concurrent.Callable;

class ea implements Callable {
    final /* synthetic */ PageController a;

    ea(PageController cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Boolean a() {
        return Boolean.valueOf(i.f().b());
    }
}
