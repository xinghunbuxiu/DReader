package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.common.cache.i;
import com.duokan.reader.common.cache.k;

import org.apache.http.HttpStatus;

import java.io.Serializable;

public class MessageListCache extends k {

    public class DkCloudPushMessagesInfo implements Serializable {
        public String mAccountName = null;
        public String mAccountUuid = null;
        public boolean mFromLegacyStore = true;
        public boolean mInit = false;
        public String[] mUnReportMessageIds = new String[0];
        public String[] mUnreadAccountMessageIds = new String[0];
        public String[] mUnreadBroadcastMessageIds = new String[0];
    }

    public /* synthetic */ Object queryInfo() {
        return b();
    }

    public MessageListCache() {
        super("PushMessageCachePrefix", i.a, new y(), HttpStatus.SC_OK);
    }

    public void a() {
        upgradeVersion(3);
    }

    public DkCloudPushMessagesInfo b() {
        DkCloudPushMessagesInfo dkCloudPushMessagesInfo = (DkCloudPushMessagesInfo) super.queryInfo();
        if (!dkCloudPushMessagesInfo.mInit) {
            dkCloudPushMessagesInfo.mInit = true;
            dkCloudPushMessagesInfo.mUnreadAccountMessageIds = new String[0];
            dkCloudPushMessagesInfo.mUnreadBroadcastMessageIds = new String[0];
            dkCloudPushMessagesInfo.mUnReportMessageIds = new String[0];
            dkCloudPushMessagesInfo.mFromLegacyStore = false;
            updateInfo(dkCloudPushMessagesInfo);
        } else if (dkCloudPushMessagesInfo.mFromLegacyStore) {
            updateInfo(dkCloudPushMessagesInfo);
            dkCloudPushMessagesInfo.mFromLegacyStore = false;
        }
        return dkCloudPushMessagesInfo;
    }
}
