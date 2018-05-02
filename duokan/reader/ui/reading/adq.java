package com.duokan.reader.ui.reading;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;

class adq implements OnAudioFocusChangeListener {
    final /* synthetic */ AudioManager a;
    final /* synthetic */ adm b;

    adq(adm com_duokan_reader_ui_reading_adm, AudioManager audioManager) {
        this.b = com_duokan_reader_ui_reading_adm;
        this.a = audioManager;
    }

    public void onAudioFocusChange(int i) {
        if (i == -1 || i == -2) {
            this.a.abandonAudioFocus(null);
        }
    }
}
