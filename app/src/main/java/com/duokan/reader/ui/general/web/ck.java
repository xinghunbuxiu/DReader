package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.C0611i;
import org.json.JSONObject;

class ck implements as {
    /* renamed from: a */
    final /* synthetic */ String f7674a;
    /* renamed from: b */
    final /* synthetic */ ci f7675b;

    ck(ci ciVar, String str) {
        this.f7675b = ciVar;
        this.f7674a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f7674a);
        this.f7675b.m11016a(new cl(this, jSONObject.getBoolean("show"), C0611i.m2786a(jSONObject, "msg", this.f7675b.f7581b.getContext().getString(C0258j.bookcity_store__shared__creating_order)), jSONObject.optBoolean("cancelable", true), jSONObject.optBoolean("now", false)));
    }
}
