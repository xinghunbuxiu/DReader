package com.duokan.reader.ui.general;

import com.duokan.reader.common.cache.p;

import org.json.JSONObject;

final class ci implements p {
    ci() {
    }

    public /* synthetic */ Object deserializeCorePropertiesFromJson(String str, Object obj) {
        return b(str, (JSONObject) obj);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return a(str, (JSONObject) obj);
    }

    public cj a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        cj cjVar = new cj();
        cjVar.a = jSONObject.optString("content");
        return cjVar;
    }

    public cj b(String str, JSONObject jSONObject) {
        return null;
    }
}
