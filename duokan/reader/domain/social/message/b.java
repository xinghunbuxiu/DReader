package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.webservices.duokan.e;
import com.duokan.reader.domain.account.User;

import org.json.JSONObject;

public class b extends l {
    public e a;

    public static b a(JSONObject jSONObject) {
        b bVar = new b();
        e eVar = new e();
        eVar.a.mUserId = jSONObject.getString("comment_user");
        eVar.a.mNickName = jSONObject.optString("comment_user_nick");
        eVar.a.mIconUrl = jSONObject.optString("comment_user_icon");
        eVar.d = jSONObject.getString("object_id");
        eVar.c = jSONObject.getInt("type");
        eVar.b = jSONObject.getString("content");
        eVar.e = jSONObject.getString("ref");
        eVar.f = jSONObject.getLong("time");
        bVar.a = eVar;
        return bVar;
    }

    public User a() {
        return this.a.a;
    }

    public String b() {
        return this.a.b;
    }

    public long c() {
        return this.a.f;
    }

    public void b(JSONObject jSONObject) {
    }
}
