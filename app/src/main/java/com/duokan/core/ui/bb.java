package com.duokan.core.ui;

import com.duokan.core.sys.j;

class bb implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ ay b;

    bb(ay ayVar, Runnable runnable) {
        this.b = ayVar;
        this.a = runnable;
    }

    public void run() {
        if (this.b.D == this) {
            bc r = this.b.r(this.b.B);
            if (r != null) {
                if (r.b != null) {
                    r.b.setPressed(false);
                }
                j.a(this.a);
            }
            this.b.B = -1;
            this.b.D = null;
        }
    }
}
