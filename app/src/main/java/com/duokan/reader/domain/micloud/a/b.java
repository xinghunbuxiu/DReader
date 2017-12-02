package com.duokan.reader.domain.micloud.a;

import com.duokan.reader.common.webservices.m;
import com.duokan.reader.domain.micloud.bh;
import com.duokan.reader.domain.micloud.bi;

import org.json.JSONObject;

class b extends m {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    b(a aVar, boolean z, String str) {
        this.b = aVar;
        this.a = str;
        super(z);
    }

    public /* synthetic */ Object b(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        return a(jSONObject, i, jSONObject2);
    }

    public k a(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        boolean z = false;
        k kVar = new k();
        if (i == 0) {
            if (!jSONObject2.has("upload_id")) {
                z = true;
            }
            kVar.a = z;
            if (kVar.a) {
                kVar.b = null;
                kVar.d = new bi(this.b.a, this.b.b, this.a, jSONObject2.getJSONObject("info"));
            } else {
                kVar.b = new bh(jSONObject2);
                kVar.d = null;
            }
            kVar.c = null;
        } else {
            kVar.a = false;
            kVar.b = null;
            kVar.d = null;
            if (i == 50010) {
                kVar.c = new p(jSONObject2);
            } else {
                kVar.c = null;
            }
        }
        return kVar;
    }
}
