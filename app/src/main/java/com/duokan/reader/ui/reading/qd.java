package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.app.BrightnessMode;

class qd implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ qb f10850a;

    qd(qb qbVar) {
        this.f10850a = qbVar;
    }

    public void onClick(View view) {
        if (view.isSelected()) {
            this.f10850a.f10845a.mo2020a(BrightnessMode.MANUAL);
            this.f10850a.m14924a();
            return;
        }
        this.f10850a.f10845a.mo2020a(BrightnessMode.SYSTEM);
        this.f10850a.m14924a();
    }
}
