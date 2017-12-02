package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;

class pu implements OnClickListener {
    final /* synthetic */ pr a;

    pu(pr prVar) {
        this.a = prVar;
    }

    public void onClick(View view) {
        boolean aH = this.a.a.aH();
        if (aH) {
            UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Day");
        } else {
            UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Night");
        }
        this.a.a.f(!aH);
        this.a.a();
    }
}
