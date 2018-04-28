package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.domain.cloud.push.MessageWakeupListener.MessageSubType;

class aa implements Runnable {
    /* renamed from: a */
    final /* synthetic */ MessageSubType f4089a;
    /* renamed from: b */
    final /* synthetic */ String f4090b;
    /* renamed from: c */
    final /* synthetic */ boolean f4091c;
    /* renamed from: d */
    final /* synthetic */ C0880y f4092d;

    aa(C0880y c0880y, MessageSubType messageSubType, String str, boolean z) {
        this.f4092d = c0880y;
        this.f4089a = messageSubType;
        this.f4090b = str;
        this.f4091c = z;
    }

    public void run() {
        if (this.f4092d.f4169j != null) {
            this.f4092d.f4169j.mo1177a(this.f4089a, this.f4090b, this.f4091c);
            return;
        }
        this.f4092d.f4168i.add(new ab(this));
    }
}
