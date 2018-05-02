package com.duokan.reader.domain.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.duokan.reader.domain.audio.AudioPlayer.PlayerStatus;
import com.duokan.reader.domain.document.C0930b;

/* renamed from: com.duokan.reader.domain.audio.d */
class C0773d implements OnPreparedListener {
    /* renamed from: a */
    final /* synthetic */ C0930b f2610a;
    /* renamed from: b */
    final /* synthetic */ AudioPlayer f2611b;

    C0773d(AudioPlayer audioPlayer, C0930b c0930b) {
        this.f2611b = audioPlayer;
        this.f2610a = c0930b;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f2611b.m3619a(PlayerStatus.PLAYING);
        this.f2611b.f2595b.seekTo(Math.round(1000.0f * this.f2610a.mo1444b()));
        this.f2611b.f2595b.start();
    }
}
