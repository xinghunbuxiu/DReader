package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.cloud.DkSharedStorageManager;

import java.util.concurrent.Callable;

class cl implements Callable {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    cl(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public String a() {
        return DkSharedStorageManager.a().a(this.a);
    }
}
