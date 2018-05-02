package com.duokan.reader.domain.payment;

import java.net.URLDecoder;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.payment.d */
public class C1090d extends C1089s {
    /* renamed from: a */
    private final String f5336a;
    /* renamed from: b */
    private final String f5337b;
    /* renamed from: c */
    private final String f5338c;
    /* renamed from: d */
    private final String f5339d;

    public C1090d(String str, String str2) {
        JSONObject jSONObject = new JSONObject(str);
        this.f5336a = URLDecoder.decode(jSONObject.optString("payment_envelope"));
        this.f5337b = URLDecoder.decode(jSONObject.optString("payment_id"));
        this.f5338c = URLDecoder.decode(jSONObject.optString("payment_sender_sign"));
        this.f5339d = str2;
    }

    /* renamed from: a */
    public static C1090d m8364a(String str, String str2) {
        try {
            return new C1090d(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public String mo1501a() {
        return this.f5337b;
    }

    /* renamed from: b */
    public String mo1502b() {
        return this.f5336a;
    }

    /* renamed from: c */
    public String mo1503c() {
        return this.f5338c;
    }

    /* renamed from: d */
    public String mo1504d() {
        return this.f5339d;
    }
}
