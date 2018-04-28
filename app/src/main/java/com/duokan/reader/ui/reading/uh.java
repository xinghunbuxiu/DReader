package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class uh implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ub f11009a;

    uh(ub ubVar) {
        this.f11009a = ubVar;
    }

    public void onClick(View view) {
        boolean aH = this.f11009a.f9675f.aH();
        if (aH) {
            UmengManager.get().onEvent("V2_READING_MENU", "Day");
        } else {
            UmengManager.get().onEvent("V2_READING_MENU", "Night");
        }
        this.f11009a.f9675f.mo2142f(!aH);
        this.f11009a.mo2249c();
    }
}
