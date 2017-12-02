package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.common.cache.ad;
import com.duokan.reader.common.cache.ah;

class u implements ad {
    static final /* synthetic */ boolean a = (!t.class.desiredAssertionStatus());
    final /* synthetic */ long b;
    final /* synthetic */ t c;

    u(t tVar, long j) {
        this.c = tVar;
        this.b = j;
    }

    public boolean a(DkCloudPushMessage dkCloudPushMessage) {
        return this.b == 0 || dkCloudPushMessage.getReceivedDate().getTime() < this.b;
    }

    public ah a() {
        if (a) {
            return null;
        }
        throw new AssertionError();
    }
}
