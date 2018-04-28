package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class in implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ia f10393a;

    in(ia iaVar) {
        this.f10393a = iaVar;
    }

    public void onClick(View view) {
        this.f10393a.mo2248a(new ul(this.f10393a.getContext()));
        UmengManager.get().onEvent("V2_READING_MENU", "Mode");
    }
}
