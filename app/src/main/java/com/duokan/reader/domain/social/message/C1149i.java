package com.duokan.reader.domain.social.message;

import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.social.p047a.C1131a;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.social.message.i */
public class C1149i extends C1138l {
    /* renamed from: a */
    public final String f5544a;
    /* renamed from: b */
    public final String f5545b;
    /* renamed from: c */
    public final String f5546c;
    /* renamed from: d */
    public final String f5547d;
    /* renamed from: e */
    public final int f5548e;
    /* renamed from: f */
    public final String f5549f;
    /* renamed from: g */
    public final C1131a f5550g;
    /* renamed from: h */
    public final User f5551h;

    public C1149i(JSONObject jSONObject) {
        this.f5544a = jSONObject.optString("user_id");
        this.f5545b = jSONObject.optString("feed_id");
        this.f5546c = jSONObject.optString("book_id");
        this.f5547d = jSONObject.optString("book_title");
        this.f5548e = jSONObject.optInt("feed_type");
        this.f5549f = jSONObject.optString(ClientCookie.COMMENT_ATTR);
        C1131a a = C1131a.m8452a(jSONObject);
        this.f5550g = a;
        User user = new User();
        user.mUserId = a.f5447b;
        user.mNickName = jSONObject.optString("reply_alias");
        user.mIconUrl = jSONObject.optString("reply_user_icon");
        this.f5551h = user;
    }

    /* renamed from: a */
    public User mo1515a() {
        return this.f5551h;
    }

    /* renamed from: b */
    public String mo1516b() {
        return this.f5550g.f5451f;
    }

    /* renamed from: c */
    public long mo1518c() {
        return this.f5550g.f5450e / 1000;
    }

    /* renamed from: b */
    public void mo1517b(JSONObject jSONObject) {
        try {
            jSONObject.put("reply_alias", this.f5551h.mNickName);
            jSONObject.put("reply_user_icon", this.f5551h.mIconUrl);
        } catch (JSONException e) {
        }
    }
}
