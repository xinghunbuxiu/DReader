package com.duokan.reader.domain.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

import com.duokan.reader.domain.audio.AudioPlayer.PlayerStatus;
import com.duokan.reader.domain.document.b;

class d implements OnPreparedListener {
    final /* synthetic */ b a;
    final /* synthetic */ AudioPlayer b;

    d(AudioPlayer audioPlayer, b bVar) {
        this.b = audioPlayer;
        this.a = bVar;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.b.a(PlayerStatus.PLAYING);
        this.b.b.seekTo(Math.round(1000.0f * this.a.b()));
        this.b.b.start();
    }
}
