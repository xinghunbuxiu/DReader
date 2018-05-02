package com.duokan.reader.ui.personal;

import java.util.ArrayList;

class hr implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ hl b;

    hr(hl hlVar, ArrayList arrayList) {
        this.b = hlVar;
        this.a = arrayList;
    }

    public void run() {
        this.b.l.removeAll(this.a);
        this.b.g();
        this.b.s.a(!this.b.t);
    }
}
