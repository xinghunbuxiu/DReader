package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.cache.v;

import org.json.JSONObject;

public class de extends v {
    public /* synthetic */ Object deserializeInfoFromJson(JSONObject jSONObject) {
        return a(jSONObject);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return a(str, (JSONObject) obj);
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return a((dg) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return a((df) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return a((dg) obj, (JSONObject) obj2);
    }

    public JSONObject a(df dfVar) {
        return dfVar == null ? new JSONObject() : dfVar.a();
    }

    public df a(JSONObject jSONObject) {
        return new df(jSONObject);
    }

    public String a(dg dgVar) {
        return ae.a(dgVar.a, dgVar.b);
    }

    public JSONObject a(dg dgVar, JSONObject jSONObject) {
        if (dgVar == null) {
            return null;
        }
        return dgVar.b();
    }

    public dg a(String str, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        return new dg(jSONObject);
    }
}
