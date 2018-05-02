package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.webservices.duokan.C0632e;
import com.duokan.reader.domain.account.User;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.social.message.b */
public class C1141b extends C1138l {
    /* renamed from: a */
    public C0632e f5532a;

    /* renamed from: a */
    public static C1141b m8539a(JSONObject jSONObject) {
        C1141b c1141b = new C1141b();
        C0632e c0632e = new C0632e();
        c0632e.f2125a.mUserId = jSONObject.getString("comment_user");
        c0632e.f2125a.mNickName = jSONObject.optString("comment_user_nick");
        c0632e.f2125a.mIconUrl = jSONObject.optString("comment_user_icon");
        c0632e.f2128d = jSONObject.getString("object_id");
        c0632e.f2127c = jSONObject.getInt("type");
        c0632e.f2126b = jSONObject.getString("content");
        c0632e.f2129e = jSONObject.getString("ref");
        c0632e.f2130f = jSONObject.getLong("time");
        c1141b.f5532a = c0632e;
        return c1141b;
    }

    /* renamed from: a */
    public User mo1515a() {
        return this.f5532a.f2125a;
    }

    /* renamed from: b */
    public String mo1516b() {
        return this.f5532a.f2126b;
    }

    /* renamed from: c */
    public long mo1518c() {
        return this.f5532a.f2130f;
    }

    /* renamed from: b */
    public void mo1517b(JSONObject jSONObject) {
    }
}
