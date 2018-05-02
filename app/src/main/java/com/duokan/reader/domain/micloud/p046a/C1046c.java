package com.duokan.reader.domain.micloud.p046a;

import com.duokan.reader.common.webservices.C0661o;
import com.duokan.reader.domain.micloud.bi;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.micloud.a.c */
class C1046c extends C0661o<C1053j> {
    /* renamed from: a */
    final /* synthetic */ String f5159a;
    /* renamed from: b */
    final /* synthetic */ C1044a f5160b;

    C1046c(C1044a c1044a, boolean z, String str) {
        this.f5160b = c1044a;
        this.f5159a = str;
        super(z);
    }

    /* renamed from: b */
    public /* synthetic */ Object mo819b(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        return m8025a(jSONObject, i, jSONObject2);
    }

    /* renamed from: a */
    public C1053j m8025a(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        C1053j c1053j = new C1053j();
        if (i == 0) {
            c1053j.f5170a = null;
            c1053j.f5171b = new bi(this.f5160b.f5154a, this.f5160b.f5155b, this.f5159a, jSONObject2.getJSONObject("info"));
        } else if (i == 50010) {
            c1053j.f5170a = new C1059p(jSONObject2);
            c1053j.f5171b = null;
        } else {
            c1053j.f5170a = null;
            c1053j.f5171b = null;
        }
        return c1053j;
    }
}
