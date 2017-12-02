package com.duokan.reader.domain.micloud.a;

import com.duokan.reader.common.webservices.m;
import com.duokan.reader.domain.micloud.az;

import org.json.JSONObject;

class d extends m {
    final /* synthetic */ a a;

    d(a aVar, boolean z) {
        this.a = aVar;
        super(z);
    }

    public /* synthetic */ Object b(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        return a(jSONObject, i, jSONObject2);
    }

    public l a(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        l lVar = new l();
        if (i == 0) {
            lVar.a = new az(jSONObject2);
            lVar.b = null;
        } else {
            lVar.a = null;
            if (i == 50010) {
                lVar.b = new p(jSONObject2);
            } else {
                lVar.b = null;
            }
        }
        return lVar;
    }
}
