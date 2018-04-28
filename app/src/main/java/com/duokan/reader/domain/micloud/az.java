package com.duokan.reader.domain.micloud;

import org.json.JSONException;
import org.json.JSONObject;

public class az {
    /* renamed from: a */
    private JSONObject f5209a;
    /* renamed from: b */
    private aj f5210b;

    public az(JSONObject jSONObject) {
        this.f5209a = jSONObject;
        try {
            this.f5210b = new aj(this.f5209a.getJSONObject("kss"));
        } catch (JSONException e) {
        }
    }

    /* renamed from: a */
    public aj m8103a() {
        return this.f5210b;
    }

    /* renamed from: b */
    public JSONObject m8104b() {
        return this.f5209a;
    }
}
