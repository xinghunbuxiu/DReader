package com.duokan.reader.domain.micloud.a;

import com.duokan.reader.common.webservices.m;
import com.duokan.reader.domain.micloud.bi;

import org.json.JSONObject;

class c extends m {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    c(a aVar, boolean z, String str) {
        this.b = aVar;
        this.a = str;
        super(z);
    }

    public /* synthetic */ Object b(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        return a(jSONObject, i, jSONObject2);
    }

    public j a(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        j jVar = new j();
        if (i == 0) {
            jVar.a = null;
            jVar.b = new bi(this.b.a, this.b.b, this.a, jSONObject2.getJSONObject("info"));
        } else if (i == 50010) {
            jVar.a = new p(jSONObject2);
            jVar.b = null;
        } else {
            jVar.a = null;
            jVar.b = null;
        }
        return jVar;
    }
}
