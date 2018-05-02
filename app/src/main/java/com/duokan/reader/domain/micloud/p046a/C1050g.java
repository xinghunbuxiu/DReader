package com.duokan.reader.domain.micloud.p046a;

import com.duokan.reader.common.webservices.C0661o;
import com.duokan.reader.domain.micloud.bj;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.micloud.a.g */
class C1050g extends C0661o<C1058o> {
    /* renamed from: a */
    final /* synthetic */ C1044a f5166a;

    C1050g(C1044a c1044a, boolean z) {
        this.f5166a = c1044a;
        super(z);
    }

    /* renamed from: b */
    public /* synthetic */ Object mo819b(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        return m8033a(jSONObject, i, jSONObject2);
    }

    /* renamed from: a */
    public C1058o m8033a(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        C1058o c1058o = new C1058o();
        if (i == 0) {
            c1058o.f5180a = new bj(jSONObject2);
        } else {
            c1058o.f5180a = null;
        }
        return c1058o;
    }
}
