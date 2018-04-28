package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class iq implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ia f10396a;

    iq(ia iaVar) {
        this.f10396a = iaVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_MENU", "Download");
        this.f10396a.m13598a(new ir(this));
    }
}
