package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.general.gi;

class qu implements Runnable {
    final /* synthetic */ gi a;
    final /* synthetic */ qh b;

    qu(qh qhVar, gi giVar) {
        this.b = qhVar;
        this.a = giVar;
    }

    public void run() {
        if (this.b.c.X() == this.a) {
            this.b.a(this.a);
        }
    }
}
