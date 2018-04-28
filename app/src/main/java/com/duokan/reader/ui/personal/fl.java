package com.duokan.reader.ui.personal;

import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.ui.general.be;

class fl implements C0666x {
    /* renamed from: a */
    final /* synthetic */ eu f8545a;

    fl(eu euVar) {
        this.f8545a = euVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f8545a.m11778b(c0672a);
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        be.m10286a(this.f8545a.f8523a, C0258j.general__shared__login_failed, 0).show();
    }
}
