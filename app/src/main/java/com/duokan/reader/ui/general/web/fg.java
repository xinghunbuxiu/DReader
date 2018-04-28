package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import org.json.JSONArray;
import org.json.JSONObject;

class fg implements as {
    /* renamed from: a */
    final /* synthetic */ String f7829a;
    /* renamed from: b */
    final /* synthetic */ ci f7830b;

    fg(ci ciVar, String str) {
        this.f7830b = ciVar;
        this.f7829a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONArray jSONArray = new JSONObject(this.f7829a).getJSONArray("items");
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = jSONArray.getString(i);
        }
        this.f7830b.m11016a(new fh(this, strArr));
    }
}
