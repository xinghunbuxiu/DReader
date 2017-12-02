package com.duokan.reader.domain.account;

import org.json.JSONException;
import org.json.JSONObject;

public class br {
    public String a;
    public String b;
    public String c;
    public long d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    public static br a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            jSONObject2 = jSONObject;
        }
        br brVar = new br();
        brVar.a = jSONObject.optString("openid");
        brVar.b = jSONObject.optString("access_token");
        brVar.c = jSONObject.optString("unionid");
        brVar.d = jSONObject.optLong("expires_in");
        brVar.e = jSONObject.optString("scope");
        brVar.f = jSONObject.optString("refresh_token");
        brVar.g = jSONObject2.optString("nickname");
        brVar.h = jSONObject2.optString("avatarUrl");
        brVar.i = jSONObject2.optString("unionIdSign");
        return brVar;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("openid", this.a);
            jSONObject.put("unionid", this.c);
            jSONObject.put("expires_in", this.d);
            jSONObject.put("scope", this.e);
            jSONObject.put("nickname", this.g);
            jSONObject.put("avatarUrl", this.h);
            jSONObject.put("unionIdSign", this.i);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
