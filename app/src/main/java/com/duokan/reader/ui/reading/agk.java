package com.duokan.reader.ui.reading;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class agk implements OnSeekBarChangeListener {
    /* renamed from: a */
    final /* synthetic */ agh f9761a;

    agk(agh agh) {
        this.f9761a = agh;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f9761a.m13689n().seekTo(seekBar.getProgress());
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        this.f9761a.m13704u();
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }
}
