package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class ud implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ub f11005a;

    ud(ub ubVar) {
        this.f11005a = ubVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_MENU", "Back");
        this.f11005a.m13598a(new ue(this));
    }
}
