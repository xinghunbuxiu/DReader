package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.common.cache.ad;
import com.duokan.reader.common.cache.ah;

import java.util.List;

class w implements ad {
    static final /* synthetic */ boolean a = (!t.class.desiredAssertionStatus());
    final /* synthetic */ List b;
    final /* synthetic */ t c;

    w(t tVar, List list) {
        this.c = tVar;
        this.b = list;
    }

    public boolean a(DkCloudPushMessage dkCloudPushMessage) {
        for (DkCloudPushMessage cloudId : this.b) {
            if (cloudId.getCloudId().equals(dkCloudPushMessage.getCloudId())) {
                return false;
            }
        }
        return true;
    }

    public ah a() {
        if (a) {
            return null;
        }
        throw new AssertionError();
    }
}
