package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.bookshelf.lb;
import java.util.List;

class fv implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f4020a;
    /* renamed from: b */
    final /* synthetic */ ft f4021b;

    fv(ft ftVar, List list) {
        this.f4021b = ftVar;
        this.f4020a = list;
    }

    public void run() {
        lb.m4896a().m4918a(this.f4020a);
    }
}
