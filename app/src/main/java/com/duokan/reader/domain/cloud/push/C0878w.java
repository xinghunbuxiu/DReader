package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.DkPublic;
import com.duokan.reader.common.C0611i;
import com.duokan.reader.common.cache.C0448v;
import com.duokan.reader.domain.cloud.push.MessageListCache.DkCloudPushMessagesInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.cloud.push.w */
class C0878w extends C0448v<DkCloudPushMessagesInfo, DkCloudPushMessage, String> {
    private C0878w() {
    }

    public /* synthetic */ Object deserializeInfoFromJson(JSONObject jSONObject) {
        return m5735a(jSONObject);
    }

    public /* synthetic */ Object deserializeItemFromJson(String str, Object obj) {
        return m5734a(str, (String) obj);
    }

    public /* synthetic */ String getUniqueId(Object obj) {
        return m5736a((DkCloudPushMessage) obj);
    }

    public /* synthetic */ JSONObject serializeInfoToJson(Object obj) {
        return m5738a((DkCloudPushMessagesInfo) obj);
    }

    public /* synthetic */ Object serializeItemToJson(Object obj, Object obj2) {
        return m5737a((DkCloudPushMessage) obj, (String) obj2);
    }

    /* renamed from: a */
    public String m5736a(DkCloudPushMessage dkCloudPushMessage) {
        return dkCloudPushMessage.getCloudId();
    }

    /* renamed from: a */
    public JSONObject m5738a(DkCloudPushMessagesInfo dkCloudPushMessagesInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag_new_store", true);
            jSONObject.put("init", dkCloudPushMessagesInfo.mInit);
            jSONObject.put("account_uuid", dkCloudPushMessagesInfo.mAccountUuid);
            jSONObject.put("account_name", dkCloudPushMessagesInfo.mAccountName);
            jSONObject.put("unread_broadcast_messageIds", C0611i.m2789a(dkCloudPushMessagesInfo.mUnreadBroadcastMessageIds));
            jSONObject.put("unread_account_messageIds", C0611i.m2789a(dkCloudPushMessagesInfo.mUnreadAccountMessageIds));
            jSONObject.put("unreport_messageIds", C0611i.m2789a(dkCloudPushMessagesInfo.mUnReportMessageIds));
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    public DkCloudPushMessagesInfo m5735a(JSONObject jSONObject) {
        if (jSONObject.has("tag_new_store")) {
            DkCloudPushMessagesInfo dkCloudPushMessagesInfo = new DkCloudPushMessagesInfo();
            dkCloudPushMessagesInfo.mFromLegacyStore = false;
            dkCloudPushMessagesInfo.mInit = jSONObject.optBoolean("init", false);
            dkCloudPushMessagesInfo.mAccountUuid = jSONObject.optString("account_uuid", "");
            dkCloudPushMessagesInfo.mAccountName = jSONObject.optString("account_name", "");
            dkCloudPushMessagesInfo.mUnreadBroadcastMessageIds = C0611i.m2794c(jSONObject, "unread_broadcast_messageIds");
            dkCloudPushMessagesInfo.mUnreadAccountMessageIds = C0611i.m2794c(jSONObject, "unread_account_messageIds");
            dkCloudPushMessagesInfo.mUnReportMessageIds = C0611i.m2794c(jSONObject, "unreport_messageIds");
            return dkCloudPushMessagesInfo;
        }
        dkCloudPushMessagesInfo = (DkCloudPushMessagesInfo) DkPublic.deserializeFromJson(jSONObject, new DkCloudPushMessagesInfo(), DkCloudPushMessagesInfo.class);
        dkCloudPushMessagesInfo.mFromLegacyStore = true;
        return dkCloudPushMessagesInfo;
    }

    /* renamed from: a */
    public String m5737a(DkCloudPushMessage dkCloudPushMessage, String str) {
        return DkPublic.serializeToJsonText(dkCloudPushMessage);
    }

    /* renamed from: a */
    public DkCloudPushMessage m5734a(String str, String str2) {
        return (DkCloudPushMessage) DkPublic.deserializeFromJsonText(str2, DkCloudPushMessage.class);
    }
}
