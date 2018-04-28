package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.BrightnessMode;

class ww implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ wt f11130a;

    ww(wt wtVar) {
        this.f11130a = wtVar;
    }

    public void onClick(View view) {
        if (view.isSelected()) {
            this.f11130a.f11124a.mo2020a(BrightnessMode.MANUAL);
            this.f11130a.m15061a();
            return;
        }
        this.f11130a.f11124a.mo2020a(BrightnessMode.SYSTEM);
        this.f11130a.m15061a();
    }
}
