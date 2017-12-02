package com.duokan.reader.ui.personal;

import java.util.ArrayList;

class ln implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ lm b;

    ln(lm lmVar, ArrayList arrayList) {
        this.b = lmVar;
        this.a = arrayList;
    }

    public void run() {
        this.b.a.run();
        this.b.b.b(this.a);
    }
}
