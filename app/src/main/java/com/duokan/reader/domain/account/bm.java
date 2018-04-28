package com.duokan.reader.domain.account;

import org.json.JSONException;
import org.json.JSONObject;

public class bm {
    /* renamed from: a */
    public String f2430a;
    /* renamed from: b */
    public String f2431b;
    /* renamed from: c */
    public String f2432c;
    /* renamed from: d */
    public long f2433d;
    /* renamed from: e */
    public String f2434e;
    /* renamed from: f */
    public String f2435f;
    /* renamed from: g */
    public String f2436g;
    /* renamed from: h */
    public String f2437h;
    /* renamed from: i */
    public String f2438i;

    /* renamed from: a */
    public static bm m3414a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            jSONObject2 = jSONObject;
        }
        bm bmVar = new bm();
        bmVar.f2430a = jSONObject.optString("openid");
        bmVar.f2431b = jSONObject.optString("access_token");
        bmVar.f2432c = jSONObject.optString("unionid");
        bmVar.f2433d = jSONObject.optLong("expires_in");
        bmVar.f2434e = jSONObject.optString("scope");
        bmVar.f2435f = jSONObject.optString("refresh_token");
        bmVar.f2436g = jSONObject2.optString("nickname");
        bmVar.f2437h = jSONObject2.optString("avatarUrl");
        bmVar.f2438i = jSONObject2.optString("unionIdSign");
        return bmVar;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("openid", this.f2430a);
            jSONObject.put("unionid", this.f2432c);
            jSONObject.put("expires_in", this.f2433d);
            jSONObject.put("scope", this.f2434e);
            jSONObject.put("nickname", this.f2436g);
            jSONObject.put("avatarUrl", this.f2437h);
            jSONObject.put("unionIdSign", this.f2438i);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
