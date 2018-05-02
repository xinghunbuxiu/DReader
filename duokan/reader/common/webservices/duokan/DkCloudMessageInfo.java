package com.duokan.reader.common.webservices.duokan;

import com.mipay.sdk.Mipay;

import org.json.JSONObject;

public class DkCloudMessageInfo extends DkStoreItemInfo {
    public String mActionParams = null;
    public boolean mDirect = true;
    public long mEndTime = 0;
    public String mMessage = null;
    public String mMessageId = null;
    public long mPublishTime = 0;
    public String mTitle = null;
    public MsgType mType = null;

    public enum MsgType {
        SYSTEM
    }

    public static DkCloudMessageInfo fromJson(JSONObject jSONObject) {
        try {
            DkCloudMessageInfo dkCloudMessageInfo = new DkCloudMessageInfo();
            try {
                dkCloudMessageInfo.mPublishTime = jSONObject.optLong("publish_time", 0);
                dkCloudMessageInfo.mEndTime = jSONObject.optLong("end_time", 0);
                dkCloudMessageInfo.mMessageId = jSONObject.getString("message_id");
                dkCloudMessageInfo.mTitle = jSONObject.getString("title");
                dkCloudMessageInfo.mMessage = jSONObject.getString(Mipay.KEY_MESSAGE);
                dkCloudMessageInfo.mType = MsgType.valueOf(jSONObject.getString("type").toUpperCase());
                dkCloudMessageInfo.mActionParams = jSONObject.optString("action_params");
                dkCloudMessageInfo.mDirect = jSONObject.optInt("push_type", 1) == 1;
                return dkCloudMessageInfo;
            } catch (Throwable th) {
                return dkCloudMessageInfo;
            }
        } catch (Throwable th2) {
            return null;
        }
    }
}
