package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.common.cache.ad;
import com.duokan.reader.common.cache.ah;
import java.util.List;

/* renamed from: com.duokan.reader.domain.cloud.push.t */
class C0875t implements ad<DkCloudPushMessage> {
    /* renamed from: a */
    static final /* synthetic */ boolean f4154a = (!C0872q.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ List f4155b;
    /* renamed from: c */
    final /* synthetic */ C0872q f4156c;

    C0875t(C0872q c0872q, List list) {
        this.f4156c = c0872q;
        this.f4155b = list;
    }

    /* renamed from: a */
    public boolean m5729a(DkCloudPushMessage dkCloudPushMessage) {
        for (DkCloudPushMessage cloudId : this.f4155b) {
            if (cloudId.getCloudId().equals(dkCloudPushMessage.getCloudId())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public ah mo1185a() {
        if (f4154a) {
            return null;
        }
        throw new AssertionError();
    }
}
