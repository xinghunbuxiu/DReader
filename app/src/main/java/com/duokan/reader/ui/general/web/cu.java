package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.common.C0611i;
import org.json.JSONObject;

class cu implements as {
    /* renamed from: a */
    final /* synthetic */ String f7703a;
    /* renamed from: b */
    final /* synthetic */ ci f7704b;

    cu(ci ciVar, String str) {
        this.f7704b = ciVar;
        this.f7703a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f7703a);
        this.f7704b.m11016a(new cv(this, jSONObject.getBoolean("add"), C0611i.m2793b(jSONObject, "text")));
    }
}
