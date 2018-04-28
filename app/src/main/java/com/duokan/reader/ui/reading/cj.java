package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class cj implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ bz f9937a;

    cj(bz bzVar) {
        this.f9937a = bzVar;
    }

    public void onClick(View view) {
        this.f9937a.mo2248a(this.f9937a.f9922p);
        UmengManager.get().onEvent("V2_READING_MENU", "Comics-Slide-Show");
    }
}
