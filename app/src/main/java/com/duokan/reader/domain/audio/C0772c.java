package com.duokan.reader.domain.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

/* renamed from: com.duokan.reader.domain.audio.c */
class C0772c implements OnCompletionListener {
    /* renamed from: a */
    final /* synthetic */ AudioPlayer f2609a;

    C0772c(AudioPlayer audioPlayer) {
        this.f2609a = audioPlayer;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f2609a.m3636i();
    }
}
