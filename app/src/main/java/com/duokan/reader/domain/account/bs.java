package com.duokan.reader.domain.account;

import org.json.JSONException;
import org.json.JSONObject;

public class bs {
    public String a;
    public String b;
    public String c;
    public String d;
    public long e;
    public String f;
    public String g;

    public static bs a(JSONObject jSONObject) {
        bs bsVar = new bs();
        try {
            bsVar.a = jSONObject.optString("visitorId");
            bsVar.b = jSONObject.optString("visitorPassTokenMd5");
            bsVar.g = jSONObject.optString("cVisitorId");
            bsVar.f = jSONObject.optString("visitorPassToken");
            bsVar.c = jSONObject.getJSONObject("visitorInfo").optString("extId");
            bsVar.d = jSONObject.getJSONObject("visitorInfo").optString("deviceId");
            bsVar.e = jSONObject.getJSONObject("visitorInfo").optLong("createTime");
        } catch (JSONException e) {
        }
        return bsVar;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visitorId", this.a);
            jSONObject.put("cVisitorId", this.g);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("extId", this.c);
            jSONObject2.put("createTime", this.e);
            jSONObject.put("visitorInfo", jSONObject2);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
