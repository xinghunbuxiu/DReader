package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.MiAccount;

import java.util.concurrent.Callable;

class ct implements Callable {
    final /* synthetic */ PageController a;

    ct(PageController cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public String a() {
        return MiAccount.a(this.a.pageController.getContext()) ? MiAccount.b(this.a.pageController.getContext()).name : "";
    }
}
