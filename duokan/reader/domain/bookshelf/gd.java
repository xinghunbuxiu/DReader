package com.duokan.reader.domain.bookshelf;

import java.util.HashMap;

class gd implements Runnable {
    final /* synthetic */ HashMap a;
    final /* synthetic */ gc b;

    gd(gc gcVar, HashMap hashMap) {
        this.b = gcVar;
        this.a = hashMap;
    }

    public void run() {
        if (this.b.b != null) {
            this.b.b.a(this.a);
        }
    }
}
