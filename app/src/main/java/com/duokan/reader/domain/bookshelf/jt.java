package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.micloud.bi;
import java.util.Arrays;

class jt implements Runnable {
    /* renamed from: a */
    final /* synthetic */ bi f3415a;
    /* renamed from: b */
    final /* synthetic */ jp f3416b;

    jt(jp jpVar, bi biVar) {
        this.f3416b = jpVar;
        this.f3415a = biVar;
    }

    public void run() {
        this.f3416b.m4742a(Arrays.asList(new bi[]{this.f3415a}), null);
    }
}
