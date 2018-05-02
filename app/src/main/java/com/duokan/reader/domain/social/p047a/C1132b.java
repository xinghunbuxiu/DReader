package com.duokan.reader.domain.social.p047a;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.social.a.b */
public class C1132b {
    /* renamed from: a */
    public int f5452a;
    /* renamed from: b */
    public int f5453b;
    /* renamed from: c */
    public int f5454c;
    /* renamed from: d */
    public int f5455d;

    public C1132b() {
        this.f5452a = 0;
        this.f5453b = 0;
        this.f5454c = 0;
        this.f5455d = 0;
    }

    public C1132b(JSONObject jSONObject) {
        this.f5452a = jSONObject.optInt("comment_count");
        this.f5453b = jSONObject.optInt("note_count");
        this.f5454c = jSONObject.optInt("book_count");
        this.f5455d = jSONObject.optInt("useful_count");
    }

    /* renamed from: a */
    public JSONObject m8454a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("comment_count", this.f5452a);
            jSONObject.put("note_count", this.f5453b);
            jSONObject.put("book_count", this.f5454c);
            jSONObject.put("useful_count", this.f5455d);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
