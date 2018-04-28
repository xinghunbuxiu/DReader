package com.duokan.reader.ui.reading;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

class adw implements OnPreparedListener {
    /* renamed from: a */
    final /* synthetic */ TranslationController f9540a;

    adw(TranslationController translationController) {
        this.f9540a = translationController;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f9540a.f9174h.start();
    }
}
