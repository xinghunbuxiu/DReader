package com.duokan.reader.domain.social.message;

import com.duokan.reader.domain.cloud.push.MessageWakeupListener.MessageSubType;
import com.duokan.reader.domain.cloud.push.b;

class r implements Runnable {
    final /* synthetic */ o a;

    r(o oVar) {
        this.a = oVar;
    }

    public void run() {
        b.a().a(MessageSubType.MESSAGE_LOOPER, this.a);
    }
}
