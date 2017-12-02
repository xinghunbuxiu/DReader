package com.duokan.reader.ui.personal;

import com.duokan.core.app.e;
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

    public e a() {
        return bv.a(this.a.a.getContext());
    }
}
