package com.duokan.reader.ui.welcome;

import android.view.ViewGroup;

class k implements Runnable {
    final /* synthetic */ ViewGroup a;
    final /* synthetic */ j b;

    k(j jVar, ViewGroup viewGroup) {
        this.b = jVar;
        this.a = viewGroup;
    }

    public void run() {
        this.a.removeViewInLayout(this.b.e);
        this.b.e = null;
    }
}
