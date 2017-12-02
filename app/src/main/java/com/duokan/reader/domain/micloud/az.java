package com.duokan.reader.domain.micloud;

import org.json.JSONException;
import org.json.JSONObject;

public class az {
    private JSONObject a;
    private aj b;

    public az(JSONObject jSONObject) {
        this.a = jSONObject;
        try {
            this.b = new aj(this.a.getJSONObject("kss"));
        } catch (JSONException e) {
        }
    }

    public aj a() {
        return this.b;
    }

    public JSONObject b() {
        return this.a;
    }
}
