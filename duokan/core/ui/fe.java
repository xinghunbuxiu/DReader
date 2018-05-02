package com.duokan.core.ui;

import com.duokan.core.sys.TaskHandler;

class fe implements Runnable {
    final /* synthetic */ ev a;
    private final boolean b;
    private final Runnable c;
    private final Runnable d;

    public fe(ev evVar, boolean z, Runnable runnable, Runnable runnable2) {
        this.a = evVar;
        this.b = z;
        this.c = runnable;
        this.d = runnable2;
    }

    public void run() {
        if (this.a.A != this) {
            TaskHandler.PostTask(this.d);
            return;
        }
        this.a.b.h();
        this.a.g((float) this.a.b.b(), (float) this.a.b.c());
        if (!this.a.b.a()) {
            this.a.a.post(this);
        } else if (!this.b && this.a.b.a(Math.round(this.a.h.left), Math.round(this.a.h.top), this.a.al(), this.a.am(), this.a.b(), this.a.an())) {
            this.a.a.post(this);
        } else if (this.c != null) {
            TaskHandler.PostTask(this.c);
        }
    }
}
