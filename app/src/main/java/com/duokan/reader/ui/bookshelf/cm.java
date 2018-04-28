package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.bookshelf.an;

class cm implements Runnable {
    /* renamed from: a */
    final /* synthetic */ an f6280a;
    /* renamed from: b */
    final /* synthetic */ an f6281b;
    /* renamed from: c */
    final /* synthetic */ int f6282c;
    /* renamed from: d */
    final /* synthetic */ ce f6283d;

    cm(ce ceVar, an anVar, an anVar2, int i) {
        this.f6283d = ceVar;
        this.f6280a = anVar;
        this.f6281b = anVar2;
        this.f6282c = i;
    }

    public void run() {
        this.f6283d.m9367a(500, new cn(this));
    }
}
