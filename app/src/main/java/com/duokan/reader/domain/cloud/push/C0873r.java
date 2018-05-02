package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.common.cache.ad;
import com.duokan.reader.common.cache.ah;

/* renamed from: com.duokan.reader.domain.cloud.push.r */
class C0873r implements ad<DkCloudPushMessage> {
    /* renamed from: a */
    static final /* synthetic */ boolean f4149a = (!C0872q.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ long f4150b;
    /* renamed from: c */
    final /* synthetic */ C0872q f4151c;

    C0873r(C0872q c0872q, long j) {
        this.f4151c = c0872q;
        this.f4150b = j;
    }

    /* renamed from: a */
    public boolean m5723a(DkCloudPushMessage dkCloudPushMessage) {
        return this.f4150b == 0 || dkCloudPushMessage.getReceivedDate().getTime() < this.f4150b;
    }

    /* renamed from: a */
    public ah mo1185a() {
        if (f4149a) {
            return null;
        }
        throw new AssertionError();
    }
}
