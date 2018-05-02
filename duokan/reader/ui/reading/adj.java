package com.duokan.reader.ui.reading;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

class adj implements OnPreparedListener {
    final /* synthetic */ TranslationController a;

    adj(TranslationController translationController) {
        this.a = translationController;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.a.h.start();
    }
}
