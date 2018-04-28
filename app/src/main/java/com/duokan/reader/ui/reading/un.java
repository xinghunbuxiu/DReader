package com.duokan.reader.ui.reading;

import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.bookshelf.BookContent;

class un implements Runnable {
    /* renamed from: a */
    final /* synthetic */ um f11017a;

    un(um umVar) {
        this.f11017a = umVar;
    }

    public void run() {
        if (this.f11017a.f11016a.f11013a.mo1992G().m4246r() != BookContent.AUDIO_TEXT) {
            this.f11017a.f11016a.f11013a.aX();
        } else if (AudioPlayer.m3613a().m3641b()) {
            UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Pron-Pause");
            this.f11017a.f11016a.f11013a.mo2156i();
        } else {
            UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Pron-Start");
            this.f11017a.f11016a.f11013a.mo2025a(this.f11017a.f11016a.f11013a.mo2009Z(), false);
        }
    }
}
