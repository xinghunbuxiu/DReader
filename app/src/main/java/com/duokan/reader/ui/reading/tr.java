package com.duokan.reader.ui.reading;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

class tr implements OnSeekBarChangeListener {
    /* renamed from: a */
    final /* synthetic */ tp f10991a;

    tr(tp tpVar) {
        this.f10991a = tpVar;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f10991a.mo2252a((long) this.f10991a.f9685l.getProgress());
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        this.f10991a.f9689p.setVisibility(0);
        this.f10991a.f9692s.setVisibility(8);
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.f10991a.m13603a(i);
        this.f10991a.f9687n.setVisibility(8);
        this.f10991a.f9686m.setVisibility(0);
    }
}
