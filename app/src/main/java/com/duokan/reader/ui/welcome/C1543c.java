package com.duokan.reader.ui.welcome;

import java.util.TimerTask;

/* renamed from: com.duokan.reader.ui.welcome.c */
class C1543c extends TimerTask {
    /* renamed from: a */
    final /* synthetic */ C1542b f11607a;

    C1543c(C1542b c1542b) {
        this.f11607a = c1542b;
    }

    public void run() {
        this.f11607a.f11606c.post(new C1544d(this));
    }
}
