package com.duokan.reader.domain.social.message;

import com.duokan.reader.domain.account.User;
import org.json.JSONException;
import org.json.JSONObject;

public class av extends C1138l {
    /* renamed from: a */
    public final User f5529a = new User();

    public av(User user) {
        User.copy(user, this.f5529a);
    }

    /* renamed from: a */
    public static av m8532a(JSONObject jSONObject) {
        User user = new User();
        user.mUserId = jSONObject.getString("user_id");
        user.mNickName = jSONObject.optString("user_nick_name");
        user.mIconUrl = jSONObject.optString("user_icon");
        return new av(user);
    }

    /* renamed from: a */
    public User mo1515a() {
        return this.f5529a;
    }

    /* renamed from: b */
    public String mo1516b() {
        return "";
    }

    /* renamed from: c */
    public long mo1518c() {
        return 0;
    }

    /* renamed from: b */
    public void mo1517b(JSONObject jSONObject) {
        try {
            jSONObject.put("user_nick_name", this.f5529a.mNickName);
            jSONObject.put("user_icon", this.f5529a.mIconUrl);
        } catch (JSONException e) {
        }
    }
}
