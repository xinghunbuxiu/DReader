package com.duokan.reader.domain.payment;

import org.json.JSONObject;

import java.net.URLDecoder;

public class d extends s {
    private final String a;
    private final String b;
    private final String c;
    private final String d;

    public d(String str, String str2) {
        JSONObject jSONObject = new JSONObject(str);
        this.a = URLDecoder.decode(jSONObject.optString("payment_envelope"));
        this.b = URLDecoder.decode(jSONObject.optString("payment_id"));
        this.c = URLDecoder.decode(jSONObject.optString("payment_sender_sign"));
        this.d = str2;
    }

    public static d a(String str, String str2) {
        try {
            return new d(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }
}
