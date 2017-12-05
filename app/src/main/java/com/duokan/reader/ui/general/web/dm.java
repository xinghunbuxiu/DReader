package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.i;

import java.util.concurrent.Callable;

class dm implements Callable {
    final /* synthetic */ PageController a;

    dm(PageController cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Boolean a() {
        return Boolean.valueOf(AccountType.XIAOMI_GUEST.equals(i.f().a()));
    }
}
