package com.duokan.reader.domain.micloud;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.os.Bundle;

import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;

class c implements AccountManagerCallback {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void run(AccountManagerFuture accountManagerFuture) {
        try {
            ((Bundle) accountManagerFuture.getResult()).getString("authtoken");
            synchronized (this.a.b) {
                this.a.c.a = CheckErrorResult.Passed;
                this.a.c.b = true;
                this.a.b.notify();
            }
        } catch (Exception e) {
            synchronized (this.a.b) {
                this.a.c.a = CheckErrorResult.Failed;
                this.a.c.b = true;
                this.a.b.notify();
            }
        }
    }
}
