package com.duokan.reader.domain.micloud;

import android.content.ContentValues;
import com.duokan.reader.common.cache.C0448v;
import com.duokan.reader.common.cache.aa;
import org.json.JSONException;
import org.json.JSONObject;

class an extends C0448v<UserNamespaceTaskCacheInfo, C1068i, JSONObject> {
    /* renamed from: a */
    public static aa[] f5193a = new aa[]{new aa("work_item_type", "INTEGER"), new aa("work_item_cloud_id", "TEXT"), new aa("work_item_status", "INTEGER"), new aa("work_item_start_time", "LONG"), new aa("create_file_task_local_file_path", "TEXT"), new aa("create_file_task_cloud_file_parent_path", "TEXT"), new aa("create_file_task_cloud_parent_id", "TEXT")};

    private an() {
    }

    public /* synthetic */ Object deserializeInfoFromJson(JSONObject jSONObject) {
        return m8065a(jSONObject);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return m8066a(str, (JSONObject) obj);
    }

    public /* synthetic */ ContentValues getPropertyValues(Object obj) {
        return m8070b((C1068i) obj);
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return m8067a((C1068i) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return m8068a((UserNamespaceTaskCacheInfo) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return m8069a((C1068i) obj, (JSONObject) obj2);
    }

    /* renamed from: a */
    public JSONObject m8068a(UserNamespaceTaskCacheInfo userNamespaceTaskCacheInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("account_uuid", userNamespaceTaskCacheInfo.mAccountUuid == null ? "" : userNamespaceTaskCacheInfo.mAccountUuid);
            jSONObject.put("namespace", userNamespaceTaskCacheInfo.mNamespace);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public UserNamespaceTaskCacheInfo m8065a(JSONObject jSONObject) {
        UserNamespaceTaskCacheInfo userNamespaceTaskCacheInfo = new UserNamespaceTaskCacheInfo();
        userNamespaceTaskCacheInfo.mAccountUuid = jSONObject.optString("account_uuid", "");
        userNamespaceTaskCacheInfo.mNamespace = jSONObject.optString("namespace");
        return userNamespaceTaskCacheInfo;
    }

    /* renamed from: a */
    public String m8067a(C1068i c1068i) {
        return c1068i.m2285b();
    }

    /* renamed from: a */
    public JSONObject m8069a(C1068i c1068i, JSONObject jSONObject) {
        return c1068i.m2279a();
    }

    /* renamed from: a */
    public C1068i m8066a(String str, JSONObject jSONObject) {
        try {
            return new C1068i(jSONObject);
        } catch (Exception e) {
            return null;
        }
    }

    public aa[] getPropertyDefinitions() {
        return f5193a;
    }

    /* renamed from: b */
    public ContentValues m8070b(C1068i c1068i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("work_item_type", Integer.valueOf(c1068i.m2288c()));
        contentValues.put("work_item_cloud_id", c1068i.m2290e());
        contentValues.put("work_item_status", Integer.valueOf(c1068i.m2291f()));
        contentValues.put("work_item_start_time", Long.valueOf(c1068i.m2304s()));
        contentValues.put("create_file_task_local_file_path", c1068i.m8228w());
        contentValues.put("create_file_task_cloud_file_parent_path", c1068i.m8229x());
        contentValues.put("create_file_task_cloud_parent_id", c1068i.m8231z());
        return contentValues;
    }
}
