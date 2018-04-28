package com.duokan.reader.ui.reading;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.duokan.core.app.BrightnessMode;
import com.duokan.reader.ui.welcome.C1540p;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;

class qc implements OnSeekBarChangeListener {
    /* renamed from: a */
    final /* synthetic */ qb f10849a;

    qc(qb qbVar) {
        this.f10849a = qbVar;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        ((C1540p) this.f10849a.getContext().queryFeature(C1540p.class)).mo2564a(this.f10849a.getContext(), UserInput.SEEK_READING_BRIGHTNESS);
        if (this.f10849a.f10845a.mo1990E() != BrightnessMode.MANUAL) {
            this.f10849a.f10845a.mo2020a(BrightnessMode.MANUAL);
            this.f10849a.m14924a();
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            float[] D = this.f10849a.f10845a.mo1989D();
            float f = ((float) i) / 1000.0f;
            this.f10849a.f10845a.mo2016a(((D[1] - D[0]) * f) + D[0]);
        }
    }
}
