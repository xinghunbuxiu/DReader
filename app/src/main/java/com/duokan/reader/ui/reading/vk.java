package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class vk implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ vd f11060a;

    vk(vd vdVar) {
        this.f11060a = vdVar;
    }

    public void onClick(View view) {
        boolean z = true;
        boolean T = this.f11060a.f11043a.mo2003T();
        this.f11060a.f11043a.mo2040a(1, 0);
        su a = this.f11060a.f11043a;
        if (T) {
            z = false;
        }
        a.mo2132d(z);
        this.f11060a.m15030b();
    }
}
