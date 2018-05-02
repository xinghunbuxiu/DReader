package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.app.BrightnessMode;

class pt implements OnClickListener {
    final /* synthetic */ pr a;

    pt(pr prVar) {
        this.a = prVar;
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
