package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.classc;
import com.duokan.reader.common.d.a;

class aj implements Runnable {
    final /* synthetic */ ai a;

    aj(ai aiVar) {
        this.a = aiVar;
    }

    public void run() {
        new a(new ak(this), 31).a(600000);
        classc.ConnectivityReceiver.b().a(this.a);
        if (classc.ConnectivityReceiver.b().e()) {
            this.a.onConnectivityChanged(classc.ConnectivityReceiver.b());
        }
    }
}
