package com.duokan.reader.domain.micloud.a;

import com.duokan.reader.common.webservices.m;
import com.duokan.reader.domain.micloud.bi;

import org.json.JSONObject;

import java.io.File;

class f extends m {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    f(a aVar, boolean z, String str) {
        this.b = aVar;
        this.a = str;
        super(z);
    }

    public /* synthetic */ Object b(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        return a(jSONObject, i, jSONObject2);
    }

    public m a(JSONObject jSONObject, int i, JSONObject jSONObject2) {
        m mVar = new m();
        if (i == 0) {
            mVar.a = new bi(this.b.a, this.b.b, new File(this.a).getParent(), jSONObject2.getJSONObject("info"));
        } else {
            mVar.a = null;
        }
        return mVar;
    }
}
