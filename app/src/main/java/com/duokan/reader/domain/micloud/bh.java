package com.duokan.reader.domain.micloud;

import org.json.JSONException;
import org.json.JSONObject;

public class bh {
    private JSONObject a;
    private String b;
    private ak c;

    public bh(JSONObject jSONObject) {
        this.a = jSONObject;
        try {
            this.b = this.a.getString("upload_id");
            this.c = new ak(this.a.getJSONObject("kss"));
        } catch (JSONException e) {
        }
    }

    public String a() {
        return this.b;
    }

    public ak b() {
        return this.c;
    }

    public JSONObject c() {
        return this.a;
    }
}
