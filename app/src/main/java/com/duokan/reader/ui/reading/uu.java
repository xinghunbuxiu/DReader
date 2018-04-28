package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class uu implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ uq f11033a;

    uu(uq uqVar) {
        this.f11033a = uqVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Bookmark");
        this.f11033a.m13847a(new uv(this));
    }
}
