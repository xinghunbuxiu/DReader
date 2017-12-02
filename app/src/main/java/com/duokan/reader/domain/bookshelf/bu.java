package com.duokan.reader.domain.bookshelf;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class bu implements Cloneable {
    public int a;
    public String b;
    public String c;
    public long d;
    public long e;
    public int f;
    public boolean g;
    public int h;
    public long i;

    public /* synthetic */ Object clone() {
        return a();
    }

    public bu(int i, String str, String str2) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = false;
        this.h = 0;
        this.i = 0;
    }

    public bu(int i, JSONObject jSONObject) {
        this.a = i;
        a(jSONObject);
    }

    public bu(JSONObject jSONObject) {
        this.a = jSONObject.optInt("book_source");
        a(jSONObject);
    }

    public bu a() {
        try {
            return (bu) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    private void a(JSONObject jSONObject) {
        this.b = jSONObject.optString("book_id");
        this.c = jSONObject.optString("group");
        this.d = jSONObject.optLong("server_change_time");
        this.e = jSONObject.optLong("client_change_time");
        this.f = jSONObject.optInt("status");
        this.g = jSONObject.optBoolean("is_local_dirty", false);
        this.h = jSONObject.optInt("local_operation_type", 0);
        this.i = jSONObject.optLong("local_operation_time");
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("book_source", this.a);
            jSONObject.put("book_id", this.b);
            jSONObject.put("group", this.c);
            jSONObject.put("server_change_time", this.d);
            jSONObject.put("client_change_time", this.e);
            jSONObject.put("status", this.f);
            jSONObject.put("is_local_dirty", this.g);
            jSONObject.put("local_operation_type", this.h);
            jSONObject.put("local_operation_time", this.i);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public boolean c() {
        return this.f == 1;
    }

    public static ArrayList a(int i, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                arrayList.add(new bu(i, jSONArray.getJSONObject(i2)));
            } catch (JSONException e) {
            }
        }
        return arrayList;
    }
}
