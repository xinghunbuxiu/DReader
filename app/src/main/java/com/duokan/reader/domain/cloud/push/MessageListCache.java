package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.common.cache.C0449k;
import com.duokan.reader.common.cache.C0576i;
import java.io.Serializable;
import org.apache.http.HttpStatus;

public class MessageListCache extends C0449k<DkCloudPushMessagesInfo, DkCloudPushMessage, String> {

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
        return m5639b();
    }

    public MessageListCache() {
        super("PushMessageCachePrefix", C0576i.f1884a, new C0878w(), HttpStatus.SC_OK);
    }

    /* renamed from: a */
    public void m5638a() {
        upgradeVersion(3);
    }

    /* renamed from: b */
    public DkCloudPushMessagesInfo m5639b() {
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
