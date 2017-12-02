package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import org.json.JSONObject;

public class ab {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public int h;
    public String i;
    public String[] j;
    public String k;
    public String l;
    public String m;
    public long n;

    public ab() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = false;
        this.h = -1;
        this.i = "";
        this.j = new String[0];
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = 0;
    }

    public ab(String str) {
        int i = -1;
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = false;
        this.h = -1;
        this.i = "";
        this.j = new String[0];
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.a = jSONObject.optString("publisher");
                this.b = jSONObject.optString("publishing_date");
                this.c = jSONObject.optString("isbn");
                this.d = jSONObject.optString("intro");
                this.e = jSONObject.optString("online_uri");
                this.g = jSONObject.optBoolean("has_ads", false);
                String str2 = "ad_duration";
                if (this.g) {
                    i = 5;
                }
                this.h = jSONObject.optInt(str2, i);
                this.f = jSONObject.optString("web_uri");
                this.i = jSONObject.optString("tag", "");
                Object optString = jSONObject.optString("districts");
                this.j = TextUtils.isEmpty(optString) ? new String[0] : optString.split(",");
                this.k = i.b(jSONObject, "category");
                this.l = i.b(jSONObject, "category_id");
                this.m = i.b(jSONObject, "publisher_id");
                this.n = jSONObject.optLong("last_open_time");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ab(String str, String str2, String str3, String str4, boolean z, int i, String str5, String str6, String[] strArr, String str7, String str8, String str9) {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = false;
        this.h = -1;
        this.i = "";
        this.j = new String[0];
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = 0;
        this.a = str;
        this.b = str2;
        this.d = str4;
        this.c = str3;
        this.g = z;
        this.h = i;
        this.f = str5;
        this.i = str6;
        if (strArr == null) {
            strArr = new String[0];
        }
        this.j = strArr;
        this.m = str7;
        this.k = str8;
        this.l = str9;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.j.length < 1) {
            return true;
        }
        for (String equalsIgnoreCase : this.j) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("publisher", this.a);
            jSONObject.put("publishing_date", this.b);
            jSONObject.put("isbn", this.c);
            jSONObject.put("intro", this.d);
            jSONObject.put("online_uri", this.e);
            jSONObject.put("has_ads", this.g);
            jSONObject.put("ad_time", this.h);
            jSONObject.put("web_uri", this.f);
            jSONObject.put("tag", this.i);
            jSONObject.put("districts", TextUtils.join(",", this.j));
            jSONObject.put("publisher_id", this.m);
            jSONObject.put("category", this.k);
            jSONObject.put("category_id", this.l);
            jSONObject.put("last_open_time", this.n);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
