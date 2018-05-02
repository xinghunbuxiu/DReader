package com.duokan.reader.domain.micloud;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.app.Activity;

import com.duokan.core.app.ManagedApp;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;
import com.duokan.reader.common.async.work.e;
import com.duokan.reader.common.b.a;

class b implements Runnable {
    final /* synthetic */ e a;
    final /* synthetic */ Object b;
    final /* synthetic */ a c;

    b(a aVar, e eVar, Object obj) {
        this.c = aVar;
        this.a = eVar;
        this.b = obj;
    }

    public void run() {
        Activity topActivity = ManagedApp.get().getTopActivity();
        if (this.a.c != -40003 && this.a.c != -10007) {
            synchronized (this.b) {
                this.c.a = CheckErrorResult.Ignored;
                this.c.b = true;
                this.b.notify();
            }
        } else if (topActivity == null || topActivity.isFinishing()) {
            synchronized (this.b) {
                this.c.a = CheckErrorResult.Failed;
                this.c.b = true;
                this.b.notify();
            }
        } else {
            a a = com.duokan.reader.common.b.e.a(topActivity);
            AccountManagerCallback cVar = new c(this);
            Account i = a.i();
            if (i != null) {
                a.a(i, "micloud", null, topActivity, cVar);
            }
        }
    }
}
