package com.duokan.reader.domain.micloud;

import android.content.ContentValues;

import com.duokan.reader.common.cache.aa;
import com.duokan.reader.common.cache.v;

import org.json.JSONException;
import org.json.JSONObject;

class an extends v {
    public static aa[] a = new aa[]{new aa("work_item_type", "INTEGER"), new aa("work_item_cloud_id", "TEXT"), new aa("work_item_status", "INTEGER"), new aa("work_item_start_time", "LONG"), new aa("create_file_task_local_file_path", "TEXT"), new aa("create_file_task_cloud_file_parent_path", "TEXT"), new aa("create_file_task_cloud_parent_id", "TEXT")};

    private an() {
    }

    public /* synthetic */ Object deserializeInfoFromJson(JSONObject jSONObject) {
        return a(jSONObject);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return a(str, (JSONObject) obj);
    }

    public /* synthetic */ ContentValues getPropertyValues(Object obj) {
        return b((i) obj);
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return a((i) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return a((UserNamespaceTaskCacheInfo) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return a((i) obj, (JSONObject) obj2);
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

    public String a(i iVar) {
        return iVar.b();
    }

    public JSONObject a(i iVar, JSONObject jSONObject) {
        return iVar.a();
    }

    public i a(String str, JSONObject jSONObject) {
        try {
            return new i(jSONObject);
        } catch (Exception e) {
            return null;
        }
    }

    public aa[] getPropertyDefinitions() {
        return a;
    }

    public ContentValues b(i iVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("work_item_type", Integer.valueOf(iVar.c()));
        contentValues.put("work_item_cloud_id", iVar.e());
        contentValues.put("work_item_status", Integer.valueOf(iVar.f()));
        contentValues.put("work_item_start_time", Long.valueOf(iVar.s()));
        contentValues.put("create_file_task_local_file_path", iVar.w());
        contentValues.put("create_file_task_cloud_file_parent_path", iVar.x());
        contentValues.put("create_file_task_cloud_parent_id", iVar.z());
        return contentValues;
    }
}
