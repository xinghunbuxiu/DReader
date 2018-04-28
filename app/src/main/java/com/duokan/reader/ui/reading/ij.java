package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class ij implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ia f10388a;

    ij(ia iaVar) {
        this.f10388a = iaVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_MENU", "Comment");
        this.f10388a.m13598a(new ik(this));
    }
}
