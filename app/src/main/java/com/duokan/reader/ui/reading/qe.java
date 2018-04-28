package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class qe implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ qb f10851a;

    qe(qb qbVar) {
        this.f10851a = qbVar;
    }

    public void onClick(View view) {
        boolean aH = this.f10851a.f10845a.aH();
        if (aH) {
            UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Day");
        } else {
            UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Night");
        }
        this.f10851a.f10845a.mo2142f(!aH);
        this.f10851a.m14924a();
    }
}
