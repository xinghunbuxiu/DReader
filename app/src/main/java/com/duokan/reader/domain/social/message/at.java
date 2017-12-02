package com.duokan.reader.domain.social.message;

import com.duokan.reader.DkPublic;
import com.duokan.reader.common.cache.v;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

class at extends v {
    private HashMap a;

    private at() {
        this.a = new HashMap();
    }

    public /* synthetic */ Object deserializeInfoFromJson(JSONObject jSONObject) {
        return a(jSONObject);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return a(str, (JSONObject) obj);
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return a((k) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return a((DkMessagesInfo) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return a((k) obj, (JSONObject) obj2);
    }

    public void a(HashMap hashMap) {
        this.a = hashMap;
    }

    public JSONObject a(DkMessagesInfo dkMessagesInfo) {
        return DkPublic.serializeToJson(dkMessagesInfo);
    }

    public DkMessagesInfo a(JSONObject jSONObject) {
        return (DkMessagesInfo) DkPublic.deserializeFromJson(jSONObject, new DkMessagesInfo(), DkMessagesInfo.class);
    }

    public String a(k kVar) {
        return kVar.b;
    }

    public JSONObject a(k kVar, JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (this.a == null || !this.a.containsKey(kVar.b)) {
            jSONObject2 = jSONObject;
        } else {
            jSONObject2 = (JSONObject) this.a.get(kVar.b);
        }
        if (jSONObject2 != null) {
            kVar.a(jSONObject2);
        }
        return jSONObject2;
    }

    public k a(String str, JSONObject jSONObject) {
        k kVar = null;
        try {
            kVar = ac.a(jSONObject);
        } catch (JSONException e) {
        }
        return kVar;
    }
}
