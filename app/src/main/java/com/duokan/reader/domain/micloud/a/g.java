package com.duokan.reader.domain.micloud.a;

import com.duokan.reader.common.webservices.m;
import com.duokan.reader.domain.micloud.bj;

import org.json.JSONObject;

class g extends m {
    final /* synthetic */ a a;

    g(a aVar, boolean z) {
        this.a = aVar;
        super(z);
    }

    public /* synthetic */ Object b(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        return a(jSONObject, i, jSONObject2);
    }

    public o a(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        o oVar = new o();
        if (i == 0) {
            oVar.a = new bj(jSONObject2);
        } else {
            oVar.a = null;
        }
        return oVar;
    }
}
