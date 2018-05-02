package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.C0611i;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.cloud.f */
public class C0846f {
    /* renamed from: a */
    public String f3967a;
    /* renamed from: b */
    public String f3968b;
    /* renamed from: c */
    public String[] f3969c;
    /* renamed from: d */
    public String[] f3970d;
    /* renamed from: e */
    public long f3971e;
    /* renamed from: f */
    public String f3972f;
    /* renamed from: g */
    public boolean f3973g = false;

    public C0846f(JSONObject jSONObject) {
        this.f3967a = jSONObject.optString("uuid");
        this.f3968b = jSONObject.optString("name");
        this.f3969c = C0611i.m2794c(jSONObject, "authors");
        this.f3970d = C0611i.m2794c(jSONObject, "editors");
        this.f3971e = jSONObject.optLong("purchased_time");
        this.f3972f = jSONObject.optString("cover");
        this.f3973g = jSONObject.optBoolean("hidden", false);
    }

    public C0846f(DkCloudPurchasedFiction dkCloudPurchasedFiction) {
        this.f3967a = dkCloudPurchasedFiction.getBookUuid();
        this.f3968b = dkCloudPurchasedFiction.getTitle();
        this.f3969c = dkCloudPurchasedFiction.getAuthors();
        this.f3970d = dkCloudPurchasedFiction.getEditors();
        this.f3971e = dkCloudPurchasedFiction.getPurchaseTimeInSeconds();
        this.f3972f = dkCloudPurchasedFiction.getCoverUri();
        this.f3973g = dkCloudPurchasedFiction.isHidden();
    }

    /* renamed from: a */
    public JSONObject m5530a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.f3967a);
            jSONObject.put("name", this.f3968b);
            jSONObject.put("authors", C0611i.m2789a(this.f3969c));
            jSONObject.put("editors", C0611i.m2789a(this.f3970d));
            jSONObject.put("purchased_time", this.f3971e);
            jSONObject.put("cover", this.f3972f);
            jSONObject.put("hidden", this.f3973g);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
