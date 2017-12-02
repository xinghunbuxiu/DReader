package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.cache.v;

import org.json.JSONObject;

public class bs extends v {
    public /* synthetic */ Object deserializeInfoFromJson(JSONObject jSONObject) {
        return a(jSONObject);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return a(str, (JSONObject) obj);
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return a((bu) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return a((bt) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return a((bu) obj, (JSONObject) obj2);
    }

    public JSONObject a(bt btVar) {
        return btVar == null ? new JSONObject() : btVar.b();
    }

    public bt a(JSONObject jSONObject) {
        return new bt(jSONObject);
    }

    public String a(bu buVar) {
        return ae.a(buVar.a, buVar.b);
    }

    public JSONObject a(bu buVar, JSONObject jSONObject) {
        if (buVar == null) {
            return null;
        }
        return buVar.b();
    }

    public bu a(String str, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        return new bu(jSONObject);
    }
}
