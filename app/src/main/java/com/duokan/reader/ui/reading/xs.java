package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class xs implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ xp f11157a;

    xs(xp xpVar) {
        this.f11157a = xpVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "PDF-FitWidth");
        this.f11157a.m13847a(new xt(this));
    }
}
