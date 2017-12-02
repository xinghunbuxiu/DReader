package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;

class xf implements OnClickListener {
    final /* synthetic */ xc a;

    xf(xc xcVar) {
        this.a = xcVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "PDF-FitWidth");
        this.a.a(new xg(this));
    }
}
