package com.duokan.reader.ui.personal;

class fc implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f8534a;
    /* renamed from: b */
    final /* synthetic */ ez f8535b;

    fc(ez ezVar, int i) {
        this.f8535b = ezVar;
        this.f8534a = i;
    }

    public void run() {
        if (this.f8535b.f8530a.f8525c == null) {
            this.f8535b.f8530a.f8525c = new fn(this.f8535b.f8530a, this.f8535b.f8530a.f8523a);
        }
        if (!this.f8535b.f8530a.f8525c.isShowing()) {
            this.f8535b.f8530a.f8525c.show();
        }
        this.f8535b.f8530a.f8525c.m11792a(this.f8534a);
    }
}
