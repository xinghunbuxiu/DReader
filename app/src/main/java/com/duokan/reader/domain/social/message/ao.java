package com.duokan.reader.domain.social.message;

import com.duokan.reader.DkPublic;
import com.duokan.reader.common.cache.C0448v;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class ao extends C0448v<DkMessagesInfo, C1151k, JSONObject> {
    /* renamed from: a */
    private HashMap<String, JSONObject> f5527a;

    private ao() {
        this.f5527a = new HashMap();
    }

    public /* synthetic */ Object deserializeInfoFromJson(JSONObject jSONObject) {
        return m8522a(jSONObject);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return m8523a(str, (JSONObject) obj);
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return m8524a((C1151k) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return m8525a((DkMessagesInfo) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return m8526a((C1151k) obj, (JSONObject) obj2);
    }

    /* renamed from: a */
    public void m8527a(HashMap<String, JSONObject> hashMap) {
        this.f5527a = hashMap;
    }

    /* renamed from: a */
    public JSONObject m8525a(DkMessagesInfo dkMessagesInfo) {
        return DkPublic.serializeToJson(dkMessagesInfo);
    }

    /* renamed from: a */
    public DkMessagesInfo m8522a(JSONObject jSONObject) {
        return (DkMessagesInfo) DkPublic.deserializeFromJson(jSONObject, new DkMessagesInfo(), DkMessagesInfo.class);
    }

    /* renamed from: a */
    public String m8524a(C1151k c1151k) {
        return c1151k.f5555b;
    }

    /* renamed from: a */
    public JSONObject m8526a(C1151k c1151k, JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (this.f5527a == null || !this.f5527a.containsKey(c1151k.f5555b)) {
            jSONObject2 = jSONObject;
        } else {
            jSONObject2 = (JSONObject) this.f5527a.get(c1151k.f5555b);
        }
        if (jSONObject2 != null) {
            c1151k.m8579a(jSONObject2);
        }
        return jSONObject2;
    }

    /* renamed from: a */
    public C1151k m8523a(String str, JSONObject jSONObject) {
        C1151k c1151k = null;
        try {
            c1151k = aa.m8503a(jSONObject);
        } catch (JSONException e) {
        }
        return c1151k;
    }
}
