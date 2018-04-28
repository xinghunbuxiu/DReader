package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.duokan.C0629b;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

class fa implements C0666x {
    /* renamed from: a */
    final /* synthetic */ DkCloudRedeemFund f3974a;
    /* renamed from: b */
    final /* synthetic */ String f3975b;
    /* renamed from: c */
    final /* synthetic */ fk f3976c;
    /* renamed from: d */
    final /* synthetic */ ex f3977d;

    fa(ex exVar, DkCloudRedeemFund dkCloudRedeemFund, String str, fk fkVar) {
        this.f3977d = exVar;
        this.f3974a = dkCloudRedeemFund;
        this.f3975b = str;
        this.f3976c = fkVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        new fb(this, c0672a.mo832b(), C0629b.f2117a, c0672a).open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3976c.mo1928a(str);
    }
}
