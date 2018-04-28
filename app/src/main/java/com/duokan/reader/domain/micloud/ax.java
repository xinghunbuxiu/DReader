package com.duokan.reader.domain.micloud;

import android.content.ContentValues;
import com.duokan.reader.common.cache.C0448v;
import com.duokan.reader.common.cache.aa;
import org.json.JSONException;
import org.json.JSONObject;

class ax extends C0448v<UserNamespaceTaskCacheInfo, C1084z, JSONObject> {
    /* renamed from: a */
    public static aa[] f5205a = new aa[]{new aa("work_item_start_time", "LONG")};

    private ax() {
    }

    public /* synthetic */ Object deserializeInfoFromJson(JSONObject jSONObject) {
        return m8093a(jSONObject);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return m8094a(str, (JSONObject) obj);
    }

    public /* synthetic */ ContentValues getPropertyValues(Object obj) {
        return m8098b((C1084z) obj);
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return m8095a((C1084z) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return m8096a((UserNamespaceTaskCacheInfo) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return m8097a((C1084z) obj, (JSONObject) obj2);
    }

    /* renamed from: a */
    public JSONObject m8096a(UserNamespaceTaskCacheInfo userNamespaceTaskCacheInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("account_uuid", userNamespaceTaskCacheInfo.mAccountUuid == null ? "" : userNamespaceTaskCacheInfo.mAccountUuid);
            jSONObject.put("namespace", userNamespaceTaskCacheInfo.mNamespace);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public UserNamespaceTaskCacheInfo m8093a(JSONObject jSONObject) {
        UserNamespaceTaskCacheInfo userNamespaceTaskCacheInfo = new UserNamespaceTaskCacheInfo();
        userNamespaceTaskCacheInfo.mAccountUuid = jSONObject.optString("account_uuid", "");
        userNamespaceTaskCacheInfo.mNamespace = jSONObject.optString("namespace");
        return userNamespaceTaskCacheInfo;
    }

    /* renamed from: a */
    public String m8095a(C1084z c1084z) {
        return c1084z.m8326w();
    }

    /* renamed from: a */
    public JSONObject m8097a(C1084z c1084z, JSONObject jSONObject) {
        return c1084z.m2279a();
    }

    /* renamed from: a */
    public C1084z m8094a(String str, JSONObject jSONObject) {
        try {
            return new C1084z(jSONObject);
        } catch (JSONException e) {
            return null;
        }
    }

    public aa[] getPropertyDefinitions() {
        return f5205a;
    }

    /* renamed from: b */
    public ContentValues m8098b(C1084z c1084z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("work_item_start_time", Long.valueOf(c1084z.m2304s()));
        return contentValues;
    }
}
