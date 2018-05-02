package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.webservices.duokan.f;
import com.duokan.reader.domain.account.User;

import org.json.JSONObject;

public class c extends l {
    public f a;

    public static c a(JSONObject jSONObject) {
        c cVar = new c();
        f fVar = new f();
        fVar.a.mUserId = jSONObject.getString("user_id");
        fVar.a.mNickName = jSONObject.optString("user_nick");
        fVar.a.mIconUrl = jSONObject.optString("user_icon");
        fVar.c = jSONObject.getString("object_id");
        fVar.b = jSONObject.getInt("type");
        fVar.d = jSONObject.getString("ref");
        fVar.e = jSONObject.getLong("time");
        cVar.a = fVar;
        return cVar;
    }

    public User a() {
        return this.a.a;
    }

    public String b() {
        return "";
    }

    public long c() {
        return this.a.e;
    }

    public void b(JSONObject jSONObject) {
    }
}
