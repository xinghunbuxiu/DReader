package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.DkPublic;
import com.duokan.reader.common.cache.v;
import com.duokan.reader.common.i;
import com.duokan.reader.domain.cloud.push.MessageListCache.DkCloudPushMessagesInfo;

import org.json.JSONException;
import org.json.JSONObject;

class y extends v {
    private y() {
    }

    public /* synthetic */ Object deserializeInfoFromJson(JSONObject jSONObject) {
        return a(jSONObject);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return a(str, (String) obj);
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return a((DkCloudPushMessage) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return a((DkCloudPushMessagesInfo) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return a((DkCloudPushMessage) obj, (String) obj2);
    }

    public String a(DkCloudPushMessage dkCloudPushMessage) {
        return dkCloudPushMessage.getCloudId();
    }

    public JSONObject a(DkCloudPushMessagesInfo dkCloudPushMessagesInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag_new_store", true);
            jSONObject.put("creatCallTask", dkCloudPushMessagesInfo.mInit);
            jSONObject.put("account_uuid", dkCloudPushMessagesInfo.mAccountUuid);
            jSONObject.put("account_name", dkCloudPushMessagesInfo.mAccountName);
            jSONObject.put("unread_broadcast_messageIds", i.a(dkCloudPushMessagesInfo.mUnreadBroadcastMessageIds));
            jSONObject.put("unread_account_messageIds", i.a(dkCloudPushMessagesInfo.mUnreadAccountMessageIds));
            jSONObject.put("unreport_messageIds", i.a(dkCloudPushMessagesInfo.mUnReportMessageIds));
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public DkCloudPushMessagesInfo a(JSONObject jSONObject) {
        if (jSONObject.has("tag_new_store")) {
            DkCloudPushMessagesInfo dkCloudPushMessagesInfo = new DkCloudPushMessagesInfo();
            dkCloudPushMessagesInfo.mFromLegacyStore = false;
            dkCloudPushMessagesInfo.mInit = jSONObject.optBoolean("creatCallTask", false);
            dkCloudPushMessagesInfo.mAccountUuid = jSONObject.optString("account_uuid", "");
            dkCloudPushMessagesInfo.mAccountName = jSONObject.optString("account_name", "");
            dkCloudPushMessagesInfo.mUnreadBroadcastMessageIds = i.c(jSONObject, "unread_broadcast_messageIds");
            dkCloudPushMessagesInfo.mUnreadAccountMessageIds = i.c(jSONObject, "unread_account_messageIds");
            dkCloudPushMessagesInfo.mUnReportMessageIds = i.c(jSONObject, "unreport_messageIds");
            return dkCloudPushMessagesInfo;
        }
        dkCloudPushMessagesInfo = (DkCloudPushMessagesInfo) DkPublic.deserializeFromJson(jSONObject, new DkCloudPushMessagesInfo(), DkCloudPushMessagesInfo.class);
        dkCloudPushMessagesInfo.mFromLegacyStore = true;
        return dkCloudPushMessagesInfo;
    }

    public String a(DkCloudPushMessage dkCloudPushMessage, String str) {
        return DkPublic.serializeToJsonText(dkCloudPushMessage);
    }

    public DkCloudPushMessage a(String str, String str2) {
        return (DkCloudPushMessage) DkPublic.deserializeFromJsonText(str2, DkCloudPushMessage.class);
    }
}
