package com.duokan.reader.domain.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;

class b implements OnSeekCompleteListener {
    final /* synthetic */ AudioPlayer a;

    b(AudioPlayer audioPlayer) {
        this.a = audioPlayer;
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.a.m.sendEmptyMessage(0);
    }
}
