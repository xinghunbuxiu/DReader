package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.ag;
import org.json.JSONObject;

class gk implements ag<JSONObject> {
    /* renamed from: a */
    final /* synthetic */ gj f7890a;

    gk(gj gjVar) {
        this.f7890a = gjVar;
    }

    public /* synthetic */ void run(Object obj) {
        m11150a((JSONObject) obj);
    }

    /* renamed from: a */
    public void m11150a(JSONObject jSONObject) {
        this.f7890a.f7889b.f7581b.triggerEventOnCurrentUrl("feedCommit", jSONObject);
    }
}
