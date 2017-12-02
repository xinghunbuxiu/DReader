package com.duokan.reader.domain.social.a;

import org.json.JSONObject;

public class a {
    public final String a;
    public final String b;
    public final boolean c;
    public final String d;
    public final long e;
    public final String f;

    public a(String str, String str2, boolean z, String str3, long j, String str4) {
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = str3;
        this.e = j;
        this.f = str4;
    }

    public static a a(JSONObject jSONObject) {
        return new a(jSONObject.optString("reply_id"), jSONObject.optString("reply_user_id"), false, "", 1000 * jSONObject.optLong("reply_time"), jSONObject.optString("reply"));
    }

    public static a b(JSONObject jSONObject) {
        return new a(jSONObject.optString("re_reply_id"), jSONObject.optString("re_reply_user_id"), false, "", 1000 * jSONObject.optLong("re_reply_time"), jSONObject.optString("re_reply"));
    }
}
