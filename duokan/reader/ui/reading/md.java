package com.duokan.reader.ui.reading;

import android.view.View;

class md implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ mc b;

    md(mc mcVar, View view) {
        this.b = mcVar;
        this.a = view;
    }

    public void run() {
        this.a.setVisibility(4);
    }
}
