package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.C0611i;
import org.json.JSONObject;

class fu implements as {
    /* renamed from: a */
    final /* synthetic */ String f7860a;
    /* renamed from: b */
    final /* synthetic */ ci f7861b;

    fu(ci ciVar, String str) {
        this.f7861b = ciVar;
        this.f7860a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f7860a);
        String string = jSONObject.getString("msgid");
        jSONObject = jSONObject.getJSONObject("params");
        String b = C0611i.m2793b(jSONObject, "title");
        String b2 = C0611i.m2793b(jSONObject, "prompt");
        String a = C0611i.m2786a(jSONObject, "cancel", this.f7861b.f7581b.getContext().getString(C0258j.general__shared__cancel));
        this.f7861b.m11016a(new fv(this, b, b2, C0611i.m2786a(jSONObject, "confirm", this.f7861b.f7581b.getContext().getString(C0258j.general__shared__confirm)), a, string));
    }
}
