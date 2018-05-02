package com.duokan.reader.common.p036b;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;

/* renamed from: com.duokan.reader.common.b.d */
class C0541d implements AccountManagerCallback<Boolean> {
    /* renamed from: a */
    final /* synthetic */ Runnable f1806a;
    /* renamed from: b */
    final /* synthetic */ C0538a f1807b;

    C0541d(C0538a c0538a, Runnable runnable) {
        this.f1807b = c0538a;
        this.f1806a = runnable;
    }

    public void run(AccountManagerFuture<Boolean> accountManagerFuture) {
        if (this.f1806a != null) {
            this.f1806a.run();
        }
    }
}
