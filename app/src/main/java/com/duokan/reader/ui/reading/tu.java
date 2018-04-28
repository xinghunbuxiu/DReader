package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class tu implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ tp f10994a;

    tu(tp tpVar) {
        this.f10994a = tpVar;
    }

    public void onClick(View view) {
        this.f10994a.f9689p.setVisibility(0);
        this.f10994a.f9692s.setVisibility(8);
        this.f10994a.mo2254f();
        this.f10994a.mo2385d();
        UmengManager.get().onEvent("V2_READING_MENU", "Next-Chapter");
    }
}
