package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class ci implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ bz f9936a;

    ci(bz bzVar) {
        this.f9936a = bzVar;
    }

    public void onClick(View view) {
        this.f9936a.mo2248a(new cm(this.f9936a.getContext()));
        UmengManager.get().onEvent("V2_READING_MENU", "Comics-Page-Animation");
    }
}
