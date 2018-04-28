package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class pb implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ox f10772a;

    pb(ox oxVar) {
        this.f10772a = oxVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_MENU", "PDF-Crop");
        this.f10772a.m13598a(new pc(this));
    }
}
