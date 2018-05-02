package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.BrightnessMode;

class wj implements OnClickListener {
    final /* synthetic */ wg a;

    wj(wg wgVar) {
        this.a = wgVar;
    }

    public void onClick(View view) {
        if (view.isSelected()) {
            this.a.a.a(BrightnessMode.MANUAL);
            this.a.a();
            return;
        }
        this.a.a.a(BrightnessMode.SYSTEM);
        this.a.a();
    }
}
