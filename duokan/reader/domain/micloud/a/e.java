package com.duokan.reader.domain.micloud.a;

import com.duokan.reader.common.webservices.m;
import com.duokan.reader.domain.micloud.bi;

import org.json.JSONObject;

import java.util.ArrayList;

class e extends m {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    e(a aVar, boolean z, String str) {
        this.b = aVar;
        this.a = str;
        super(z);
    }

    public /* synthetic */ Object b(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        return a(jSONObject, i, jSONObject2);
    }

    public n a(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        n nVar = new n();
        if (i == 0) {
            nVar.a = bi.a(this.b.a, this.b.b, this.a, jSONObject2.optJSONArray("list"));
        } else {
            nVar.a = new ArrayList();
        }
        return nVar;
    }
}
