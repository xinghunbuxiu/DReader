package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import com.duokan.reader.ui.store.bv;

import java.util.concurrent.Callable;

class gc implements Callable {
    final /* synthetic */ gb a;

    gc(gb gbVar) {
        this.a = gbVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public ActivatedController a() {
        return bv.b(this.a.a.getContext());
    }
}
