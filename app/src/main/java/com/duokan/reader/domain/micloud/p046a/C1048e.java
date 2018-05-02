package com.duokan.reader.domain.micloud.p046a;

import com.duokan.reader.common.webservices.C0661o;
import com.duokan.reader.domain.micloud.bi;
import java.util.ArrayList;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.micloud.a.e */
class C1048e extends C0661o<C1057n> {
    /* renamed from: a */
    final /* synthetic */ String f5162a;
    /* renamed from: b */
    final /* synthetic */ C1044a f5163b;

    C1048e(C1044a c1044a, boolean z, String str) {
        this.f5163b = c1044a;
        this.f5162a = str;
        super(z);
    }

    /* renamed from: b */
    public /* synthetic */ Object mo819b(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        return m8029a(jSONObject, i, jSONObject2);
    }

    /* renamed from: a */
    public C1057n m8029a(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        C1057n c1057n = new C1057n();
        if (i == 0) {
            c1057n.f5179a = bi.m8147a(this.f5163b.f5154a, this.f5163b.f5155b, this.f5162a, jSONObject2.optJSONArray("list"));
        } else {
            c1057n.f5179a = new ArrayList();
        }
        return c1057n;
    }
}
