package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.core.sys.af;
import com.duokan.reader.domain.micloud.bi;
import com.umeng.analytics.pro.j;

import org.json.JSONObject;

public class ac {
    public String a;
    public String b;
    public String c;
    public String d;
    public int e;

    public ac() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = 16;
    }

    public ac(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = 16;
    }

    public ac(ac acVar) {
        this.a = acVar.a;
        this.b = acVar.b;
        this.c = acVar.c;
        this.d = acVar.d;
        this.e = acVar.e;
    }

    public ac(String str) {
        String str2;
        int i;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (TextUtils.isEmpty(str)) {
            str2 = str6;
            str6 = str5;
            str5 = str4;
            i = 1024;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                str3 = jSONObject.optString("target_uri");
                str4 = jSONObject.optString("source_uri");
                str5 = jSONObject.optString("source_revision");
                str6 = jSONObject.optString("source_md5");
                int optInt = jSONObject.optInt("flags", 1024);
                jSONObject = jSONObject.optJSONObject("source_cloud_private_book");
                if (jSONObject != null) {
                    str4 = "kuaipan:///" + new iy(new bi(jSONObject)).f() + "?info=" + jSONObject.toString();
                }
                int i2 = optInt;
                str2 = str6;
                str6 = str5;
                str5 = str4;
                i = i2;
            } catch (Exception e) {
                str2 = str6;
                str6 = str5;
                str5 = str4;
                i = 1024;
                e.printStackTrace();
            }
        }
        this.a = str3;
        this.b = str5;
        this.c = str6;
        this.d = str2;
        this.e = i;
    }

    public boolean a(int i) {
        return (this.e & i) == i;
    }

    public boolean b(int i) {
        return (this.e & i) != 0;
    }

    public void c(int i) {
        this.e &= i ^ -1;
    }

    public void d(int i) {
        this.e |= i;
    }

    public void a(boolean z, af afVar) {
        c(3584);
        d(b(z, afVar));
    }

    public boolean a() {
        return TextUtils.isEmpty(this.a);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("source_uri", this.b);
            jSONObject.put("source_revision", this.c);
            jSONObject.put("source_md5", this.d);
            jSONObject.put("target_uri", this.a);
            jSONObject.put("flags", this.e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private static final int b(boolean z, af afVar) {
        int i = z ? j.g : 0;
        if (!afVar.b()) {
            return i;
        }
        return i | (afVar.b(Boolean.valueOf(true)) ? 1024 : 2048);
    }
}
