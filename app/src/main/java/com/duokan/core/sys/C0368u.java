package com.duokan.core.sys;

import java.util.concurrent.Callable;

/* renamed from: com.duokan.core.sys.u */
final class C0368u implements Callable<Void> {
    /* renamed from: a */
    final /* synthetic */ Runnable f736a;

    C0368u(Runnable runnable) {
        this.f736a = runnable;
    }

    public /* synthetic */ Object call() {
        return m1046a();
    }

    /* renamed from: a */
    public Void m1046a() {
        if (this.f736a != null) {
            this.f736a.run();
        }
        return null;
    }
}
