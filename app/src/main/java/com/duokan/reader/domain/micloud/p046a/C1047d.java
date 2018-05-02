package com.duokan.reader.domain.micloud.p046a;

import com.duokan.reader.common.webservices.C0661o;
import com.duokan.reader.domain.micloud.az;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.micloud.a.d */
class C1047d extends C0661o<C1055l> {
    /* renamed from: a */
    final /* synthetic */ C1044a f5161a;

    C1047d(C1044a c1044a, boolean z) {
        this.f5161a = c1044a;
        super(z);
    }

    /* renamed from: b */
    public /* synthetic */ Object mo819b(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        return m8027a(jSONObject, i, jSONObject2);
    }

    /* renamed from: a */
    public C1055l m8027a(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        C1055l c1055l = new C1055l();
        if (i == 0) {
            c1055l.f5176a = new az(jSONObject2);
            c1055l.f5177b = null;
        } else {
            c1055l.f5176a = null;
            if (i == 50010) {
                c1055l.f5177b = new C1059p(jSONObject2);
            } else {
                c1055l.f5177b = null;
            }
        }
        return c1055l;
    }
}
