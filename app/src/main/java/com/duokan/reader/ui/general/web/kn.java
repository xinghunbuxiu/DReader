package com.duokan.reader.ui.general.web;

import com.duokan.core.app.ac;
import com.duokan.core.app.ad;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.ui.personal.eu;

class kn implements ad {
    /* renamed from: a */
    final /* synthetic */ eu f8107a;
    /* renamed from: b */
    final /* synthetic */ km f8108b;

    kn(km kmVar, eu euVar) {
        this.f8108b = kmVar;
        this.f8107a = euVar;
    }

    /* renamed from: a */
    public void mo1553a(ac acVar) {
        if (C0709k.m3476a().m3501b().equals(AccountType.XIAOMI_GUEST)) {
            C0709k.m3476a().m3508d().mo830a(new ko(this));
        } else {
            C0709k.m3476a().m3497a(MiAccount.class, new kq(this));
        }
    }

    /* renamed from: b */
    public void mo1554b(ac acVar) {
    }
}
