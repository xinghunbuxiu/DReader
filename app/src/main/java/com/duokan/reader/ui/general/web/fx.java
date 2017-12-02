package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.ag;

import org.json.JSONObject;

class fx implements ag {
    final /* synthetic */ fv a;

    fx(fv fvVar) {
        this.a = fvVar;
    }

    public void a(JSONObject jSONObject) {
        this.a.a.b.b.triggerEventOnCurrentUrl("commentCommit", jSONObject);
    }
}
