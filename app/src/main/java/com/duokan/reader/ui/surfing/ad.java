package com.duokan.reader.ui.surfing;

class ad implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Object b;
    final /* synthetic */ boolean c;
    final /* synthetic */ Runnable d;
    final /* synthetic */ f e;

    ad(f fVar, String str, Object obj, boolean z, Runnable runnable) {
        this.e = fVar;
        this.a = str;
        this.b = obj;
        this.c = z;
        this.d = runnable;
    }

    public void run() {
        int indexOf = this.a.indexOf(47);
        if (indexOf >= 0 && indexOf < this.a.length() - 1) {
            this.e.o.navigate(this.a.substring(indexOf + 1), this.b, this.c, this.d);
        }
    }
}
