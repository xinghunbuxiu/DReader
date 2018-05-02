package com.duokan.reader.ui.welcome;

import java.util.Timer;

/* renamed from: com.duokan.reader.ui.welcome.b */
class C1542b implements Runnable {
    /* renamed from: a */
    final /* synthetic */ long f11604a;
    /* renamed from: b */
    final /* synthetic */ Runnable f11605b;
    /* renamed from: c */
    final /* synthetic */ C1541a f11606c;

    C1542b(C1541a c1541a, long j, Runnable runnable) {
        this.f11606c = c1541a;
        this.f11604a = j;
        this.f11605b = runnable;
    }

    public void run() {
        this.f11606c.f11602c = new C1543c(this);
        this.f11606c.f11601b = new Timer();
        this.f11606c.getChildAt(0).clearAnimation();
        this.f11606c.f11601b.schedule(this.f11606c.f11602c, this.f11604a);
        if (this.f11605b != null) {
            this.f11605b.run();
        }
    }
}
