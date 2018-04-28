package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.reader.common.C0611i;
import org.json.JSONObject;

public class ab {
    /* renamed from: a */
    public String f2703a;
    /* renamed from: b */
    public String f2704b;
    /* renamed from: c */
    public String f2705c;
    /* renamed from: d */
    public String f2706d;
    /* renamed from: e */
    public String f2707e;
    /* renamed from: f */
    public String f2708f;
    /* renamed from: g */
    public boolean f2709g;
    /* renamed from: h */
    public int f2710h;
    /* renamed from: i */
    public String f2711i;
    /* renamed from: j */
    public String[] f2712j;
    /* renamed from: k */
    public String f2713k;
    /* renamed from: l */
    public String f2714l;
    /* renamed from: m */
    public String f2715m;
    /* renamed from: n */
    public long f2716n;

    public ab() {
        this.f2703a = "";
        this.f2704b = "";
        this.f2705c = "";
        this.f2706d = "";
        this.f2707e = "";
        this.f2708f = "";
        this.f2709g = false;
        this.f2710h = -1;
        this.f2711i = "";
        this.f2712j = new String[0];
        this.f2713k = "";
        this.f2714l = "";
        this.f2715m = "";
        this.f2716n = 0;
    }

    public ab(String str) {
        int i = -1;
        this.f2703a = "";
        this.f2704b = "";
        this.f2705c = "";
        this.f2706d = "";
        this.f2707e = "";
        this.f2708f = "";
        this.f2709g = false;
        this.f2710h = -1;
        this.f2711i = "";
        this.f2712j = new String[0];
        this.f2713k = "";
        this.f2714l = "";
        this.f2715m = "";
        this.f2716n = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f2703a = jSONObject.optString("publisher");
                this.f2704b = jSONObject.optString("publishing_date");
                this.f2705c = jSONObject.optString("isbn");
                this.f2706d = jSONObject.optString("intro");
                this.f2707e = jSONObject.optString("online_uri");
                this.f2709g = jSONObject.optBoolean("has_ads", false);
                String str2 = "ad_duration";
                if (this.f2709g) {
                    i = 5;
                }
                this.f2710h = jSONObject.optInt(str2, i);
                this.f2708f = jSONObject.optString("web_uri");
                this.f2711i = jSONObject.optString("tag", "");
                Object optString = jSONObject.optString("districts");
                this.f2712j = TextUtils.isEmpty(optString) ? new String[0] : optString.split(",");
                this.f2713k = C0611i.m2793b(jSONObject, "category");
                this.f2714l = C0611i.m2793b(jSONObject, "category_id");
                this.f2715m = C0611i.m2793b(jSONObject, "publisher_id");
                this.f2716n = jSONObject.optLong("last_open_time");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ab(String str, String str2, String str3, String str4, boolean z, int i, String str5, String str6, String[] strArr, String str7, String str8, String str9) {
        this.f2703a = "";
        this.f2704b = "";
        this.f2705c = "";
        this.f2706d = "";
        this.f2707e = "";
        this.f2708f = "";
        this.f2709g = false;
        this.f2710h = -1;
        this.f2711i = "";
        this.f2712j = new String[0];
        this.f2713k = "";
        this.f2714l = "";
        this.f2715m = "";
        this.f2716n = 0;
        this.f2703a = str;
        this.f2704b = str2;
        this.f2706d = str4;
        this.f2705c = str3;
        this.f2709g = z;
        this.f2710h = i;
        this.f2708f = str5;
        this.f2711i = str6;
        if (strArr == null) {
            strArr = new String[0];
        }
        this.f2712j = strArr;
        this.f2715m = str7;
        this.f2713k = str8;
        this.f2714l = str9;
    }

    /* renamed from: a */
    public boolean m3772a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.f2712j.length < 1) {
            return true;
        }
        for (String equalsIgnoreCase : this.f2712j) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("publisher", this.f2703a);
            jSONObject.put("publishing_date", this.f2704b);
            jSONObject.put("isbn", this.f2705c);
            jSONObject.put("intro", this.f2706d);
            jSONObject.put("online_uri", this.f2707e);
            jSONObject.put("has_ads", this.f2709g);
            jSONObject.put("ad_time", this.f2710h);
            jSONObject.put("web_uri", this.f2708f);
            jSONObject.put("tag", this.f2711i);
            jSONObject.put("districts", TextUtils.join(",", this.f2712j));
            jSONObject.put("publisher_id", this.f2715m);
            jSONObject.put("category", this.f2713k);
            jSONObject.put("category_id", this.f2714l);
            jSONObject.put("last_open_time", this.f2716n);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
