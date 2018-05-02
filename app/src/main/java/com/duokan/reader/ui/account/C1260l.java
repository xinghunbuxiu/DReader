package com.duokan.reader.ui.account;

import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.oauth.ThirdOAuth.UpdateHandler;
import com.duokan.reader.ui.general.be;

/* renamed from: com.duokan.reader.ui.account.l */
class C1260l implements UpdateHandler {
    /* renamed from: a */
    final /* synthetic */ C1259k f5962a;

    C1260l(C1259k c1259k) {
        this.f5962a = c1259k;
    }

    public void onUpdateOk() {
        be.m10286a(this.f5962a.f5961b.f5959a.getContext(), C0258j.account__oauth__ok, 1).show();
    }

    public void onUpdateError() {
        be.m10286a(this.f5962a.f5961b.f5959a.getContext(), C0258j.account__oauth__error, 1).show();
    }

    public void onUpdateCancel() {
    }
}
