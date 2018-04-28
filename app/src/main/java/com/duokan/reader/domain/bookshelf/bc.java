package com.duokan.reader.domain.bookshelf;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.reader.common.p037c.C0559f;

class bc implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0559f f2805a;
    /* renamed from: b */
    final /* synthetic */ ar f2806b;

    bc(ar arVar, C0559f c0559f) {
        this.f2806b = arVar;
        this.f2805a = c0559f;
    }

    public void run() {
        for (ij a : this.f2806b.h.values()) {
            a.mo949a(this.f2805a);
        }
        if ((this.f2805a.m2486e() && ManagedApp.get().getRunningState() == RunningState.FOREGROUND) || this.f2805a.m2485d()) {
            try {
                this.f2806b.k.mo1090a();
                this.f2806b.mo973a(false, false);
                this.f2806b.m3953a();
            } finally {
                this.f2806b.k.mo1096b();
            }
        }
    }
}
