package com.duokan.reader.domain.store;

import com.duokan.reader.common.C0611i;
import com.duokan.reader.domain.payment.C1089s;
import com.google.gson.JsonObject;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.store.u */
public class C1195u extends C1089s {
    /* renamed from: a */
    public long f5686a;
    /* renamed from: b */
    public final String f5687b;
    /* renamed from: c */
    public final String f5688c;
    /* renamed from: d */
    public final String f5689d;
    /* renamed from: e */
    public int f5690e = 0;
    /* renamed from: f */
    public boolean f5691f = false;
    /* renamed from: g */
    private final String f5692g;
    /* renamed from: h */
    private final String f5693h;
    /* renamed from: i */
    private final String f5694i;
    /* renamed from: j */
    private final String f5695j;

    public C1195u(String str, C1089s c1089s, String str2, String str3) {
        this.f5687b = str;
        this.f5692g = c1089s.mo1502b();
        this.f5693h = c1089s.mo1501a();
        this.f5694i = c1089s.mo1503c();
        this.f5695j = c1089s.mo1504d();
        this.f5689d = str2;
        this.f5688c = str3;
    }

    public C1195u(long j, String str, String str2, String str3) {
        this.f5686a = j;
        this.f5687b = str;
        JSONObject jSONObject = new JSONObject(str2);
        this.f5692g = jSONObject.getString("paymentEnvelop");
        this.f5693h = jSONObject.getString("paymentId");
        this.f5694i = jSONObject.getString("paymentSenderSign");
        this.f5695j = jSONObject.getString("paymentMothodName");
        this.f5688c = C0611i.m2793b(jSONObject, "url");
        this.f5690e = jSONObject.optInt("verifyCount", 0);
        this.f5689d = str3;
    }

    /* renamed from: a */
    public String mo1501a() {
        return this.f5693h;
    }

    /* renamed from: b */
    public String mo1502b() {
        return this.f5692g;
    }

    /* renamed from: c */
    public String mo1503c() {
        return this.f5694i;
    }

    /* renamed from: d */
    public String mo1504d() {
        return this.f5695j;
    }

    /* renamed from: e */
    public String m8747e() {
        JsonObject jsonObject = new JsonObject();
        try {
            jsonObject.addProperty("paymentId", this.f5693h);
            jsonObject.addProperty("paymentEnvelop", this.f5692g);
            jsonObject.addProperty("paymentSenderSign", this.f5694i);
            jsonObject.addProperty("paymentMothodName", this.f5695j);
            jsonObject.addProperty("url", this.f5688c);
            jsonObject.addProperty("verifyCount", Integer.valueOf(this.f5690e));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
