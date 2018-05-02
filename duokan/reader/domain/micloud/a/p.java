package com.duokan.reader.domain.micloud.a;

import org.json.JSONException;
import org.json.JSONObject;

public class p {
    private JSONObject a;
    private long b = 10;

    public p(JSONObject jSONObject) {
        this.a = jSONObject;
        try {
            this.b = jSONObject.getLong("retryAfter");
        } catch (JSONException e) {
        }
    }

    public long a() {
        return this.b;
    }
}
