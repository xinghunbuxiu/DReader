package com.duokan.reader.domain.bookshelf;

import android.content.Context;
import com.duokan.core.app.ManagedApp;
import com.duokan.reader.common.p036b.C0542e;

class jj implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f3390a;
    /* renamed from: b */
    final /* synthetic */ it f3391b;

    jj(it itVar, boolean z) {
        this.f3391b = itVar;
        this.f3390a = z;
    }

    public void run() {
        jp b = this.f3391b.f3365i;
        if (b != null) {
            Context topActivity = ManagedApp.get().getTopActivity();
            if (topActivity == null) {
                topActivity = this.f3391b.f3363g;
            }
            C0542e.m2413b(topActivity);
            b.f3405b.m8115c().m8259a("/Books", this.f3390a, true, true, 1);
        }
    }
}
