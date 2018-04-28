package com.duokan.reader.ui.reading;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class aa implements OnSeekBarChangeListener {
    /* renamed from: a */
    final /* synthetic */ C1473y f9259a;

    aa(C1473y c1473y) {
        this.f9259a = c1473y;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f9259a.m13689n().seekTo(seekBar.getProgress());
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }
}
