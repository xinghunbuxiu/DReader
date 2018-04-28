package com.duokan.reader.domain.document.txt;

class ap implements Runnable {
    /* renamed from: a */
    final /* synthetic */ aj f4910a;

    ap(aj ajVar) {
        this.f4910a = ajVar;
    }

    public void run() {
        this.f4910a.f4896k = true;
        this.f4910a.m7412d();
        this.f4910a.invalidateSelf();
    }
}
