package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class ip implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ia f10395a;

    ip(ia iaVar) {
        this.f10395a = iaVar;
    }

    public void onClick(View view) {
        this.f10395a.mo2248a(this.f10395a.f10375t);
        UmengManager.get().onEvent("V2_READING_MENU", "Comics-Slide-Show");
    }
}
