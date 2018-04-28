package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.account.C0672a;
import com.wali.live.sdk.manager.MiLiveSdkController;

class fk implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0672a f8543a;
    /* renamed from: b */
    final /* synthetic */ eu f8544b;

    fk(eu euVar, C0672a c0672a) {
        this.f8544b = euVar;
        this.f8543a = c0672a;
    }

    public void run() {
        MiLiveSdkController.getInstance().loginByMiAccountSso(Long.parseLong(this.f8543a.mo832b()), this.f8544b.m11775a(this.f8544b.f8523a.getApplicationContext()), null);
    }
}
