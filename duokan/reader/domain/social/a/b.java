package com.duokan.reader.domain.social.a;

import org.json.JSONException;
import org.json.JSONObject;

public class b {
    public int a;
    public int b;
    public int c;
    public int d;

    public b() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
    }

    public b(JSONObject jSONObject) {
        this.a = jSONObject.optInt("comment_count");
        this.b = jSONObject.optInt("note_count");
        this.c = jSONObject.optInt("book_count");
        this.d = jSONObject.optInt("useful_count");
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("comment_count", this.a);
            jSONObject.put("note_count", this.b);
            jSONObject.put("book_count", this.c);
            jSONObject.put("useful_count", this.d);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
