package com.duokan.reader.domain.bookshelf;

import org.json.JSONException;
import org.json.JSONObject;

public class kg {
    /* renamed from: a */
    public long f3453a = 0;
    /* renamed from: b */
    public int f3454b = 0;
    /* renamed from: c */
    public String f3455c = "";

    public kg(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f3453a = jSONObject.optLong("readMillis", jSONObject.optLong("local_reading_millis", 0));
            this.f3454b = jSONObject.optInt("readChars", 0);
            this.f3455c = jSONObject.optString("traceId", "");
        } catch (JSONException e) {
        }
    }

    /* renamed from: a */
    public JSONObject m4821a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("readMillis", this.f3453a);
            jSONObject.put("readChars", this.f3454b);
            jSONObject.put("traceId", this.f3455c);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String toString() {
        return m4821a().toString();
    }
}
