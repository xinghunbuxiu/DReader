package com.duokan.reader.domain.audio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;

/* renamed from: com.duokan.reader.domain.audio.b */
class C0771b implements OnSeekCompleteListener {
    /* renamed from: a */
    final /* synthetic */ AudioPlayer f2608a;

    C0771b(AudioPlayer audioPlayer) {
        this.f2608a = audioPlayer;
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.f2608a.f2605m.sendEmptyMessage(0);
    }
}
