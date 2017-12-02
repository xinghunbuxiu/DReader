package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.common.cache.ad;
import com.duokan.reader.common.cache.ah;

class v implements ad {
    static final /* synthetic */ boolean a = (!t.class.desiredAssertionStatus());
    final /* synthetic */ t b;

    v(t tVar) {
        this.b = tVar;
    }

    public boolean a(DkCloudPushMessage dkCloudPushMessage) {
        return !dkCloudPushMessage.getIsDirect();
    }

    public ah a() {
        if (a) {
            return null;
        }
        throw new AssertionError();
    }
}
