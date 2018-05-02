package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;

class xd implements OnClickListener {
    final /* synthetic */ xc a;

    xd(xc xcVar) {
        this.a = xcVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "PDF-FitScreen");
        this.a.a(new xe(this));
    }
}
