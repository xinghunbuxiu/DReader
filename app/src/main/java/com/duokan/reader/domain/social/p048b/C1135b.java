package com.duokan.reader.domain.social.p048b;

import com.duokan.reader.domain.account.User;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.social.b.b */
public class C1135b {
    /* renamed from: a */
    public User f5458a = this.f2428e;
    /* renamed from: b */
    public C1136c f5459b = this.f2427d;

    /* renamed from: a */
    public JSONObject m8459a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", this.f5458a.mUserId);
            jSONObject.put("user_nick_name", this.f5458a.mNickName);
            jSONObject.put("user_icon", this.f5458a.mIconUrl);
            jSONObject.put("is_vip", this.f5458a.mIsVip);
            jSONObject.put("user_summary", this.f5459b.m8460a());
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
