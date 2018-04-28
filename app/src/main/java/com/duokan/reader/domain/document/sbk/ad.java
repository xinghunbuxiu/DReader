package com.duokan.reader.domain.document.sbk;

class ad implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0983y f4775a;

    ad(C0983y c0983y) {
        this.f4775a = c0983y;
    }

    public void run() {
        this.f4775a.f4861k = true;
        this.f4775a.m7295e();
        this.f4775a.invalidateSelf();
    }
}
