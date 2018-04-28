package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;

class yy implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ yx f11258a;

    yy(yx yxVar) {
        this.f11258a = yxVar;
    }

    public void onClick(View view) {
        UmengManager.get().onEvent("V2_READING_POPMENU", "ShareImage");
        this.f11258a.f11254a.dismiss();
        this.f11258a.f11257d.mo2495a(this.f11258a.f11255b, this.f11258a.f11256c);
    }
}
