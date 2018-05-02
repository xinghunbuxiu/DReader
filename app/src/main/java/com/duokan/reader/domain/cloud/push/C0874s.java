package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.common.cache.ad;
import com.duokan.reader.common.cache.ah;

/* renamed from: com.duokan.reader.domain.cloud.push.s */
class C0874s implements ad<DkCloudPushMessage> {
    /* renamed from: a */
    static final /* synthetic */ boolean f4152a = (!C0872q.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ C0872q f4153b;

    C0874s(C0872q c0872q) {
        this.f4153b = c0872q;
    }

    /* renamed from: a */
    public boolean m5726a(DkCloudPushMessage dkCloudPushMessage) {
        return !dkCloudPushMessage.getIsDirect();
    }

    /* renamed from: a */
    public ah mo1185a() {
        if (f4152a) {
            return null;
        }
        throw new AssertionError();
    }
}
