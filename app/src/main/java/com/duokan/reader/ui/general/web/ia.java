package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.sys.as;
import org.json.JSONObject;

class ia implements as {
    /* renamed from: a */
    final /* synthetic */ String f7963a;
    /* renamed from: b */
    final /* synthetic */ ci f7964b;

    ia(ci ciVar, String str) {
        this.f7964b = ciVar;
        this.f7963a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        JSONObject jSONObject = new JSONObject(this.f7963a);
        String optString = jSONObject.optString("msgid");
        jSONObject = jSONObject.optJSONObject("params");
        String optString2 = jSONObject.optString("url", "");
        String optString3 = jSONObject.optString("title", "");
        String optString4 = jSONObject.optString("wx_title", optString3);
        String optString5 = jSONObject.optString("wx_friends_title", optString3);
        optString3 = jSONObject.optString("cover", "");
        String optString6 = jSONObject.optString("wx_pic_url", optString3);
        String optString7 = jSONObject.optString("wx_friends_pic_url", optString3);
        String optString8 = jSONObject.optString("weibo_pic_url", "");
        optString3 = jSONObject.optString("summary", "");
        String optString9 = jSONObject.optString("wx_summary", optString3);
        String optString10 = jSONObject.optString("wx_friends_summary", optString3);
        String optString11 = jSONObject.optString("weibo_summary", optString3);
        Object optString12 = jSONObject.optString("bookUuids", "");
        String[] split = TextUtils.isEmpty(optString12) ? new String[0] : optString12.split(",");
        Object optString13 = jSONObject.optString("trace_ids", "");
        this.f7964b.m11016a(new ib(this, optString, optString4, optString9, optString6, optString5, optString10, optString7, optString8, optString2, split, TextUtils.isEmpty(optString13) ? new String[0] : optString13.split(","), optString11));
    }
}
