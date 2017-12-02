package com.duokan.reader.ui.reading;

import android.view.View;

import com.duokan.reader.UmengManager;

class cf implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ ce b;

    cf(ce ceVar, View view) {
        this.b = ceVar;
        this.a = view;
    }

    public void run() {
        if (this.a.isSelected()) {
            UmengManager.get().onEvent("V2_READING_FLOAT_TOOLBUTTON", "Comics-Frame-Out");
            this.b.a.f.w().b();
            return;
        }
        UmengManager.get().onEvent("V2_READING_FLOAT_TOOLBUTTON", "Comics-Frame-In");
        this.b.a.f.w().a();
    }
}
