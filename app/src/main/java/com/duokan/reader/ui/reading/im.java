package com.duokan.reader.ui.reading;

import android.view.View;
import com.duokan.reader.UmengManager;

class im implements Runnable {
    /* renamed from: a */
    final /* synthetic */ View f10391a;
    /* renamed from: b */
    final /* synthetic */ il f10392b;

    im(il ilVar, View view) {
        this.f10392b = ilVar;
        this.f10391a = view;
    }

    public void run() {
        if (this.f10391a.isSelected()) {
            UmengManager.get().onEvent("V2_READING_MENU", "Comics-Frame-Out");
            this.f10392b.f10390a.f.mo2181w().mo2290b();
            return;
        }
        UmengManager.get().onEvent("V2_READING_MENU", "Comics-Frame-In");
        this.f10392b.f10390a.f.mo2181w().mo2286a();
    }
}
