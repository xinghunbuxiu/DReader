package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.sys.as;
import org.json.JSONObject;

class ie implements as {
    /* renamed from: a */
    final /* synthetic */ String f7981a;
    /* renamed from: b */
    final /* synthetic */ ci f7982b;

    ie(ci ciVar, String str) {
        this.f7982b = ciVar;
        this.f7981a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f7981a);
        String optString = jSONObject.optString("url", "");
        String optString2 = jSONObject.optString("title", "");
        String optString3 = jSONObject.optString("cover", "");
        String optString4 = jSONObject.optString("summary", "");
        Object optString5 = jSONObject.optString("bookUuids", "");
        String[] split = TextUtils.isEmpty(optString5) ? new String[0] : optString5.split(",");
        Object optString6 = jSONObject.optString("trace_id", "");
        this.f7982b.m11016a(new C1362if(this, optString, optString2, optString4, optString3, split, TextUtils.isEmpty(optString6) ? new String[0] : optString6.split(",")));
    }
}
