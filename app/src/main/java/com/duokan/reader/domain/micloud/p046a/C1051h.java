package com.duokan.reader.domain.micloud.p046a;

import com.duokan.reader.common.webservices.C0661o;
import com.duokan.reader.domain.micloud.bi;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.micloud.a.h */
class C1051h extends C0661o<C1052i> {
    /* renamed from: a */
    final /* synthetic */ String f5167a;
    /* renamed from: b */
    final /* synthetic */ C1044a f5168b;

    C1051h(C1044a c1044a, boolean z, String str) {
        this.f5168b = c1044a;
        this.f5167a = str;
        super(z);
    }

    /* renamed from: b */
    public /* synthetic */ Object mo819b(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        return m8035a(jSONObject, i, jSONObject2);
    }

    /* renamed from: a */
    public C1052i m8035a(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        C1052i c1052i = new C1052i();
        if (i == 0) {
            c1052i.f5169a = new bi(this.f5168b.f5154a, this.f5168b.f5155b, new File(this.f5167a).getParent(), jSONObject2.getJSONObject("info"));
        } else {
            c1052i.f5169a = null;
        }
        return c1052i;
    }
}
