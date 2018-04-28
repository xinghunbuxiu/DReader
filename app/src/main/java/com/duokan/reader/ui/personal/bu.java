package com.duokan.reader.ui.personal;

import com.duokan.core.sys.UThread;
import com.duokan.reader.domain.cloud.C0840a;

class bu implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0840a f8364a;
    /* renamed from: b */
    final /* synthetic */ bt f8365b;

    bu(bt btVar, C0840a c0840a) {
        this.f8365b = btVar;
        this.f8364a = c0840a;
    }

    public void run() {
        if (this.f8365b.f8363d.f8354i != this.f8365b.f8360a) {
            this.f8365b.f8363d.f8354i = this.f8365b.f8360a;
            this.f8365b.f8363d.f8355j = this.f8365b.f8361b;
            this.f8365b.f8363d.f8352g = this.f8364a;
            if (this.f8365b.f8363d.f8356k != null && this.f8365b.f8363d.f8356k.isAttached()) {
                this.f8365b.f8363d.f8356k.m12226a(this.f8365b.f8363d.f8354i);
            }
            UThread.post(this.f8365b.f8362c);
        }
    }
}
