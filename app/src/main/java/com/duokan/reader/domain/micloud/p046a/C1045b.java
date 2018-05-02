package com.duokan.reader.domain.micloud.p046a;

import com.duokan.reader.common.webservices.C0661o;
import com.duokan.reader.domain.micloud.bh;
import com.duokan.reader.domain.micloud.bi;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.micloud.a.b */
class C1045b extends C0661o<C1054k> {
    /* renamed from: a */
    final /* synthetic */ String f5157a;
    /* renamed from: b */
    final /* synthetic */ C1044a f5158b;

    C1045b(C1044a c1044a, boolean z, String str) {
        this.f5158b = c1044a;
        this.f5157a = str;
        super(z);
    }

    /* renamed from: b */
    public /* synthetic */ Object mo819b(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        return m8023a(jSONObject, i, jSONObject2);
    }

    /* renamed from: a */
    public C1054k m8023a(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        boolean z = false;
        C1054k c1054k = new C1054k();
        if (i == 0) {
            if (!jSONObject2.has("upload_id")) {
                z = true;
            }
            c1054k.f5172a = z;
            if (c1054k.f5172a) {
                c1054k.f5173b = null;
                c1054k.f5175d = new bi(this.f5158b.f5154a, this.f5158b.f5155b, this.f5157a, jSONObject2.getJSONObject("info"));
            } else {
                c1054k.f5173b = new bh(jSONObject2);
                c1054k.f5175d = null;
            }
            c1054k.f5174c = null;
        } else {
            c1054k.f5172a = false;
            c1054k.f5173b = null;
            c1054k.f5175d = null;
            if (i == 50010) {
                c1054k.f5174c = new C1059p(jSONObject2);
            } else {
                c1054k.f5174c = null;
            }
        }
        return c1054k;
    }
}
