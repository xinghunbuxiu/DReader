package com.duokan.reader.domain.micloud;

import android.content.ContentValues;

import com.duokan.reader.common.cache.aa;
import com.duokan.reader.common.cache.v;

import org.json.JSONException;
import org.json.JSONObject;

class ax extends v {
    public static aa[] a = new aa[]{new aa("work_item_start_time", "LONG")};

    private ax() {
    }

    public /* synthetic */ Object deserializeInfoFromJson(JSONObject jSONObject) {
        return a(jSONObject);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return a(str, (JSONObject) obj);
    }

    public /* synthetic */ ContentValues getPropertyValues(Object obj) {
        return b((z) obj);
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return a((z) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return a((UserNamespaceTaskCacheInfo) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return a((z) obj, (JSONObject) obj2);
    }

    public JSONObject a(UserNamespaceTaskCacheInfo userNamespaceTaskCacheInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("account_uuid", userNamespaceTaskCacheInfo.mAccountUuid == null ? "" : userNamespaceTaskCacheInfo.mAccountUuid);
            jSONObject.put("namespace", userNamespaceTaskCacheInfo.mNamespace);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public UserNamespaceTaskCacheInfo a(JSONObject jSONObject) {
        UserNamespaceTaskCacheInfo userNamespaceTaskCacheInfo = new UserNamespaceTaskCacheInfo();
        userNamespaceTaskCacheInfo.mAccountUuid = jSONObject.optString("account_uuid", "");
        userNamespaceTaskCacheInfo.mNamespace = jSONObject.optString("namespace");
        return userNamespaceTaskCacheInfo;
    }

    public String a(z zVar) {
        return zVar.w();
    }

    public JSONObject a(z zVar, JSONObject jSONObject) {
        return zVar.a();
    }

    public z a(String str, JSONObject jSONObject) {
        try {
            return new z(jSONObject);
        } catch (JSONException e) {
            return null;
        }
    }

    public aa[] getPropertyDefinitions() {
        return a;
    }

    public ContentValues b(z zVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("work_item_start_time", Long.valueOf(zVar.s()));
        return contentValues;
    }
}
