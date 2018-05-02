package com.duokan.reader.ui.account;

class y implements Runnable {
    final /* synthetic */ t a;
    final /* synthetic */ u b;

    y(u uVar, t tVar) {
        this.b = uVar;
        this.a = tVar;
    }

    public void run() {
        if (this.b.a.f != null) {
            b.a(this.b.getContext(), this.b.a.f, this.b.a.g, this.b.a.h);
        } else {
            b.a(this.b.getContext(), this.b.a.e, this.b.a.c, this.b.a.d);
        }
    }
}
