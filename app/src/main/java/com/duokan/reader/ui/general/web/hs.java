package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.core.sys.as;

import org.json.JSONObject;

class hs implements as {
    final /* synthetic */ String a;
    final /* synthetic */ PageController b;

    hs(PageController cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(this.a);
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
        this.b.a(new ht(this, optString, optString4, optString9, optString6, optString5, optString10, optString7, optString8, optString2, split, TextUtils.isEmpty(optString13) ? new String[0] : optString13.split(","), optString11));
    }
}
