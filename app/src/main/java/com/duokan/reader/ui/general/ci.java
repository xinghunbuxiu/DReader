package com.duokan.reader.ui.general;

import com.duokan.reader.common.cache.C0446p;
import org.json.JSONObject;

final class ci implements C0446p<cj, JSONObject> {
    ci() {
    }

    public /* synthetic */ Object deserializeCorePropertiesFromJson(String str, Object obj) {
        return m10369b(str, (JSONObject) obj);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return m10368a(str, (JSONObject) obj);
    }

    /* renamed from: a */
    public cj m10368a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        cj cjVar = new cj();
        cjVar.f7033a = jSONObject.optString("content");
        return cjVar;
    }

    /* renamed from: b */
    public cj m10369b(String str, JSONObject jSONObject) {
        return null;
    }
}
