package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.bookshelf.ai;

class eb implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ String b;
    final /* synthetic */ du c;

    eb(du duVar, boolean z, String str) {
        this.c = duVar;
        this.a = z;
        this.b = str;
    }

    public void run() {
        this.c.h.setVisibility(8);
        if (this.a) {
            ai.a().a(this.c.a, this.b);
            this.c.g.setText(this.b);
            this.c.a.aL();
            return;
        }
        this.c.g.setText(this.c.a.k());
    }
}
