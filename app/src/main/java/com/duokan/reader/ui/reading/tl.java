package com.duokan.reader.ui.reading;

import com.duokan.core.sys.t;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.n;

class tl implements Runnable {
    final /* synthetic */ ak a;
    final /* synthetic */ n b;
    final /* synthetic */ tc c;

    tl(tc tcVar, ak akVar, n nVar) {
        this.c = tcVar;
        this.a = akVar;
        this.b = nVar;
    }

    public void run() {
        if (this.a == this.c.v && this.a.a(2000)) {
            t.a(new tm(this));
        }
    }
}
