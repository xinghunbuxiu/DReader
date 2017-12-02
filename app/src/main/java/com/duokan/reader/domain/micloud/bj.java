package com.duokan.reader.domain.micloud;

import org.json.JSONException;
import org.json.JSONObject;

public class bj implements Cloneable {
    public long a = 0;
    public long b = 0;
    public long c = 0;

    public /* synthetic */ Object clone() {
        return b();
    }

    public bj(JSONObject jSONObject) {
        this.a = jSONObject.optLong("total");
        this.b = jSONObject.optLong("available");
        this.c = jSONObject.optLong("ns_used");
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("total", this.a);
            jSONObject.put("available", this.b);
            jSONObject.put("ns_used", this.c);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public bj b() {
        try {
            return (bj) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
