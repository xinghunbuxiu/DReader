package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import com.duokan.reader.ui.store.bv;
import java.util.concurrent.Callable;

class gi implements Callable<ActivatedController> {
    /* renamed from: a */
    final /* synthetic */ gh f8610a;

    gi(gh ghVar) {
        this.f8610a = ghVar;
    }

    public /* synthetic */ Object call() {
        return m11932a();
    }

    /* renamed from: a */
    public ActivatedController m11932a() {
        return bv.m15353a(this.f8610a.f8609a.getContext());
    }
}
