package com.duokan.reader.ui.reading;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class te implements OnSeekBarChangeListener {
    final /* synthetic */ tc a;

    te(tc tcVar) {
        this.a = tcVar;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.a.a((long) this.a.l.getProgress());
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        this.a.p.setVisibility(0);
        this.a.s.setVisibility(8);
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.a.a(i);
        this.a.n.setVisibility(8);
        this.a.m.setVisibility(0);
    }
}
