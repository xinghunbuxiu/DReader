package com.duokan.reader.ui.general;

import com.duokan.reader.common.cache.C0445s;
import org.json.JSONException;
import org.json.JSONObject;

final class ch extends C0445s<cj, JSONObject> {
    ch() {
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return m10365a((cj) obj);
    }

    public /* synthetic */ Object serializeItemCorePropertiesToJson(Object obj) {
        return m10367b((cj) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return m10366a((cj) obj, (JSONObject) obj2);
    }

    /* renamed from: a */
    public String m10365a(cj cjVar) {
        return "";
    }

    /* renamed from: a */
    public JSONObject m10366a(cj cjVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("content", cjVar.f7033a);
        } catch (JSONException e) {
        }
        return jSONObject2;
    }

    /* renamed from: b */
    public JSONObject m10367b(cj cjVar) {
        return null;
    }
}
