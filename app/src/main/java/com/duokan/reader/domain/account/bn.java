package com.duokan.reader.domain.account;

import org.json.JSONException;
import org.json.JSONObject;

public class bn {
    /* renamed from: a */
    public String f2439a;
    /* renamed from: b */
    public String f2440b;
    /* renamed from: c */
    public String f2441c;
    /* renamed from: d */
    public String f2442d;

    /* renamed from: a */
    public static bn m3415a(JSONObject jSONObject) {
        bn bnVar = new bn();
        try {
            bnVar.f2439a = jSONObject.optString("visitorId");
            bnVar.f2440b = jSONObject.optString("visitorPassTokenMd5");
            bnVar.f2442d = jSONObject.optString("cVisitorId");
            bnVar.f2441c = jSONObject.optString("visitorPassToken");
        } catch (Throwable th) {
        }
        return bnVar;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visitorId", this.f2439a);
            jSONObject.put("cVisitorId", this.f2442d);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
