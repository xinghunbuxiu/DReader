package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

import org.json.JSONArray;
import org.json.JSONObject;

class ew implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    ew(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        JSONArray jSONArray = new JSONObject(this.a).getJSONArray("items");
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = jSONArray.getString(i);
        }
        this.b.a(new ex(this, strArr));
    }
}
