package com.duokan.reader.ui;

class c implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ a b;

    c(a aVar, int i) {
        this.b = aVar;
        this.a = i;
    }

    public void run() {
        if (this.b.h == this.a && this.b.f.getVisibility() == 0) {
            this.b.f.setBackgroundColor(this.b.h);
        }
    }
}
