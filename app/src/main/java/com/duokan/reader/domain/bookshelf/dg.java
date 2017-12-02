package com.duokan.reader.domain.bookshelf;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class dg implements Cloneable {
    public int a;
    public String b;
    public long c;
    public boolean d;
    public boolean e;
    public int f;
    public long g;

    public /* synthetic */ Object clone() {
        return a();
    }

    public dg(int i, String str) {
        this.a = i;
        this.b = str;
        this.c = 0;
        this.d = false;
        this.e = false;
        this.f = 0;
        this.g = 0;
    }

    public dg(JSONObject jSONObject) {
        this.a = jSONObject.optInt("book_source");
        a(jSONObject);
    }

    public dg(int i, JSONObject jSONObject) {
        this.a = i;
        a(jSONObject);
    }

    private void a(JSONObject jSONObject) {
        this.b = jSONObject.optString("book_id");
        this.c = jSONObject.optLong("client_read_time");
        this.d = jSONObject.optBoolean("is_deleted", false);
        this.e = jSONObject.optBoolean("is_local_dirty", this.e);
        this.f = jSONObject.optInt("local_operation_type", 0);
        this.g = jSONObject.optLong("local_operation_time");
    }

    public dg a() {
        try {
            return (dg) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("book_source", this.a);
            jSONObject.put("book_id", this.b);
            jSONObject.put("client_read_time", this.c);
            jSONObject.put("is_deleted", this.d);
            jSONObject.put("is_local_dirty", this.e);
            jSONObject.put("local_operation_type", this.f);
            jSONObject.put("local_operation_time", this.g);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static ArrayList a(int i, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                arrayList.add(new dg(i, jSONArray.getJSONObject(i2)));
            } catch (JSONException e) {
            }
        }
        return arrayList;
    }
}
