package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.duokan.C0629b;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

/* renamed from: com.duokan.reader.domain.cloud.p */
class C0855p implements C0666x {
    /* renamed from: a */
    final /* synthetic */ String f4086a;
    /* renamed from: b */
    final /* synthetic */ ah f4087b;
    /* renamed from: c */
    final /* synthetic */ DkCloudStorage f4088c;

    C0855p(DkCloudStorage dkCloudStorage, String str, ah ahVar) {
        this.f4088c = dkCloudStorage;
        this.f4086a = str;
        this.f4087b = ahVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        new C0882q(this, C0629b.f2117a, c0672a).open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f4087b.mo1048a(this.f4086a, str);
    }
}
