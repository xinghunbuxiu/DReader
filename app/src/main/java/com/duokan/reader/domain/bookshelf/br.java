package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.cache.C0448v;
import org.json.JSONObject;

public class br extends C0448v<bs, bt, JSONObject> {
    public /* synthetic */ Object deserializeInfoFromJson(JSONObject jSONObject) {
        return m4055a(jSONObject);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return m4056a(str, (JSONObject) obj);
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return m4057a((bt) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return m4058a((bs) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return m4059a((bt) obj, (JSONObject) obj2);
    }

    /* renamed from: a */
    public JSONObject m4058a(bs bsVar) {
        return bsVar == null ? new JSONObject() : bsVar.m4064b();
    }

    /* renamed from: a */
    public bs m4055a(JSONObject jSONObject) {
        return new bs(jSONObject);
    }

    /* renamed from: a */
    public String m4057a(bt btVar) {
        return ae.m3783a(btVar.f2857a, btVar.f2858b);
    }

    /* renamed from: a */
    public JSONObject m4059a(bt btVar, JSONObject jSONObject) {
        if (btVar == null) {
            return null;
        }
        return btVar.m4069b();
    }

    /* renamed from: a */
    public bt m4056a(String str, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        return new bt(jSONObject);
    }
}
