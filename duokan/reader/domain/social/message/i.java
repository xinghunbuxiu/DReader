package com.duokan.reader.domain.social.message;

import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.social.a.a;

import org.apache.http.cookie.ClientCookie;
import org.json.JSONException;
import org.json.JSONObject;

public class i extends l {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final String f;
    public final a g;
    public final User h;

    public i(JSONObject jSONObject) {
        this.a = jSONObject.optString("user_id");
        this.b = jSONObject.optString("feed_id");
        this.c = jSONObject.optString("book_id");
        this.d = jSONObject.optString("book_title");
        this.e = jSONObject.optInt("feed_type");
        this.f = jSONObject.optString(ClientCookie.COMMENT_ATTR);
        a a = a.a(jSONObject);
        this.g = a;
        User user = new User();
        user.mUserId = a.b;
        user.mNickName = jSONObject.optString("reply_alias");
        user.mIconUrl = jSONObject.optString("reply_user_icon");
        this.h = user;
    }

    public User a() {
        return this.h;
    }

    public String b() {
        return this.g.f;
    }

    public long c() {
        return this.g.e / 1000;
    }

    public void b(JSONObject jSONObject) {
        try {
            jSONObject.put("reply_alias", this.h.mNickName);
            jSONObject.put("reply_user_icon", this.h.mIconUrl);
        } catch (JSONException e) {
        }
    }
}
