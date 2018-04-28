package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.ag;
import org.json.JSONObject;

class gh implements ag<JSONObject> {
    /* renamed from: a */
    final /* synthetic */ gf f7886a;

    gh(gf gfVar) {
        this.f7886a = gfVar;
    }

    public /* synthetic */ void run(Object obj) {
        m11147a((JSONObject) obj);
    }

    /* renamed from: a */
    public void m11147a(JSONObject jSONObject) {
        this.f7886a.f7884a.f7883b.f7581b.triggerEventOnCurrentUrl("commentCommit", jSONObject);
    }
}
