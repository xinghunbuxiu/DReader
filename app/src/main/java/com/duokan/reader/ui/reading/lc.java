package com.duokan.reader.ui.reading;

import org.apache.http.HttpStatus;

class lc implements Runnable {
    final /* synthetic */ fu a;
    final /* synthetic */ lb b;

    lc(lb lbVar, fu fuVar) {
        this.b = lbVar;
        this.a = fuVar;
    }

    public void run() {
        Runnable ldVar = new ld(this);
        if (this.a.b()) {
            this.a.a(null);
            this.b.a(this.a, this.b.a(this.a), HttpStatus.SC_MULTIPLE_CHOICES, ldVar, null);
            return;
        }
        this.a.a(new le(this, ldVar));
    }
}
