package com.duokan.reader.ui.general.web;

import com.duokan.reader.ui.general.ja;
import java.util.concurrent.Callable;

class jj implements Callable<ja> {
    /* renamed from: a */
    final /* synthetic */ ji f8049a;

    jj(ji jiVar) {
        this.f8049a = jiVar;
    }

    public /* synthetic */ Object call() {
        return m11219a();
    }

    /* renamed from: a */
    public ja m11219a() {
        ja jaVar = new ja(this.f8049a.f8048b.f7581b.getContext());
        jaVar.show();
        return jaVar;
    }
}
