package com.duokan.reader.domain.bookshelf;

import org.json.JSONException;
import org.json.JSONObject;

public class df {
    public String a;
    public long b;

    public df(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.a = "";
            return;
        }
        this.a = jSONObject.optString("account_uuid");
        this.b = jSONObject.optLong("latest_sync_down_time");
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("account_uuid", this.a);
            jSONObject.put("latest_sync_down_time", this.b);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
