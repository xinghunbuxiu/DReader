package com.duokan.core.ui;

import java.util.concurrent.Callable;

final class eb implements Callable<Boolean> {
    /* renamed from: a */
    final /* synthetic */ Runnable f1211a;

    eb(Runnable runnable) {
        this.f1211a = runnable;
    }

    public /* synthetic */ Object call() {
        return m1992a();
    }

    /* renamed from: a */
    public Boolean m1992a() {
        this.f1211a.run();
        return Boolean.valueOf(false);
    }
}
