package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

import org.json.JSONArray;
import org.json.JSONObject;

class es implements as {
    final /* synthetic */ String a;
    final /* synthetic */ PageController b;

    es(PageController cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a);
        String string = jSONObject.getString("msgid");
        jSONObject = jSONObject.getJSONObject("params");
        JSONArray jSONArray = jSONObject.getJSONArray("items");
        String optString = jSONObject.optString("title");
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = jSONArray.getString(i);
        }
        this.b.a(new et(this, optString, strArr, string));
    }
}
