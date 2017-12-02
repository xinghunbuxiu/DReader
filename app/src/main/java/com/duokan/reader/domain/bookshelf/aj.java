package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.c.f;
import com.duokan.reader.common.d.a;

class aj implements Runnable {
    final /* synthetic */ ai a;

    aj(ai aiVar) {
        this.a = aiVar;
    }

    public void run() {
        new a(new ak(this), 31).a(600000);
        f.b().a(this.a);
        if (f.b().e()) {
            this.a.onConnectivityChanged(f.b());
        }
    }
}
