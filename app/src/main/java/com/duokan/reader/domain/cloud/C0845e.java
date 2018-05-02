package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.C0611i;
import com.duokan.reader.common.webservices.duokan.DkStoreBookSourceType;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.cloud.e */
public class C0845e {
    /* renamed from: a */
    public String f3901a;
    /* renamed from: b */
    public String f3902b;
    /* renamed from: c */
    public String[] f3903c;
    /* renamed from: d */
    public String[] f3904d;
    /* renamed from: e */
    public String f3905e;
    /* renamed from: f */
    public DkStoreBookSourceType f3906f;
    /* renamed from: g */
    public long f3907g;
    /* renamed from: h */
    public long f3908h;
    /* renamed from: i */
    public String f3909i;
    /* renamed from: j */
    private boolean f3910j = false;

    public C0845e(JSONObject jSONObject) {
        this.f3901a = jSONObject.optString("uuid");
        this.f3902b = jSONObject.optString("name");
        this.f3903c = C0611i.m2794c(jSONObject, "authors");
        this.f3904d = C0611i.m2794c(jSONObject, "editors");
        this.f3905e = jSONObject.optString("order_uuid");
        this.f3906f = (DkStoreBookSourceType) Enum.valueOf(DkStoreBookSourceType.class, jSONObject.optString("type"));
        this.f3907g = jSONObject.optLong("purchased_time");
        this.f3908h = jSONObject.optLong("update_time");
        this.f3909i = jSONObject.optString("cover");
        this.f3910j = jSONObject.optBoolean("hidden");
    }

    public C0845e(DkCloudPurchasedBook dkCloudPurchasedBook) {
        this.f3901a = dkCloudPurchasedBook.getBookUuid();
        this.f3902b = dkCloudPurchasedBook.getTitle();
        this.f3903c = dkCloudPurchasedBook.getAuthors();
        this.f3904d = dkCloudPurchasedBook.getEditors();
        this.f3905e = dkCloudPurchasedBook.getBookUuid();
        this.f3906f = dkCloudPurchasedBook.getBookSourceType();
        this.f3907g = dkCloudPurchasedBook.getPurchaseTimeInSeconds();
        this.f3908h = dkCloudPurchasedBook.getUpdateTimeInSeconds();
        this.f3909i = dkCloudPurchasedBook.getCoverUri();
        this.f3910j = dkCloudPurchasedBook.isHidden();
    }

    /* renamed from: a */
    public JSONObject m5475a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.f3901a);
            jSONObject.put("name", this.f3902b);
            jSONObject.put("authors", C0611i.m2789a(this.f3903c));
            jSONObject.put("editors", C0611i.m2789a(this.f3904d));
            jSONObject.put("order_uuid", this.f3905e);
            jSONObject.put("type", this.f3906f.name());
            jSONObject.put("purchased_time", this.f3907g);
            jSONObject.put("update_time", this.f3908h);
            jSONObject.put("cover", this.f3909i);
            jSONObject.put("hidden", this.f3910j);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
