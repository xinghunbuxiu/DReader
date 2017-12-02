package com.duokan.reader.domain.social.b;

import android.text.TextUtils;

import com.duokan.reader.domain.account.User;

import org.json.JSONException;
import org.json.JSONObject;

public class c {
    public String a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public float h;
    public String i;
    public String j;

    public c(String str) {
        this.a = str;
        this.b = false;
        this.c = 0;
        this.i = "";
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0.0f;
        this.j = "";
    }

    public c(User user) {
        this.a = user.mUserId;
        this.b = user.mIsVip;
        this.c = 0;
        this.i = "";
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0.0f;
        this.j = "";
    }

    public c(String str, JSONObject jSONObject) {
        boolean z = true;
        this.a = str;
        if (jSONObject.optInt("is_vip", 0) != 1) {
            z = false;
        }
        this.b = z;
        this.i = jSONObject.optString("description");
        if (TextUtils.isEmpty(this.i)) {
            this.i = jSONObject.optString("intro");
        }
        this.d = jSONObject.optInt("following_count", 0);
        this.e = jSONObject.optInt("follower_count", 0);
        this.f = jSONObject.optInt("note_count", 0);
        this.g = jSONObject.optInt("favourite_count", 0);
        this.h = (float) jSONObject.optDouble("ranking", 0.0d);
        this.j = jSONObject.optString("auth_info");
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_vip", this.b ? 1 : 0);
            jSONObject.put("following_count", this.d);
            jSONObject.put("follower_count", this.e);
            jSONObject.put("note_count", this.f);
            jSONObject.put("favourite_count", this.g);
            jSONObject.put("ranking", (double) this.h);
            jSONObject.put("description", this.i);
            jSONObject.put("auth_info", this.j);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void a(c cVar) {
        this.a = cVar.a;
        this.b = cVar.b;
        this.c = cVar.c;
        this.i = cVar.i;
        this.d = cVar.d;
        this.e = cVar.e;
        this.f = cVar.f;
        this.g = cVar.g;
        this.h = cVar.h;
        this.j = cVar.j;
    }
}
