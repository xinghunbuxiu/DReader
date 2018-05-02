package com.duokan.reader.domain.social.message;

import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.social.a.a;

import org.json.JSONException;
import org.json.JSONObject;

public class j extends i {
    public final a i;
    public final User j;

    public j(JSONObject jSONObject) {
        super(jSONObject);
        a b = a.b(jSONObject);
        this.i = b;
        User user = new User();
        user.mUserId = b.b;
        user.mNickName = jSONObject.optString("re_reply_alias");
        user.mIconUrl = jSONObject.optString("re_reply_user_icon");
        this.j = user;
    }

    public User a() {
        return this.j;
    }

    public String b() {
        return this.i.f;
    }

    public long c() {
        return this.i.e / 1000;
    }

    public void b(JSONObject jSONObject) {
        try {
            jSONObject.put("re_reply_alias", this.j.mNickName);
            jSONObject.put("re_reply_user_icon", this.j.mIconUrl);
        } catch (JSONException e) {
        }
    }
}
