package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;

class tu implements OnClickListener {
    final /* synthetic */ to a;

    tu(to toVar) {
        this.a = toVar;
    }

    public void onClick(View view) {
        boolean aH = this.a.f.aH();
        if (aH) {
            UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Day");
        } else {
            UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Night");
        }
        this.a.f.f(!aH);
        this.a.c();
    }
}
