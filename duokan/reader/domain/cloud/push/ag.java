package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.domain.cloud.push.MessageWakeupListener.MessageSubType;

public interface ag {
    void a(long j, String str, String str2);

    void a(DkCloudPushMessage dkCloudPushMessage);

    void a(MessageSubType messageSubType, Object obj, boolean z);

    void a(String str, String str2, boolean z);
}
