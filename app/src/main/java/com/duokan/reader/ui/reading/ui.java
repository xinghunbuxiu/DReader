package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class ui implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ub f11010a;

    ui(ub ubVar) {
        this.f11010a = ubVar;
    }

    public void onClick(View view) {
        this.f11010a.mo2253b();
        UmengManager.get().onEvent("V2_READING_MENU", "More");
    }
}
