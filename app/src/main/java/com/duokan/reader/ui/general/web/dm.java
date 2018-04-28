package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.MiAccount;

class dm implements as {
    /* renamed from: a */
    final /* synthetic */ String f7735a;
    /* renamed from: b */
    final /* synthetic */ dl f7736b;

    dm(dl dlVar, String str) {
        this.f7736b = dlVar;
        this.f7735a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        if (C0709k.m3476a().m3500a(MiAccount.class)) {
            C0709k.m3476a().m3498a(C0709k.m3476a().m3502b(MiAccount.class).mo832b(), new dn(this));
            return;
        }
        C0709k.m3476a().m3495a(new C1356do(this));
    }
}
