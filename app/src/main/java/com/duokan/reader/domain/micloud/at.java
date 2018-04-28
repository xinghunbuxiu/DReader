package com.duokan.reader.domain.micloud;

import android.content.ContentValues;
import com.duokan.reader.DkPublic;
import com.duokan.reader.common.cache.C0448v;
import com.duokan.reader.common.cache.aa;
import org.json.JSONException;
import org.json.JSONObject;

class at extends C0448v<au, bi, JSONObject> {
    /* renamed from: a */
    public static aa[] f5201a = new aa[]{new aa("parent_cloud_path", "TEXT")};

    private at() {
    }

    public /* synthetic */ Object deserializeInfoFromJson(JSONObject jSONObject) {
        return m8086a(jSONObject);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return m8087a(str, (JSONObject) obj);
    }

    public /* synthetic */ ContentValues getPropertyValues(Object obj) {
        return m8091b((bi) obj);
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return m8088a((bi) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return m8089a((au) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return m8090a((bi) obj, (JSONObject) obj2);
    }

    /* renamed from: a */
    public JSONObject m8089a(au auVar) {
        JSONObject jSONObject = new JSONObject();
        if (auVar != null) {
            try {
                jSONObject.put("account_uuid", auVar.f5202a);
                jSONObject.put("namespace", auVar.f5203b);
                if (auVar.f5204c != null) {
                    jSONObject.put("quota", auVar.f5204c.m8167a());
                }
            } catch (JSONException e) {
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    public au m8086a(JSONObject jSONObject) {
        au auVar = new au();
        if (!DkPublic.isEmpty(jSONObject)) {
            auVar.f5202a = jSONObject.optString("account_uuid");
            auVar.f5203b = jSONObject.optString("namespace");
            JSONObject optJSONObject = jSONObject.optJSONObject("quota");
            if (optJSONObject != null) {
                auVar.f5204c = new bj(optJSONObject);
            } else {
                auVar.f5204c = new bj();
            }
        }
        return auVar;
    }

    /* renamed from: a */
    public String m8088a(bi biVar) {
        return biVar.m8162l();
    }

    /* renamed from: a */
    public JSONObject m8090a(bi biVar, JSONObject jSONObject) {
        return biVar.m8150a();
    }

    /* renamed from: a */
    public bi m8087a(String str, JSONObject jSONObject) {
        try {
            return new bi(jSONObject);
        } catch (JSONException e) {
            return null;
        }
    }

    public aa[] getPropertyDefinitions() {
        return f5201a;
    }

    /* renamed from: b */
    public ContentValues m8091b(bi biVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("parent_cloud_path", biVar.m8163m());
        return contentValues;
    }
}
