package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.cloud.push.C0857b;
import com.duokan.reader.domain.cloud.push.MessageWakeupListener.MessageSubType;

class fu implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ft f4019a;

    fu(ft ftVar) {
        this.f4019a = ftVar;
    }

    public void run() {
        C0857b.m5649a().m5680a(MessageSubType.USER_TASK, this.f4019a);
        C0857b.m5649a().m5680a(MessageSubType.RESIGN_SUCCEED, this.f4019a);
        C0857b.m5649a().m5680a(MessageSubType.RECHARGE_SUCCEED, this.f4019a);
    }
}
