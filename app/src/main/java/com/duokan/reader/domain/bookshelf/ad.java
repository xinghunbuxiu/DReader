package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;

public class ad {
    /* renamed from: a */
    public static final ad f2722a = new ad();
    /* renamed from: b */
    public final int f2723b;
    /* renamed from: c */
    public final int f2724c;
    /* renamed from: d */
    public final String f2725d;
    /* renamed from: e */
    public final long f2726e;

    private ad() {
        this.f2723b = 0;
        this.f2724c = 0;
        this.f2725d = "";
        this.f2726e = 0;
    }

    public ad(String str) {
        int i;
        long j = 0;
        int i2 = 0;
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            i = 0;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                i = jSONObject.optInt("devid_ver", jSONObject.optInt(ClientCookie.VERSION_ATTR, 1));
                try {
                    i2 = jSONObject.optInt("cert_ver", 1);
                    str2 = jSONObject.getString("cert");
                    j = jSONObject.optLong("expiry_time", jSONObject.optLong("cert_limited_time", 0));
                } catch (Throwable th) {
                }
            } catch (Throwable th2) {
                i = 0;
            }
        }
        this.f2723b = i;
        this.f2724c = i2;
        this.f2725d = str2;
        this.f2726e = j;
    }

    public ad(int i, int i2, String str, long j) {
        this.f2723b = i;
        this.f2724c = i2;
        this.f2725d = str;
        this.f2726e = j;
    }

    /* renamed from: a */
    public boolean m3780a() {
        if (!m3781b() && this.f2724c >= 100) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public boolean m3781b() {
        return this.f2724c < 1 && TextUtils.isEmpty(this.f2725d);
    }

    /* renamed from: c */
    public JSONObject m3782c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("devid_ver", this.f2723b);
        jSONObject.put("cert_ver", this.f2724c);
        jSONObject.put("cert", this.f2725d);
        jSONObject.put("expiry_time", this.f2726e);
        return jSONObject;
    }
}
