package com.duokan.reader.domain.social.b;

import com.duokan.reader.domain.account.User;

import org.json.JSONException;
import org.json.JSONObject;

public class b {
    public User a = this.e;
    public c b = this.d;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", this.a.mUserId);
            jSONObject.put("user_nick_name", this.a.mNickName);
            jSONObject.put("user_icon", this.a.mIconUrl);
            jSONObject.put("is_vip", this.a.mIsVip);
            jSONObject.put("user_summary", this.b.a());
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
