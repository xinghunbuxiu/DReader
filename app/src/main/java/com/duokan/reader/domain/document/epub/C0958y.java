package com.duokan.reader.domain.document.epub;

import java.util.concurrent.CountDownLatch;

/* renamed from: com.duokan.reader.domain.document.epub.y */
class C0958y implements cc {
    /* renamed from: a */
    final /* synthetic */ CountDownLatch f4750a;
    /* renamed from: b */
    final /* synthetic */ C0952s f4751b;

    C0958y(C0952s c0952s, CountDownLatch countDownLatch) {
        this.f4751b = c0952s;
        this.f4750a = countDownLatch;
    }

    /* renamed from: a */
    public void mo1377a(cd cdVar) {
        this.f4750a.countDown();
    }

    /* renamed from: b */
    public void mo1378b(cd cdVar) {
    }
}
