package com.duokan.core.ui;

class bi implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ bh b;

    bi(bh bhVar, int i) {
        this.b = bhVar;
        this.a = i;
    }

    public void run() {
        if (this.b.b.E != null) {
            this.b.b.E.a(this.b.b, this.b.b.g(this.a), this.a);
        }
    }
}
