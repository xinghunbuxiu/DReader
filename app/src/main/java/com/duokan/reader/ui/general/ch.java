package com.duokan.reader.ui.general;

import com.duokan.reader.common.cache.s;

import org.json.JSONException;
import org.json.JSONObject;

final class ch extends s {
    ch() {
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return a((cj) obj);
    }

    public /* synthetic */ Object serializeItemCorePropertiesToJson(Object obj) {
        return b((cj) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return a((cj) obj, (JSONObject) obj2);
    }

    public String a(cj cjVar) {
        return "";
    }

    public JSONObject a(cj cjVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("content", cjVar.a);
        } catch (JSONException e) {
        }
        return jSONObject2;
    }

    public JSONObject b(cj cjVar) {
        return null;
    }
}
