package com.duokan.reader.domain.social.message;

import com.duokan.reader.domain.account.User;

import org.json.JSONException;
import org.json.JSONObject;

public class ba extends l {
    public final User a = new User();

    public ba(User user) {
        User.copy(user, this.a);
    }

    public static ba a(JSONObject jSONObject) {
        User user = new User();
        user.mUserId = jSONObject.getString("user_id");
        user.mNickName = jSONObject.optString("user_nick_name");
        user.mIconUrl = jSONObject.optString("user_icon");
        return new ba(user);
    }

    public User a() {
        return this.a;
    }

    public String b() {
        return "";
    }

    public long c() {
        return 0;
    }

    public void b(JSONObject jSONObject) {
        try {
            jSONObject.put("user_nick_name", this.a.mNickName);
            jSONObject.put("user_icon", this.a.mIconUrl);
        } catch (JSONException e) {
        }
    }
}
