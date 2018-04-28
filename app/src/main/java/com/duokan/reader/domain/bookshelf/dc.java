package com.duokan.reader.domain.bookshelf;

import org.json.JSONException;
import org.json.JSONObject;

public class dc {
    /* renamed from: a */
    public String f3000a;
    /* renamed from: b */
    public long f3001b;

    public dc(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.f3000a = "";
            return;
        }
        this.f3000a = jSONObject.optString("account_uuid");
        this.f3001b = jSONObject.optLong("latest_sync_down_time");
    }

    /* renamed from: a */
    public JSONObject m4302a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("account_uuid", this.f3000a);
            jSONObject.put("latest_sync_down_time", this.f3001b);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
