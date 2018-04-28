package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.ag;
import org.json.JSONObject;

class gl implements ag<JSONObject> {
    /* renamed from: a */
    final /* synthetic */ gj f7891a;

    gl(gj gjVar) {
        this.f7891a = gjVar;
    }

    public /* synthetic */ void run(Object obj) {
        m11151a((JSONObject) obj);
    }

    /* renamed from: a */
    public void m11151a(JSONObject jSONObject) {
        this.f7891a.f7889b.f7581b.triggerEventOnCurrentUrl("feedCommit", jSONObject);
        this.f7891a.f7889b.f7581b.mEditFeedController = null;
    }
}
