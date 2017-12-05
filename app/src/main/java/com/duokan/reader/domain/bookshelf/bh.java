package com.duokan.reader.domain.bookshelf;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.reader.common.classc;

class bh implements Runnable {
    final /* synthetic */ classc.ConnectivityReceiver a;
    final /* synthetic */ aq b;

    bh(aq aqVar, classc.ConnectivityReceiver connectivity) {
        this.b = aqVar;
        this.a = connectivity;
    }

    public void run() {
        for (BaseConnect onConnectivityChanged : this.b.h.values()) {
            onConnectivityChanged.onConnectivityChanged(this.a);
        }
        if ((this.a.e() && ManagedApp.get().getOldRunningState() == RunningState.FOREGROUND) || this.a.d()) {
            try {
                this.b.k.a();
                this.b.a(false, false);
                this.b.a();
            } finally {
                this.b.k.b();
            }
        }
    }
}
