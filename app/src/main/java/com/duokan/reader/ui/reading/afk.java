package com.duokan.reader.ui.reading;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class afk implements OnSeekBarChangeListener {
    final /* synthetic */ afh a;

    afk(afh com_duokan_reader_ui_reading_afh) {
        this.a = com_duokan_reader_ui_reading_afh;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.a.n().seekTo(seekBar.getProgress());
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        this.a.u();
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }
}
