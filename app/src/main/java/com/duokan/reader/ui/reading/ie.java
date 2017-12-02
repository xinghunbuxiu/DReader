package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.audio.AudioPlayer;

class ie implements OnClickListener {
    final /* synthetic */ hq a;

    ie(hq hqVar) {
        this.a = hqVar;
    }

    public void onClick(View view) {
        if (AudioPlayer.a().b()) {
            UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Pron-Pause");
            this.a.f.i();
        } else {
            UmengManager.get().onEvent("V2_READING_TOP_TOOLBUTTON", "Pron-Start");
            this.a.f.a(this.a.f.Z(), false);
        }
        this.a.requestDetach();
    }
}
