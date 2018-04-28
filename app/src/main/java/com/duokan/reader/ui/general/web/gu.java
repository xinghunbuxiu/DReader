package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.domain.store.C1176a;
import org.json.JSONObject;

class gu implements as {
    /* renamed from: a */
    final /* synthetic */ String f7904a;
    /* renamed from: b */
    final /* synthetic */ ci f7905b;

    gu(ci ciVar, String str) {
        this.f7905b = ciVar;
        this.f7904a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f7904a);
        String string = jSONObject.getString("msgid");
        String string2 = jSONObject.getJSONObject("params").getString("bookUuid");
        C1176a.m8695a().m8705b(string2, false, new gv(this, string2, string));
    }
}
