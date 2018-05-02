package com.duokan.reader.domain.social.message;

import com.duokan.reader.domain.cloud.push.C0857b;
import com.duokan.reader.domain.cloud.push.MessageWakeupListener.MessageSubType;

/* renamed from: com.duokan.reader.domain.social.message.p */
class C1154p implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1153o f5570a;

    C1154p(C1153o c1153o) {
        this.f5570a = c1153o;
    }

    public void run() {
        C0857b.m5649a().m5680a(MessageSubType.MESSAGE_LOOPER, this.f5570a);
    }
}
