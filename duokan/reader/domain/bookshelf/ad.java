package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;

public class ad {
    public static final ad a = new ad();
    public final int b;
    public final int c;
    public final String d;
    public final long e;

    private ad() {
        this.b = 0;
        this.c = 0;
        this.d = "";
        this.e = 0;
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
        this.b = i;
        this.c = i2;
        this.d = str2;
        this.e = j;
    }

    public ad(int i, int i2, String str, long j) {
        this.b = i;
        this.c = i2;
        this.d = str;
        this.e = j;
    }

    public boolean a() {
        if (!b() && this.c >= 100) {
            return true;
        }
        return false;
    }

    public boolean b() {
        return this.c < 1 && TextUtils.isEmpty(this.d);
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("devid_ver", this.b);
        jSONObject.put("cert_ver", this.c);
        jSONObject.put("cert", this.d);
        jSONObject.put("expiry_time", this.e);
        return jSONObject;
    }
}
