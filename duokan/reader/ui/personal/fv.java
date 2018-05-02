package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import com.duokan.reader.ui.store.bv;

import java.util.concurrent.Callable;

class fv implements Callable {
    final /* synthetic */ fu a;

    fv(fu fuVar) {
        this.a = fuVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public ActivatedController a() {
        return bv.a(this.a.a.getContext());
    }
}
