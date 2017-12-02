package com.duokan.reader.ui.personal;

import com.duokan.core.app.e;

import java.util.concurrent.Callable;

class gh implements Callable {
    final /* synthetic */ gf a;

    gh(gf gfVar) {
        this.a = gfVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public e a() {
        return new mh(this.a.a.getContext());
    }
}
