package com.duokan.reader.domain.bookshelf;

import org.json.JSONException;
import org.json.JSONObject;

public class ju {
    public long a = 0;
    public int b = 0;
    public String c = "";

    public ju(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.a = jSONObject.optLong("readMillis", jSONObject.optLong("local_reading_millis", 0));
            this.b = jSONObject.optInt("readChars", 0);
            this.c = jSONObject.optString("traceId", "");
        } catch (JSONException e) {
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("readMillis", this.a);
            jSONObject.put("readChars", this.b);
            jSONObject.put("traceId", this.c);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String toString() {
        return a().toString();
    }
}
