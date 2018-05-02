package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.duokan.C0629b;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.cloud.k */
class C0851k implements C0666x {
    /* renamed from: a */
    final /* synthetic */ JSONObject f4078a;
    /* renamed from: b */
    final /* synthetic */ C0811o f4079b;
    /* renamed from: c */
    final /* synthetic */ boolean f4080c;
    /* renamed from: d */
    final /* synthetic */ C0848h f4081d;

    C0851k(C0848h c0848h, JSONObject jSONObject, C0811o c0811o, boolean z) {
        this.f4081d = c0848h;
        this.f4078a = jSONObject;
        this.f4079b = c0811o;
        this.f4080c = z;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        new C0852l(this, c0672a.mo832b(), C0629b.f2117a, c0672a).open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f4079b.mo1089a(str);
    }
}
