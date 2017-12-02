package com.duokan.reader.domain.document.epub;

import java.util.concurrent.CountDownLatch;

class y implements cc {
    final /* synthetic */ CountDownLatch a;
    final /* synthetic */ s b;

    y(s sVar, CountDownLatch countDownLatch) {
        this.b = sVar;
        this.a = countDownLatch;
    }

    public void a(cd cdVar) {
        this.a.countDown();
    }

    public void b(cd cdVar) {
    }
}
