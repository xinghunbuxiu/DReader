package com.duokan.reader.domain.micloud;

import android.content.ContentValues;

import com.duokan.reader.DkPublic;
import com.duokan.reader.common.cache.aa;
import com.duokan.reader.common.cache.v;

import org.json.JSONException;
import org.json.JSONObject;

class at extends v {
    public static aa[] a = new aa[]{new aa("parent_cloud_path", "TEXT")};

    private at() {
    }

    public /* synthetic */ Object deserializeInfoFromJson(JSONObject jSONObject) {
        return a(jSONObject);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return a(str, (JSONObject) obj);
    }

    public /* synthetic */ ContentValues getPropertyValues(Object obj) {
        return b((bi) obj);
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return a((bi) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return a((au) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return a((bi) obj, (JSONObject) obj2);
    }

    public JSONObject a(au auVar) {
        JSONObject jSONObject = new JSONObject();
        if (auVar != null) {
            try {
                jSONObject.put("account_uuid", auVar.a);
                jSONObject.put("namespace", auVar.b);
                if (auVar.c != null) {
                    jSONObject.put("quota", auVar.c.a());
                }
            } catch (JSONException e) {
            }
        }
        return jSONObject;
    }

    public au a(JSONObject jSONObject) {
        au auVar = new au();
        if (!DkPublic.isEmpty(jSONObject)) {
            auVar.a = jSONObject.optString("account_uuid");
            auVar.b = jSONObject.optString("namespace");
            JSONObject optJSONObject = jSONObject.optJSONObject("quota");
            if (optJSONObject != null) {
                auVar.c = new bj(optJSONObject);
            } else {
                auVar.c = new bj();
            }
        }
        return auVar;
    }

    public String a(bi biVar) {
        return biVar.l();
    }

    public JSONObject a(bi biVar, JSONObject jSONObject) {
        return biVar.a();
    }

    public bi a(String str, JSONObject jSONObject) {
        try {
            return new bi(jSONObject);
        } catch (JSONException e) {
            return null;
        }
    }

    public aa[] getPropertyDefinitions() {
        return a;
    }

    public ContentValues b(bi biVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("parent_cloud_path", biVar.m());
        return contentValues;
    }
}
