package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;

import java.util.concurrent.Callable;

class fy implements Callable {
    final /* synthetic */ fw a;

    fy(fw fwVar) {
        this.a = fwVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public ActivatedController a() {
        return new hw(this.a.a.getContext());
    }
}
