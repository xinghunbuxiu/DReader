package com.duokan.reader.domain.micloud;

import org.json.JSONException;
import org.json.JSONObject;

public class bh {
    /* renamed from: a */
    private JSONObject f5234a;
    /* renamed from: b */
    private String f5235b;
    /* renamed from: c */
    private ak f5236c;

    public bh(JSONObject jSONObject) {
        this.f5234a = jSONObject;
        try {
            this.f5235b = this.f5234a.getString("upload_id");
            this.f5236c = new ak(this.f5234a.getJSONObject("kss"));
        } catch (JSONException e) {
        }
    }

    /* renamed from: a */
    public String m8144a() {
        return this.f5235b;
    }

    /* renamed from: b */
    public ak m8145b() {
        return this.f5236c;
    }

    /* renamed from: c */
    public JSONObject m8146c() {
        return this.f5234a;
    }
}
