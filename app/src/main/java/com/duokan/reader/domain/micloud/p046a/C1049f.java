package com.duokan.reader.domain.micloud.p046a;

import com.duokan.reader.common.webservices.C0661o;
import com.duokan.reader.domain.micloud.bi;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.micloud.a.f */
class C1049f extends C0661o<C1056m> {
    /* renamed from: a */
    final /* synthetic */ String f5164a;
    /* renamed from: b */
    final /* synthetic */ C1044a f5165b;

    C1049f(C1044a c1044a, boolean z, String str) {
        this.f5165b = c1044a;
        this.f5164a = str;
        super(z);
    }

    /* renamed from: b */
    public /* synthetic */ Object mo819b(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        return m8031a(jSONObject, i, jSONObject2);
    }

    /* renamed from: a */
    public C1056m m8031a(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        C1056m c1056m = new C1056m();
        if (i == 0) {
            c1056m.f5178a = new bi(this.f5165b.f5154a, this.f5165b.f5155b, new File(this.f5164a).getParent(), jSONObject2.getJSONObject("info"));
        } else {
            c1056m.f5178a = null;
        }
        return c1056m;
    }
}
