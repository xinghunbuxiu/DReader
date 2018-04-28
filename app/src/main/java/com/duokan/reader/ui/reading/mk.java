package com.duokan.reader.ui.reading;

import android.media.AudioManager.OnAudioFocusChangeListener;

class mk implements OnAudioFocusChangeListener {
    /* renamed from: a */
    final /* synthetic */ mh f10628a;

    mk(mh mhVar) {
        this.f10628a = mhVar;
    }

    public void onAudioFocusChange(int i) {
        if (i == -1) {
            this.f10628a.m13682g();
        }
    }
}
