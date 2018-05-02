package com.duokan.reader.domain.micloud.p046a;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.micloud.a.p */
public class C1059p {
    /* renamed from: a */
    private JSONObject f5181a;
    /* renamed from: b */
    private long f5182b = 10;

    public C1059p(JSONObject jSONObject) {
        this.f5181a = jSONObject;
        try {
            this.f5182b = jSONObject.getLong("retryAfter");
        } catch (JSONException e) {
        }
    }

    /* renamed from: a */
    public long m8037a() {
        return this.f5182b;
    }
}
