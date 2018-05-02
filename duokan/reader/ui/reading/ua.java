package com.duokan.reader.ui.reading;

import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.bookshelf.BookContent;

class ua implements Runnable {
    final /* synthetic */ tz a;

    ua(tz tzVar) {
        this.a = tzVar;
    }

    public void run() {
        if (this.a.a.a.G().r() != BookContent.AUDIO_TEXT) {
            this.a.a.a.aX();
        } else if (AudioPlayer.a().b()) {
            UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Pron-Pause");
            this.a.a.a.i();
        } else {
            UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Pron-Start");
            this.a.a.a.a(this.a.a.a.Z(), false);
        }
    }
}
