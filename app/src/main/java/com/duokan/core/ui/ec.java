package com.duokan.core.ui;

import android.view.View;

final class ec implements Runnable {
    /* renamed from: a */
    final /* synthetic */ View f1212a;
    /* renamed from: b */
    final /* synthetic */ int f1213b;

    ec(View view, int i) {
        this.f1212a = view;
        this.f1213b = i;
    }

    public void run() {
        Runnable edVar = new ed(this);
        if (this.f1212a.getWindowToken() == null || this.f1212a.isLayoutRequested()) {
            AnimUtils.m1921a(this.f1212a, edVar);
        } else {
            edVar.run();
        }
    }
}
