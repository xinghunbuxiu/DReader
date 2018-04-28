package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.audio.AudioPlayer;

class ad implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ab f9498a;

    ad(ab abVar) {
        this.f9498a = abVar;
    }

    public void onClick(View view) {
        if (AudioPlayer.m3613a().m3641b()) {
            UmengManager.get().onEvent("V2_READING_PRONOUNCE", "Pause");
            this.f9498a.f9370a.mo2156i();
        }
        this.f9498a.requestHideMenu();
    }
}
