package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.bookshelf.kp;

import java.util.List;

class gp implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ gn b;

    gp(gn gnVar, List list) {
        this.b = gnVar;
        this.a = list;
    }

    public void run() {
        kp.a().a(this.a);
    }
}
