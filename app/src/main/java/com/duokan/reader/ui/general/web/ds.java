package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0709k;
import java.util.concurrent.Callable;

class ds implements Callable<Boolean> {
    /* renamed from: a */
    final /* synthetic */ ci f7744a;

    ds(ci ciVar) {
        this.f7744a = ciVar;
    }

    public /* synthetic */ Object call() {
        return m11090a();
    }

    /* renamed from: a */
    public Boolean m11090a() {
        return Boolean.valueOf(AccountType.XIAOMI_GUEST.equals(C0709k.m3476a().m3501b()));
    }
}
