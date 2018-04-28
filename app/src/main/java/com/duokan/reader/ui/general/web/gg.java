package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.ag;
import org.json.JSONObject;

class gg implements ag<JSONObject> {
    /* renamed from: a */
    final /* synthetic */ gf f7885a;

    gg(gf gfVar) {
        this.f7885a = gfVar;
    }

    public /* synthetic */ void run(Object obj) {
        m11146a((JSONObject) obj);
    }

    /* renamed from: a */
    public void m11146a(JSONObject jSONObject) {
        this.f7885a.f7884a.f7883b.f7581b.triggerEventOnCurrentUrl("commentCommit", jSONObject);
    }
}
