package com.duokan.core.p026a;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import java.io.File;


class C0290q implements Runnable {
    
    static final  boolean f487a = (!C0285n.class.desiredAssertionStatus());
    
    final  File f488b;
    
    final  File f489c;
    
    final  C0285n f490d;

    C0290q(C0285n c0285n, File file, File file2) {
        this.f490d = c0285n;
        this.f488b = file;
        this.f489c = file2;
    }

    public void run() {
        if (this.f490d.f482g == this) {
            if (!f487a && this.f490d.f481f) {
                throw new AssertionError();
            } else if (!this.f490d.f481f && ManagedApp.get().getRunningState().ordinal() <= RunningState.BACKGROUND.ordinal()) {
                this.f490d.f481f = true;
                new Thread(new C0291r(this)).start();
            }
        }
    }
}
