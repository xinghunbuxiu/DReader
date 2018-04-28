package com.duokan.reader.domain.micloud;

import org.json.JSONException;
import org.json.JSONObject;

public class bj implements Cloneable {
    /* renamed from: a */
    public long f5251a = 0;
    /* renamed from: b */
    public long f5252b = 0;
    /* renamed from: c */
    public long f5253c = 0;

    public /* synthetic */ Object clone() {
        return m8168b();
    }

    public bj(JSONObject jSONObject) {
        this.f5251a = jSONObject.optLong("total");
        this.f5252b = jSONObject.optLong("available");
        this.f5253c = jSONObject.optLong("ns_used");
    }

    /* renamed from: a */
    public JSONObject m8167a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("total", this.f5251a);
            jSONObject.put("available", this.f5252b);
            jSONObject.put("ns_used", this.f5253c);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* renamed from: b */
    public bj m8168b() {
        try {
            return (bj) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
