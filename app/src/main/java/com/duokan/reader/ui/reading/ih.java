package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class ih implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ia f10386a;

    ih(ia iaVar) {
        this.f10386a = iaVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_MENU", "Buy");
        this.f10386a.m13598a(new ii(this));
    }
}
