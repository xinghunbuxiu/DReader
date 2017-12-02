package com.duokan.core.ui;

import android.view.View;

final class ec implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ int b;

    ec(View view, int i) {
        this.a = view;
        this.b = i;
    }

    public void run() {
        Runnable edVar = new ed(this);
        if (this.a.getWindowToken() == null || this.a.isLayoutRequested()) {
            dv.a(this.a, edVar);
        } else {
            edVar.run();
        }
    }
}
