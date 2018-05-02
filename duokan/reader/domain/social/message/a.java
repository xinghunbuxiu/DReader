package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.webservices.duokan.d;
import com.duokan.reader.domain.account.User;

import org.json.JSONObject;

public class a extends l {
    public d a;

    public static a a(JSONObject jSONObject) {
        a aVar = new a();
        d dVar = new d();
        dVar.a.mUserId = "800383";
        dVar.a.mNickName = jSONObject.getString("user_nick");
        dVar.a.mIconUrl = jSONObject.getString("user_icon");
        dVar.d = jSONObject.getString("object_id");
        dVar.c = jSONObject.getString("title");
        dVar.b = jSONObject.getString("content");
        dVar.e = jSONObject.getLong("time");
        aVar.a = dVar;
        return aVar;
    }

    public User a() {
        return this.a.a;
    }

    public String b() {
        return this.a.b;
    }

    public long c() {
        return this.a.e;
    }

    public void b(JSONObject jSONObject) {
    }
}
