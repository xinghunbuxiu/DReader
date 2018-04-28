package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import org.json.JSONArray;
import org.json.JSONObject;

class fc implements as {
    /* renamed from: a */
    final /* synthetic */ String f7821a;
    /* renamed from: b */
    final /* synthetic */ ci f7822b;

    fc(ci ciVar, String str) {
        this.f7822b = ciVar;
        this.f7821a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f7821a);
        String string = jSONObject.getString("msgid");
        jSONObject = jSONObject.getJSONObject("params");
        JSONArray jSONArray = jSONObject.getJSONArray("items");
        String optString = jSONObject.optString("title");
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = jSONArray.getString(i);
        }
        this.f7822b.m11016a(new fd(this, optString, strArr, string));
    }
}
