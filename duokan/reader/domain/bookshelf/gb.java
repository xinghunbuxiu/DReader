package com.duokan.reader.domain.bookshelf;

import java.util.HashMap;

class gb implements Runnable {
    final /* synthetic */ HashMap a;
    final /* synthetic */ ga b;

    gb(ga gaVar, HashMap hashMap) {
        this.b = gaVar;
        this.a = hashMap;
    }

    public void run() {
        if (this.b.b != null) {
            this.b.b.a(this.a);
        }
    }
}
