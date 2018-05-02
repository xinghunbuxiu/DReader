package com.duokan.reader.domain.social.p047a;

import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.social.a.a */
public class C1131a {
    /* renamed from: a */
    public final String f5446a;
    /* renamed from: b */
    public final String f5447b;
    /* renamed from: c */
    public final boolean f5448c;
    /* renamed from: d */
    public final String f5449d;
    /* renamed from: e */
    public final long f5450e;
    /* renamed from: f */
    public final String f5451f;

    public C1131a(String str, String str2, boolean z, String str3, long j, String str4) {
        this.f5446a = str;
        this.f5447b = str2;
        this.f5448c = z;
        this.f5449d = str3;
        this.f5450e = j;
        this.f5451f = str4;
    }

    /* renamed from: a */
    public static C1131a m8452a(JSONObject jSONObject) {
        return new C1131a(jSONObject.optString("reply_id"), jSONObject.optString("reply_user_id"), false, "", 1000 * jSONObject.optLong("reply_time"), jSONObject.optString("reply"));
    }

    /* renamed from: b */
    public static C1131a m8453b(JSONObject jSONObject) {
        return new C1131a(jSONObject.optString("re_reply_id"), jSONObject.optString("re_reply_user_id"), false, "", 1000 * jSONObject.optLong("re_reply_time"), jSONObject.optString("re_reply"));
    }
}
