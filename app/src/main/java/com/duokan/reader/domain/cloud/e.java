package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.duokan.DkStoreBookSourceType;

import org.json.JSONException;
import org.json.JSONObject;

public class e {
    public String a;
    public String b;
    public String[] c;
    public String[] d;
    public String e;
    public DkStoreBookSourceType f;
    public long g;
    public long h;
    public String i;
    private boolean j = false;

    public e(JSONObject jSONObject) {
        this.a = jSONObject.optString("uuid");
        this.b = jSONObject.optString("name");
        this.c = i.c(jSONObject, "authors");
        this.d = i.c(jSONObject, "editors");
        this.e = jSONObject.optString("order_uuid");
        this.f = (DkStoreBookSourceType) Enum.valueOf(DkStoreBookSourceType.class, jSONObject.optString("type"));
        this.g = jSONObject.optLong("purchased_time");
        this.h = jSONObject.optLong("update_time");
        this.i = jSONObject.optString("cover");
        this.j = jSONObject.optBoolean("hidden");
    }

    public e(DkCloudPurchasedBook dkCloudPurchasedBook) {
        this.a = dkCloudPurchasedBook.getBookUuid();
        this.b = dkCloudPurchasedBook.getTitle();
        this.c = dkCloudPurchasedBook.getAuthors();
        this.d = dkCloudPurchasedBook.getEditors();
        this.e = dkCloudPurchasedBook.getBookUuid();
        this.f = dkCloudPurchasedBook.getBookSourceType();
        this.g = dkCloudPurchasedBook.getPurchaseTimeInSeconds();
        this.h = dkCloudPurchasedBook.getUpdateTimeInSeconds();
        this.i = dkCloudPurchasedBook.getCoverUri();
        this.j = dkCloudPurchasedBook.isHidden();
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.a);
            jSONObject.put("name", this.b);
            jSONObject.put("authors", i.a(this.c));
            jSONObject.put("editors", i.a(this.d));
            jSONObject.put("order_uuid", this.e);
            jSONObject.put("type", this.f.name());
            jSONObject.put("purchased_time", this.g);
            jSONObject.put("update_time", this.h);
            jSONObject.put("cover", this.i);
            jSONObject.put("hidden", this.j);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
