package com.duokan.reader.ui.reading;

import com.duokan.core.app.ab;
import com.duokan.core.app.ac;

class xn implements ac {
    final /* synthetic */ Runnable a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ xm c;

    xn(xm xmVar, Runnable runnable, Runnable runnable2) {
        this.c = xmVar;
        this.a = runnable;
        this.b = runnable2;
    }

    public void a(ab abVar) {
        this.a.run();
    }

    public void b(ab abVar) {
        this.b.run();
    }
}
