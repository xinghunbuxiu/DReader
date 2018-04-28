package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class wu implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ wt f11128a;

    wu(wt wtVar) {
        this.f11128a = wtVar;
    }

    public void onClick(View view) {
        this.f11128a.f11124a.mo2032a(view.isSelected() ? SlideShowEffect.NONE : SlideShowEffect.SIMPLE);
        this.f11128a.m15061a();
    }
}
