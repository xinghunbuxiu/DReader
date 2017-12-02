package com.duokan.reader.ui.personal;

import com.duokan.core.app.e;

import java.util.concurrent.Callable;

class fy implements Callable {
    final /* synthetic */ fw a;

    fy(fw fwVar) {
        this.a = fwVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public e a() {
        return new hw(this.a.a.getContext());
    }
}
