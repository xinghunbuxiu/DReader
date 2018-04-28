package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.micloud.bi;
import java.util.Arrays;

class ju implements Runnable {
    /* renamed from: a */
    final /* synthetic */ bi f3417a;
    /* renamed from: b */
    final /* synthetic */ jp f3418b;

    ju(jp jpVar, bi biVar) {
        this.f3418b = jpVar;
        this.f3417a = biVar;
    }

    public void run() {
        this.f3418b.m4742a(null, Arrays.asList(new bi[]{this.f3417a}));
    }
}
