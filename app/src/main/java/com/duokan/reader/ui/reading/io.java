package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.audio.AudioPlayer;

class io implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ia f10394a;

    io(ia iaVar) {
        this.f10394a = iaVar;
    }

    public void onClick(View view) {
        if (AudioPlayer.m3613a().m3641b()) {
            UmengManager.get().onEvent("V2_READING_MENU", "Pron-Pause");
            this.f10394a.f.mo2156i();
        } else {
            UmengManager.get().onEvent("V2_READING_MENU", "Pron-Start");
            this.f10394a.f.mo2025a(this.f10394a.f.mo2009Z(), false);
        }
        this.f10394a.requestDetach();
    }
}
