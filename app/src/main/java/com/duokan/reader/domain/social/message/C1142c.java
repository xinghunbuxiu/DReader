package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.webservices.duokan.C0633f;
import com.duokan.reader.domain.account.User;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.social.message.c */
public class C1142c extends C1138l {
    /* renamed from: a */
    public C0633f f5533a;

    /* renamed from: a */
    public static C1142c m8544a(JSONObject jSONObject) {
        C1142c c1142c = new C1142c();
        C0633f c0633f = new C0633f();
        c0633f.f2131a.mUserId = jSONObject.getString("user_id");
        c0633f.f2131a.mNickName = jSONObject.optString("user_nick");
        c0633f.f2131a.mIconUrl = jSONObject.optString("user_icon");
        c0633f.f2133c = jSONObject.getString("object_id");
        c0633f.f2132b = jSONObject.getInt("type");
        c0633f.f2134d = jSONObject.getString("ref");
        c0633f.f2135e = jSONObject.getLong("time");
        c1142c.f5533a = c0633f;
        return c1142c;
    }

    /* renamed from: a */
    public User mo1515a() {
        return this.f5533a.f2131a;
    }

    /* renamed from: b */
    public String mo1516b() {
        return "";
    }

    /* renamed from: c */
    public long mo1518c() {
        return this.f5533a.f2135e;
    }

    /* renamed from: b */
    public void mo1517b(JSONObject jSONObject) {
    }
}
