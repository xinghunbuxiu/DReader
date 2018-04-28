package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class tq implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ tp f10990a;

    tq(tp tpVar) {
        this.f10990a = tpVar;
    }

    public void onClick(View view) {
        this.f10990a.mo2248a(new qb(this.f10990a.getContext()));
        UmengManager.get().onEvent("V2_READING_MENU", "Brightness");
    }
}
