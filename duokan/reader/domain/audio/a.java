package com.duokan.reader.domain.audio;

import android.media.AudioManager.OnAudioFocusChangeListener;

class a implements OnAudioFocusChangeListener {
    final /* synthetic */ AudioPlayer a;

    a(AudioPlayer audioPlayer) {
        this.a = audioPlayer;
    }

    public void onAudioFocusChange(int i) {
        if (i == -1) {
            AudioPlayer.a().g();
        } else if (i == 1) {
            AudioPlayer.a().h();
        }
    }
}
