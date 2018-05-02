package com.duokan.reader.domain.social.message;

import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.social.p047a.C1131a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.social.message.j */
public class C1150j extends C1149i {
    /* renamed from: i */
    public final C1131a f5552i;
    /* renamed from: j */
    public final User f5553j;

    public C1150j(JSONObject jSONObject) {
        super(jSONObject);
        C1131a b = C1131a.m8453b(jSONObject);
        this.f5552i = b;
        User user = new User();
        user.mUserId = b.f5447b;
        user.mNickName = jSONObject.optString("re_reply_alias");
        user.mIconUrl = jSONObject.optString("re_reply_user_icon");
        this.f5553j = user;
    }

    /* renamed from: a */
    public User mo1515a() {
        return this.f5553j;
    }

    /* renamed from: b */
    public String mo1516b() {
        return this.f5552i.f5451f;
    }

    /* renamed from: c */
    public long mo1518c() {
        return this.f5552i.f5450e / 1000;
    }

    /* renamed from: b */
    public void mo1517b(JSONObject jSONObject) {
        try {
            jSONObject.put("re_reply_alias", this.f5553j.mNickName);
            jSONObject.put("re_reply_user_icon", this.f5553j.mIconUrl);
        } catch (JSONException e) {
        }
    }
}
