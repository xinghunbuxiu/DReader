package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;

import java.util.concurrent.Callable;

class gh implements Callable {
    final /* synthetic */ gf a;

    gh(gf gfVar) {
        this.a = gfVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public ActivatedController a() {
        return new mh(this.a.a.getContext());
    }
}
