package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.cache.C0448v;
import org.json.JSONObject;

public class db extends C0448v<dc, dd, JSONObject> {
    public /* synthetic */ Object deserializeInfoFromJson(JSONObject jSONObject) {
        return m4297a(jSONObject);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return m4298a(str, (JSONObject) obj);
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return m4299a((dd) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return m4300a((dc) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return m4301a((dd) obj, (JSONObject) obj2);
    }

    /* renamed from: a */
    public JSONObject m4300a(dc dcVar) {
        return dcVar == null ? new JSONObject() : dcVar.m4302a();
    }

    /* renamed from: a */
    public dc m4297a(JSONObject jSONObject) {
        return new dc(jSONObject);
    }

    /* renamed from: a */
    public String m4299a(dd ddVar) {
        return ae.m3783a(ddVar.f3002a, ddVar.f3003b);
    }

    /* renamed from: a */
    public JSONObject m4301a(dd ddVar, JSONObject jSONObject) {
        if (ddVar == null) {
            return null;
        }
        return ddVar.m4306b();
    }

    /* renamed from: a */
    public dd m4298a(String str, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        return new dd(jSONObject);
    }
}
