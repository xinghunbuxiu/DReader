package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.core.sys.af;
import com.duokan.reader.domain.micloud.bi;
import com.umeng.analytics.pro.C2295j;
import org.json.JSONObject;

public class ac {
    /* renamed from: a */
    public String f2717a;
    /* renamed from: b */
    public String f2718b;
    /* renamed from: c */
    public String f2719c;
    /* renamed from: d */
    public String f2720d;
    /* renamed from: e */
    public int f2721e;

    public ac() {
        this.f2717a = "";
        this.f2718b = "";
        this.f2719c = "";
        this.f2720d = "";
        this.f2721e = 16;
    }

    public ac(String str, String str2, String str3, String str4) {
        this.f2717a = str;
        this.f2718b = str2;
        this.f2719c = str3;
        this.f2720d = str4;
        this.f2721e = 16;
    }

    public ac(ac acVar) {
        this.f2717a = acVar.f2717a;
        this.f2718b = acVar.f2718b;
        this.f2719c = acVar.f2719c;
        this.f2720d = acVar.f2720d;
        this.f2721e = acVar.f2721e;
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
                    str4 = "kuaipan:///" + new is(new bi(jSONObject)).m4686f() + "?info=" + jSONObject.toString();
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
        this.f2717a = str3;
        this.f2718b = str5;
        this.f2719c = str6;
        this.f2720d = str2;
        this.f2721e = i;
    }

    /* renamed from: a */
    public boolean m3776a(int i) {
        return (this.f2721e & i) == i;
    }

    /* renamed from: b */
    public boolean m3777b(int i) {
        return (this.f2721e & i) != 0;
    }

    /* renamed from: c */
    public void m3778c(int i) {
        this.f2721e &= i ^ -1;
    }

    /* renamed from: d */
    public void m3779d(int i) {
        this.f2721e |= i;
    }

    /* renamed from: a */
    public void m3774a(boolean z, af<Boolean> afVar) {
        m3778c(3584);
        m3779d(m3773b(z, afVar));
    }

    /* renamed from: a */
    public boolean m3775a() {
        return TextUtils.isEmpty(this.f2717a);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("source_uri", this.f2718b);
            jSONObject.put("source_revision", this.f2719c);
            jSONObject.put("source_md5", this.f2720d);
            jSONObject.put("target_uri", this.f2717a);
            jSONObject.put("flags", this.f2721e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* renamed from: b */
    private static final int m3773b(boolean z, af<Boolean> afVar) {
        int i = z ? C2295j.f14327g : 0;
        if (!afVar.m861b()) {
            return i;
        }
        return i | (afVar.m862b(Boolean.valueOf(true)) ? 1024 : 2048);
    }
}
