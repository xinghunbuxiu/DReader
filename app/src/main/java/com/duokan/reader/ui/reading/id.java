package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class id implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ia f10382a;

    id(ia iaVar) {
        this.f10382a = iaVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_MENU", "Tip");
        this.f10382a.m13598a(new ie(this));
    }
}
