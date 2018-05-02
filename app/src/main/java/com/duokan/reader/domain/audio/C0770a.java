package com.duokan.reader.domain.audio;

import android.media.AudioManager.OnAudioFocusChangeListener;

/* renamed from: com.duokan.reader.domain.audio.a */
class C0770a implements OnAudioFocusChangeListener {
    /* renamed from: a */
    final /* synthetic */ AudioPlayer f2607a;

    C0770a(AudioPlayer audioPlayer) {
        this.f2607a = audioPlayer;
    }

    public void onAudioFocusChange(int i) {
        if (i == -1) {
            AudioPlayer.m3613a().m3634g();
        } else if (i == 1) {
            AudioPlayer.m3613a().m3635h();
        }
    }
}
