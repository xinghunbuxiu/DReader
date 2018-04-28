package com.duokan.reader.domain.bookshelf;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bt implements Cloneable {
    /* renamed from: a */
    public int f2857a;
    /* renamed from: b */
    public String f2858b;
    /* renamed from: c */
    public String f2859c;
    /* renamed from: d */
    public long f2860d;
    /* renamed from: e */
    public long f2861e;
    /* renamed from: f */
    public int f2862f;
    /* renamed from: g */
    public boolean f2863g;
    /* renamed from: h */
    public int f2864h;
    /* renamed from: i */
    public long f2865i;

    public /* synthetic */ Object clone() {
        return m4068a();
    }

    public bt(int i, String str, String str2) {
        this.f2857a = i;
        this.f2858b = str;
        this.f2859c = str2;
        this.f2860d = 0;
        this.f2861e = 0;
        this.f2862f = 0;
        this.f2863g = false;
        this.f2864h = 0;
        this.f2865i = 0;
    }

    public bt(int i, JSONObject jSONObject) {
        this.f2857a = i;
        m4067a(jSONObject);
    }

    public bt(JSONObject jSONObject) {
        this.f2857a = jSONObject.optInt("book_source");
        m4067a(jSONObject);
    }

    /* renamed from: a */
    public bt m4068a() {
        try {
            return (bt) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /* renamed from: a */
    private void m4067a(JSONObject jSONObject) {
        this.f2858b = jSONObject.optString("book_id");
        this.f2859c = jSONObject.optString("group");
        this.f2860d = jSONObject.optLong("server_change_time");
        this.f2861e = jSONObject.optLong("client_change_time");
        this.f2862f = jSONObject.optInt("status");
        this.f2863g = jSONObject.optBoolean("is_local_dirty", false);
        this.f2864h = jSONObject.optInt("local_operation_type", 0);
        this.f2865i = jSONObject.optLong("local_operation_time");
    }

    /* renamed from: b */
    public JSONObject m4069b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("book_source", this.f2857a);
            jSONObject.put("book_id", this.f2858b);
            jSONObject.put("group", this.f2859c);
            jSONObject.put("server_change_time", this.f2860d);
            jSONObject.put("client_change_time", this.f2861e);
            jSONObject.put("status", this.f2862f);
            jSONObject.put("is_local_dirty", this.f2863g);
            jSONObject.put("local_operation_type", this.f2864h);
            jSONObject.put("local_operation_time", this.f2865i);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* renamed from: c */
    public boolean m4070c() {
        return this.f2862f == 1;
    }

    /* renamed from: a */
    public static ArrayList<bt> m4066a(int i, JSONArray jSONArray) {
        ArrayList<bt> arrayList = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                arrayList.add(new bt(i, jSONArray.getJSONObject(i2)));
            } catch (JSONException e) {
            }
        }
        return arrayList;
    }
}
