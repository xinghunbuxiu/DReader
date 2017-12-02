package com.duokan.core.ui;

import android.content.Context;

class k extends cv {
    final /* synthetic */ j a;

    k(j jVar, Context context) {
        this.a = jVar;
        super(context);
    }

    protected void onShow() {
        this.a.onShow();
        this.a.notifyShow();
    }

    protected void onDismiss() {
        this.a.onDismiss();
        this.a.notifyDismiss();
    }

    protected boolean onBack() {
        return this.a.onBack();
    }

    protected boolean onTouchOutside() {
        return this.a.onTouchOutside();
    }
}
