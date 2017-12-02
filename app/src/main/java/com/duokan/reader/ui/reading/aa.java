package com.duokan.reader.ui.reading;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class aa implements OnSeekBarChangeListener {
    final /* synthetic */ y a;

    aa(y yVar) {
        this.a = yVar;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.a.n().seekTo(seekBar.getProgress());
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }
}
