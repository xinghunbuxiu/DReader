package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class ca implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ bz f9927a;

    ca(bz bzVar) {
        this.f9927a = bzVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_MENU", "Tip");
        this.f9927a.m13598a(new cb(this));
    }
}
