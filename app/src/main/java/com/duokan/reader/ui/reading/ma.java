package com.duokan.reader.ui.reading;

import android.media.AudioManager.OnAudioFocusChangeListener;

class ma implements OnAudioFocusChangeListener {
    final /* synthetic */ lx a;

    ma(lx lxVar) {
        this.a = lxVar;
    }

    public void onAudioFocusChange(int i) {
        if (i == -1) {
            this.a.g();
        }
    }
}
