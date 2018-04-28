package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.MiAccount;
import java.util.concurrent.Callable;

class da implements Callable<String> {
    /* renamed from: a */
    final /* synthetic */ ci f7714a;

    da(ci ciVar) {
        this.f7714a = ciVar;
    }

    public /* synthetic */ Object call() {
        return m11075a();
    }

    /* renamed from: a */
    public String m11075a() {
        return MiAccount.m3186b(this.f7714a.f7581b.getContext()) ? MiAccount.m3187c(this.f7714a.f7581b.getContext()).name : "";
    }
}
