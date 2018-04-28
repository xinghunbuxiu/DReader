package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.ui.surfing.al;

class ca implements Runnable {
    /* renamed from: a */
    final /* synthetic */ al f6241a;
    /* renamed from: b */
    final /* synthetic */ bp f6242b;

    ca(bp bpVar, al alVar) {
        this.f6242b = bpVar;
        this.f6241a = alVar;
    }

    public void run() {
        this.f6242b.removeSubController(this.f6242b.f6198i);
        this.f6242b.f6198i = null;
        this.f6242b.f6197h = null;
        this.f6241a.mo2561p();
        if (this.f6242b.f6199j != null) {
            this.f6242b.f6199j.m9177b();
        }
        if (this.f6242b.f6203n != null) {
            this.f6242b.f6203n.run();
            this.f6242b.f6203n = null;
        }
    }
}
