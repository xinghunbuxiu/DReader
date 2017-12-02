package com.duokan.reader.ui.welcome;

import java.util.Timer;

class b implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ a c;

    b(a aVar, long j, Runnable runnable) {
        this.c = aVar;
        this.a = j;
        this.b = runnable;
    }

    public void run() {
        this.c.c = new c(this);
        this.c.b = new Timer();
        this.c.getChildAt(0).clearAnimation();
        this.c.b.schedule(this.c.c, this.a);
        if (this.b != null) {
            this.b.run();
        }
    }
}
