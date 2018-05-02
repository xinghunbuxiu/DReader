package com.duokan.reader.domain.social.message;

import android.text.TextUtils;
import com.duokan.reader.domain.account.User;
import com.mipay.sdk.Mipay;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.social.message.k */
public class C1151k {
    /* renamed from: a */
    public static final int[] f5554a = new int[]{5, 10, 13, 17, 19, 18};
    /* renamed from: b */
    public final String f5555b;
    /* renamed from: c */
    public final int f5556c;
    /* renamed from: d */
    public final String f5557d;
    /* renamed from: e */
    public final String f5558e;
    /* renamed from: f */
    public final long f5559f;
    /* renamed from: g */
    public final long f5560g;
    /* renamed from: h */
    public final C1138l f5561h;

    public C1151k(String str, int i, String str2, String str3, long j, long j2, C1138l c1138l) {
        this.f5555b = str;
        this.f5556c = i;
        this.f5557d = str2;
        this.f5558e = str3;
        this.f5559f = j;
        this.f5560g = j2;
        this.f5561h = c1138l;
    }

    /* renamed from: a */
    public User m8578a() {
        return this.f5561h.mo1515a();
    }

    /* renamed from: b */
    public String m8580b() {
        String b = this.f5561h.mo1516b();
        if (TextUtils.isEmpty(b)) {
            return this.f5558e;
        }
        return b;
    }

    /* renamed from: c */
    public long m8581c() {
        long c = this.f5561h.mo1518c();
        if (c == 0) {
            return this.f5559f;
        }
        return c;
    }

    /* renamed from: a */
    public void m8579a(JSONObject jSONObject) {
        try {
            this.f5561h.mo1517b(jSONObject.getJSONObject("action_params"));
        } catch (JSONException e) {
        }
    }

    /* renamed from: d */
    public boolean m8582d() {
        for (int i : f5554a) {
            if (this.f5556c == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static C1151k m8577a(JSONObject jSONObject, C1146m c1146m) {
        C1138l c1152n;
        int i = jSONObject.getInt("message_type");
        if (!jSONObject.has("action_params") || TextUtils.isEmpty(jSONObject.getString("action_params"))) {
            c1152n = new C1152n();
        } else {
            c1152n = c1146m.mo1520a(i, jSONObject.getJSONObject("action_params"));
        }
        return new C1151k(jSONObject.getString("message_id"), i, jSONObject.optString("title", ""), jSONObject.optString(Mipay.KEY_MESSAGE, ""), jSONObject.optLong("create_time"), jSONObject.optLong("start_time"), c1152n);
    }
}
