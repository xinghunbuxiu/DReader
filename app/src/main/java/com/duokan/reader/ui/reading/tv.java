package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class tv implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ tp f10995a;

    tv(tp tpVar) {
        this.f10995a = tpVar;
    }

    public void onClick(View view) {
        this.f10995a.f9689p.setVisibility(0);
        this.f10995a.f9692s.setVisibility(8);
        this.f10995a.mo2255g();
        this.f10995a.mo2385d();
        UmengManager.get().onEvent("V2_READING_MENU", "Prev-Chapter");
    }
}
