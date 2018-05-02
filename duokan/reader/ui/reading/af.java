package com.duokan.reader.ui.reading;

import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.document.bb;

class af implements Runnable {
    final /* synthetic */ ae a;

    af(ae aeVar) {
        this.a = aeVar;
    }

    public void run() {
        UmengManager.get().onEvent("V2_READING_PRONOUNCE", "BackTo");
        bb e = AudioPlayer.a().e();
        if (e != null) {
            this.a.a.a.d(e);
        }
    }
}
