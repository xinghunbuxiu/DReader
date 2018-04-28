package com.duokan.reader.ui.reading;

import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.document.bb;

class af implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ae f9611a;

    af(ae aeVar) {
        this.f9611a = aeVar;
    }

    public void run() {
        UmengManager.get().onEvent("V2_READING_PRONOUNCE", "BackTo");
        bb e = AudioPlayer.m3613a().m3644e();
        if (e != null) {
            this.f9611a.f9560a.f9370a.mo2131d(e);
        }
    }
}
