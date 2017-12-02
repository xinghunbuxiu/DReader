package com.duokan.core.a;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;

import java.io.File;

class q implements Runnable {
    static final /* synthetic */ boolean a = (!n.class.desiredAssertionStatus());
    final /* synthetic */ File b;
    final /* synthetic */ File c;
    final /* synthetic */ n d;

    q(n nVar, File file, File file2) {
        this.d = nVar;
        this.b = file;
        this.c = file2;
    }

    public void run() {
        if (this.d.g == this) {
            if (!a && this.d.f) {
                throw new AssertionError();
            } else if (!this.d.f && ManagedApp.get().getRunningState().ordinal() <= RunningState.BACKGROUND.ordinal()) {
                this.d.f = true;
                new Thread(new r(this)).start();
            }
        }
    }
}
