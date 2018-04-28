package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.duokan.C0629b;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

class ab implements C0666x {
    /* renamed from: a */
    final /* synthetic */ String f3645a;
    /* renamed from: b */
    final /* synthetic */ boolean f3646b;
    /* renamed from: c */
    final /* synthetic */ String f3647c;
    /* renamed from: d */
    final /* synthetic */ ai f3648d;
    /* renamed from: e */
    final /* synthetic */ DkCloudStorage f3649e;

    ab(DkCloudStorage dkCloudStorage, String str, boolean z, String str2, ai aiVar) {
        this.f3649e = dkCloudStorage;
        this.f3645a = str;
        this.f3646b = z;
        this.f3647c = str2;
        this.f3648d = aiVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        new ac(this, c0672a.mo832b(), C0629b.f2117a, c0672a).open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3648d.mo1970a(str);
    }
}
