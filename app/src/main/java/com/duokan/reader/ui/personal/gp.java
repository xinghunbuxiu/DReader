package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import com.duokan.reader.ui.store.bv;
import java.util.concurrent.Callable;

class gp implements Callable<ActivatedController> {
    /* renamed from: a */
    final /* synthetic */ go f8617a;

    gp(go goVar) {
        this.f8617a = goVar;
    }

    public /* synthetic */ Object call() {
        return m11936a();
    }

    /* renamed from: a */
    public ActivatedController m11936a() {
        return bv.m15357b(this.f8617a.f8616a.getContext());
    }
}
