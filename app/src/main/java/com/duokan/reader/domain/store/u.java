package com.duokan.reader.domain.store;

import com.duokan.reader.domain.payment.s;
import com.google.gson.JsonObject;

import org.json.JSONObject;

public class u extends s {
    public long a;
    public final String b;
    public final String c;
    public final String d;
    public int e = 0;
    public boolean f = false;
    private final String g;
    private final String h;
    private final String i;
    private final String j;

    public u(String str, s sVar, String str2, String str3) {
        this.b = str;
        this.g = sVar.b();
        this.h = sVar.a();
        this.i = sVar.c();
        this.j = sVar.d();
        this.d = str2;
        this.c = str3;
    }

    public u(long j, String str, String str2, String str3) {
        this.a = j;
        this.b = str;
        JSONObject jSONObject = new JSONObject(str2);
        this.g = jSONObject.getString("paymentEnvelop");
        this.h = jSONObject.getString("paymentId");
        this.i = jSONObject.getString("paymentSenderSign");
        this.j = jSONObject.getString("paymentMothodName");
        this.c = i.b(jSONObject, "url");
        this.e = jSONObject.optInt("verifyCount", 0);
        this.d = str3;
    }

    public String a() {
        return this.h;
    }

    public String b() {
        return this.g;
    }

    public String c() {
        return this.i;
    }

    public String d() {
        return this.j;
    }

    public String e() {
        JsonObject jsonObject = new JsonObject();
        try {
            jsonObject.addProperty("paymentId", this.h);
            jsonObject.addProperty("paymentEnvelop", this.g);
            jsonObject.addProperty("paymentSenderSign", this.i);
            jsonObject.addProperty("paymentMothodName", this.j);
            jsonObject.addProperty("url", this.c);
            jsonObject.addProperty("verifyCount", Integer.valueOf(this.e));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
