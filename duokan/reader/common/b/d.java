package com.duokan.reader.common.b;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;

class d implements AccountManagerCallback {
    final /* synthetic */ Runnable a;
    final /* synthetic */ a b;

    d(a aVar, Runnable runnable) {
        this.b = aVar;
        this.a = runnable;
    }

    public void run(AccountManagerFuture accountManagerFuture) {
        if (this.a != null) {
            this.a.run();
        }
    }
}
