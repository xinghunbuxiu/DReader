package com.duokan.reader.ui.reading;

import android.view.View;
import com.duokan.reader.UmengManager;

class ch implements Runnable {
    /* renamed from: a */
    final /* synthetic */ View f9934a;
    /* renamed from: b */
    final /* synthetic */ cg f9935b;

    ch(cg cgVar, View view) {
        this.f9935b = cgVar;
        this.f9934a = view;
    }

    public void run() {
        if (this.f9934a.isSelected()) {
            UmengManager.get().onEvent("V2_READING_MENU", "Comics-Frame-Out");
            this.f9935b.f9933a.f.mo2181w().mo2290b();
            return;
        }
        UmengManager.get().onEvent("V2_READING_MENU", "Comics-Frame-In");
        this.f9935b.f9933a.f.mo2181w().mo2286a();
    }
}
