package com.duokan.reader.domain.micloud;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.os.Bundle;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;

/* renamed from: com.duokan.reader.domain.micloud.c */
class C1062c implements AccountManagerCallback<Bundle> {
    /* renamed from: a */
    final /* synthetic */ C1061b f5259a;

    C1062c(C1061b c1061b) {
        this.f5259a = c1061b;
    }

    public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
        try {
            ((Bundle) accountManagerFuture.getResult()).getString("authtoken");
            synchronized (this.f5259a.f5212b) {
                this.f5259a.f5213c.f5183a = CheckErrorResult.Passed;
                this.f5259a.f5213c.f5184b = true;
                this.f5259a.f5212b.notify();
            }
        } catch (Exception e) {
            synchronized (this.f5259a.f5212b) {
                this.f5259a.f5213c.f5183a = CheckErrorResult.Failed;
                this.f5259a.f5213c.f5184b = true;
                this.f5259a.f5212b.notify();
            }
        }
    }
}
