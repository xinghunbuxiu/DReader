package com.duokan.reader.ui.general.web;

import android.content.Context;

import com.duokan.reader.ui.general.ap;

class kf extends ap {
    final /* synthetic */ Runnable a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ ke c;

    kf(ke keVar, Context context, Runnable runnable, Runnable runnable2) {
        this.c = keVar;
        this.a = runnable;
        this.b = runnable2;
        super(context);
    }

    protected void onOk() {
        super.onOk();
        this.a.run();
    }

    protected void onCancel() {
        super.onCancel();
        this.b.run();
    }
}
