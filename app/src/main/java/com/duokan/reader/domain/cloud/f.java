package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.i;

import org.json.JSONException;
import org.json.JSONObject;

public class f {
    public String a;
    public String b;
    public String[] c;
    public String[] d;
    public long e;
    public String f;
    public boolean g = false;

    public f(JSONObject jSONObject) {
        this.a = jSONObject.optString("uuid");
        this.b = jSONObject.optString("name");
        this.c = i.c(jSONObject, "authors");
        this.d = i.c(jSONObject, "editors");
        this.e = jSONObject.optLong("purchased_time");
        this.f = jSONObject.optString("cover");
        this.g = jSONObject.optBoolean("hidden", false);
    }

    public f(DkCloudPurchasedFiction dkCloudPurchasedFiction) {
        this.a = dkCloudPurchasedFiction.getBookUuid();
        this.b = dkCloudPurchasedFiction.getTitle();
        this.c = dkCloudPurchasedFiction.getAuthors();
        this.d = dkCloudPurchasedFiction.getEditors();
        this.e = dkCloudPurchasedFiction.getPurchaseTimeInSeconds();
        this.f = dkCloudPurchasedFiction.getCoverUri();
        this.g = dkCloudPurchasedFiction.isHidden();
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uuid", this.a);
            jSONObject.put("name", this.b);
            jSONObject.put("authors", i.a(this.c));
            jSONObject.put("editors", i.a(this.d));
            jSONObject.put("purchased_time", this.e);
            jSONObject.put("cover", this.f);
            jSONObject.put("hidden", this.g);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
