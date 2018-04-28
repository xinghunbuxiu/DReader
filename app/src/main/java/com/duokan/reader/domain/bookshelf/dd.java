package com.duokan.reader.domain.bookshelf;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dd implements Cloneable {
    /* renamed from: a */
    public int f3002a;
    /* renamed from: b */
    public String f3003b;
    /* renamed from: c */
    public long f3004c;
    /* renamed from: d */
    public boolean f3005d;
    /* renamed from: e */
    public boolean f3006e;
    /* renamed from: f */
    public int f3007f;
    /* renamed from: g */
    public long f3008g;

    public /* synthetic */ Object clone() {
        return m4305a();
    }

    public dd(int i, String str) {
        this.f3002a = i;
        this.f3003b = str;
        this.f3004c = 0;
        this.f3005d = false;
        this.f3006e = false;
        this.f3007f = 0;
        this.f3008g = 0;
    }

    public dd(JSONObject jSONObject) {
        this.f3002a = jSONObject.optInt("book_source");
        m4304a(jSONObject);
    }

    public dd(int i, JSONObject jSONObject) {
        this.f3002a = i;
        m4304a(jSONObject);
    }

    /* renamed from: a */
    private void m4304a(JSONObject jSONObject) {
        this.f3003b = jSONObject.optString("book_id");
        this.f3004c = jSONObject.optLong("client_read_time");
        this.f3005d = jSONObject.optBoolean("is_deleted", false);
        this.f3006e = jSONObject.optBoolean("is_local_dirty", this.f3006e);
        this.f3007f = jSONObject.optInt("local_operation_type", 0);
        this.f3008g = jSONObject.optLong("local_operation_time");
    }

    /* renamed from: a */
    public dd m4305a() {
        try {
            return (dd) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /* renamed from: b */
    public JSONObject m4306b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("book_source", this.f3002a);
            jSONObject.put("book_id", this.f3003b);
            jSONObject.put("client_read_time", this.f3004c);
            jSONObject.put("is_deleted", this.f3005d);
            jSONObject.put("is_local_dirty", this.f3006e);
            jSONObject.put("local_operation_type", this.f3007f);
            jSONObject.put("local_operation_time", this.f3008g);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static ArrayList<dd> m4303a(int i, JSONArray jSONArray) {
        ArrayList<dd> arrayList = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                arrayList.add(new dd(i, jSONArray.getJSONObject(i2)));
            } catch (JSONException e) {
            }
        }
        return arrayList;
    }
}
