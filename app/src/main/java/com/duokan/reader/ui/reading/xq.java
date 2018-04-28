package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class xq implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ xp f11155a;

    xq(xp xpVar) {
        this.f11155a = xpVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "PDF-FitScreen");
        this.f11155a.m13847a(new xr(this));
    }
}
