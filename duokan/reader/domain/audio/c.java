package com.duokan.reader.domain.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class c implements OnCompletionListener {
    final /* synthetic */ AudioPlayer a;

    c(AudioPlayer audioPlayer) {
        this.a = audioPlayer;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.a.i();
    }
}
