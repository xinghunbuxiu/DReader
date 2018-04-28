package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class ck implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ bz f9938a;

    ck(bz bzVar) {
        this.f9938a = bzVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_MENU", "Download");
        this.f9938a.m13598a(new cl(this));
    }
}
