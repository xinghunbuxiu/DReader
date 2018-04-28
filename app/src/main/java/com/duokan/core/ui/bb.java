package com.duokan.core.ui;

import com.duokan.core.sys.UIdleHandler;

class bb implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f991a;
    /* renamed from: b */
    final /* synthetic */ ay f992b;

    bb(ay ayVar, Runnable runnable) {
        this.f992b = ayVar;
        this.f991a = runnable;
    }

    public void run() {
        if (this.f992b.f762D == this) {
            bc r = this.f992b.m1163r(this.f992b.f760B);
            if (r != null) {
                if (r.f994b != null) {
                    r.f994b.setPressed(false);
                }
                UIdleHandler.runAction(this.f991a);
            }
            this.f992b.f760B = -1;
            this.f992b.f762D = null;
        }
    }
}
