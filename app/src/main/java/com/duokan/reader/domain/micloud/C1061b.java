package com.duokan.reader.domain.micloud;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.app.Activity;
import com.duokan.core.app.ManagedApp;
import com.duokan.reader.common.async.work.C0525e;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;
import com.duokan.reader.common.p036b.C0538a;
import com.duokan.reader.common.p036b.C0542e;

/* renamed from: com.duokan.reader.domain.micloud.b */
class C1061b implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0525e f5211a;
    /* renamed from: b */
    final /* synthetic */ Object f5212b;
    /* renamed from: c */
    final /* synthetic */ C1060a f5213c;

    C1061b(C1060a c1060a, C0525e c0525e, Object obj) {
        this.f5213c = c1060a;
        this.f5211a = c0525e;
        this.f5212b = obj;
    }

    public void run() {
        Activity topActivity = ManagedApp.get().getTopActivity();
        if (this.f5211a.f1775c != -40003 && this.f5211a.f1775c != -10007) {
            synchronized (this.f5212b) {
                this.f5213c.f5183a = CheckErrorResult.Ignored;
                this.f5213c.f5184b = true;
                this.f5212b.notify();
            }
        } else if (topActivity == null || topActivity.isFinishing()) {
            synchronized (this.f5212b) {
                this.f5213c.f5183a = CheckErrorResult.Failed;
                this.f5213c.f5184b = true;
                this.f5212b.notify();
            }
        } else {
            C0538a a = C0542e.m2411a(topActivity);
            AccountManagerCallback c1062c = new C1062c(this);
            Account i = a.m2409i();
            if (i != null) {
                a.m2391a(i, "micloud", null, topActivity, c1062c);
            }
        }
    }
}
