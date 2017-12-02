package com.duokan.reader.domain.social.message;

import android.text.TextUtils;

import com.duokan.reader.domain.account.User;
import com.mipay.sdk.Mipay;

import org.json.JSONException;
import org.json.JSONObject;

public class k {
    public static final int[] a = new int[]{5, 10, 13, 17, 19, 18};
    public final String b;
    public final int c;
    public final String d;
    public final String e;
    public final long f;
    public final long g;
    public final l h;

    public k(String str, int i, String str2, String str3, long j, long j2, l lVar) {
        this.b = str;
        this.c = i;
        this.d = str2;
        this.e = str3;
        this.f = j;
        this.g = j2;
        this.h = lVar;
    }

    public User a() {
        return this.h.a();
    }

    public String b() {
        String b = this.h.b();
        if (TextUtils.isEmpty(b)) {
            return this.e;
        }
        return b;
    }

    public long c() {
        long c = this.h.c();
        if (c == 0) {
            return this.f;
        }
        return c;
    }

    public void a(JSONObject jSONObject) {
        try {
            this.h.b(jSONObject.getJSONObject("action_params"));
        } catch (JSONException e) {
        }
    }

    public boolean d() {
        for (int i : a) {
            if (this.c == i) {
                return true;
            }
        }
        return false;
    }

    public static k a(JSONObject jSONObject, m mVar) {
        l nVar;
        int i = jSONObject.getInt("message_type");
        if (!jSONObject.has("action_params") || TextUtils.isEmpty(jSONObject.getString("action_params"))) {
            nVar = new n();
        } else {
            nVar = mVar.a(i, jSONObject.getJSONObject("action_params"));
        }
        return new k(jSONObject.getString("message_id"), i, jSONObject.optString("title", ""), jSONObject.optString(Mipay.KEY_MESSAGE, ""), jSONObject.optLong("create_time"), jSONObject.optLong("start_time"), nVar);
    }
}
