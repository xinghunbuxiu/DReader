package com.duokan.reader.ui.reading;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.duokan.core.app.BrightnessMode;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;
import com.duokan.reader.ui.welcome.p;

class wi implements OnSeekBarChangeListener {
    final /* synthetic */ wg a;

    wi(wg wgVar) {
        this.a = wgVar;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        ((p) this.a.getContext().queryFeature(p.class)).a(this.a.getContext(), UserInput.SEEK_READING_BRIGHTNESS);
        if (this.a.a.E() != BrightnessMode.MANUAL) {
            this.a.a.a(BrightnessMode.MANUAL);
            this.a.a();
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            float[] D = this.a.a.D();
            float f = ((float) i) / 1000.0f;
            this.a.a.a(((D[1] - D[0]) * f) + D[0]);
        }
    }
}
