package com.duokan.reader.ui.reading;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.duokan.core.app.BrightnessMode;
import com.duokan.reader.ui.welcome.C1540p;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;

class wv implements OnSeekBarChangeListener {
    /* renamed from: a */
    final /* synthetic */ wt f11129a;

    wv(wt wtVar) {
        this.f11129a = wtVar;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        ((C1540p) this.f11129a.getContext().queryFeature(C1540p.class)).mo2564a(this.f11129a.getContext(), UserInput.SEEK_READING_BRIGHTNESS);
        if (this.f11129a.f11124a.mo1990E() != BrightnessMode.MANUAL) {
            this.f11129a.f11124a.mo2020a(BrightnessMode.MANUAL);
            this.f11129a.m15061a();
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            float[] D = this.f11129a.f11124a.mo1989D();
            float f = ((float) i) / 1000.0f;
            this.f11129a.f11124a.mo2016a(((D[1] - D[0]) * f) + D[0]);
        }
    }
}
