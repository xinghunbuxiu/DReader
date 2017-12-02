package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.audio.AudioPlayer;

class ad implements OnClickListener {
    final /* synthetic */ ab a;

    ad(ab abVar) {
        this.a = abVar;
    }

    public void onClick(View view) {
        if (AudioPlayer.a().b()) {
            UmengManager.get().onEvent("V2_READING_PRONOUNCE", "Pause");
            this.a.a.i();
        }
        this.a.requestHideMenu();
    }
}
