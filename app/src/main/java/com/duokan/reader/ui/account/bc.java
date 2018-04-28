package com.duokan.reader.ui.account;

class bc implements Runnable {
    /* renamed from: a */
    final /* synthetic */ bt f5861a;
    /* renamed from: b */
    final /* synthetic */ ay f5862b;

    bc(ay ayVar, bt btVar) {
        this.f5862b = ayVar;
        this.f5861a = btVar;
    }

    public void run() {
        this.f5862b.e.dismiss();
        this.f5861a.mo1572a();
    }
}
