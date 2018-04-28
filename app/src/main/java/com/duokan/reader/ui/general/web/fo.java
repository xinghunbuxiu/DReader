package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.common.C0611i;
import org.json.JSONObject;

class fo implements as {
    /* renamed from: a */
    final /* synthetic */ String f7844a;
    /* renamed from: b */
    final /* synthetic */ ci f7845b;

    fo(ci ciVar, String str) {
        this.f7845b = ciVar;
        this.f7844a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f7844a);
        JSONObject optJSONObject = jSONObject.optJSONObject("flag");
        boolean z = jSONObject.getBoolean("show");
        boolean z2 = jSONObject.getBoolean("focus");
        String b = C0611i.m2793b(jSONObject, "hint");
        String b2 = C0611i.m2793b(jSONObject, "confirm");
        this.f7845b.m11016a(new fp(this, z, optJSONObject, b, C0611i.m2793b(jSONObject, "inputted"), b2, z2));
    }
}
