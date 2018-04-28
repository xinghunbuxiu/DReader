package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class uf implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ub f11007a;

    uf(ub ubVar) {
        this.f11007a = ubVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_MENU", "Navigation");
        if (this.f11007a.mo2251l()) {
            this.f11007a.dismissTopPopup();
        }
        this.f11007a.f9677h = true;
        this.f11007a.m13598a(new ug(this));
    }
}
