package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.domain.cloud.push.MessageWakeupListener.MessageSubType;

class ab implements Runnable {
    final /* synthetic */ MessageSubType a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;
    final /* synthetic */ z d;

    ab(z zVar, MessageSubType messageSubType, String str, boolean z) {
        this.d = zVar;
        this.a = messageSubType;
        this.b = str;
        this.c = z;
    }

    public void run() {
        if (this.d.j != null) {
            this.d.j.a(this.a, this.b, this.c);
            return;
        }
        this.d.i.add(new ac(this));
    }
}
