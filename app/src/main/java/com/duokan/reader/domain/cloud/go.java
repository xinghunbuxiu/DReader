package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.c.f;
import com.duokan.reader.domain.cloud.push.MessageWakeupListener.MessageSubType;
import com.duokan.reader.domain.cloud.push.b;

class go implements Runnable {
    final /* synthetic */ gn a;

    go(gn gnVar) {
        this.a = gnVar;
    }

    public void run() {
        f.b().a(this.a);
        b.a().a(MessageSubType.USER_TASK, this.a);
        b.a().a(MessageSubType.RESIGN_SUCCEED, this.a);
        b.a().a(MessageSubType.RECHARGE_SUCCEED, this.a);
    }
}
