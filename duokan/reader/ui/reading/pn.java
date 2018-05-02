package com.duokan.reader.ui.reading;

import android.content.Context;

import com.duokan.core.ui.t;

class pn extends t {
    final /* synthetic */ Runnable a;
    final /* synthetic */ pc b;

    pn(pc pcVar, Context context, Runnable runnable) {
        this.b = pcVar;
        this.a = runnable;
        super(context);
    }

    public boolean onBack() {
        this.a.run();
        return true;
    }
}
