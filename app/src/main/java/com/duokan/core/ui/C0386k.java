package com.duokan.core.ui;

import android.content.Context;

/* renamed from: com.duokan.core.ui.k */
class C0386k extends cv {
    /* renamed from: a */
    final /* synthetic */ C0342j f1327a;

    C0386k(C0342j c0342j, Context context) {
        this.f1327a = c0342j;
        super(context);
    }

    protected void onShow() {
        this.f1327a.onShow();
        this.f1327a.notifyShow();
    }

    protected void onDismiss() {
        this.f1327a.onDismiss();
        this.f1327a.notifyDismiss();
    }

    protected boolean onBack() {
        return this.f1327a.onBack();
    }

    protected boolean onTouchOutside() {
        return this.f1327a.onTouchOutside();
    }
}
