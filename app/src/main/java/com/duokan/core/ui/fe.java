package com.duokan.core.ui;

import com.duokan.core.sys.UThread;

class fe implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ev f1245a;
    /* renamed from: b */
    private final boolean f1246b;
    /* renamed from: c */
    private final Runnable f1247c;
    /* renamed from: d */
    private final Runnable f1248d;

    public fe(ev evVar, boolean z, Runnable runnable, Runnable runnable2) {
        this.f1245a = evVar;
        this.f1246b = z;
        this.f1247c = runnable;
        this.f1248d = runnable2;
    }

    public void run() {
        if (this.f1245a.f921A != this) {
            UThread.post(this.f1248d);
            return;
        }
        this.f1245a.f936b.m1721h();
        this.f1245a.m1547g((float) this.f1245a.f936b.m1714b(), (float) this.f1245a.f936b.m1716c());
        if (!this.f1245a.f936b.m1712a()) {
            this.f1245a.f935a.post(this);
        } else if (!this.f1246b && this.f1245a.f936b.m1713a(Math.round(this.f1245a.f941h.left), Math.round(this.f1245a.f941h.top), this.f1245a.al(), this.f1245a.am(), this.f1245a.mo504b(), this.f1245a.an())) {
            this.f1245a.f935a.post(this);
        } else if (this.f1247c != null) {
            UThread.post(this.f1247c);
        }
    }
}
