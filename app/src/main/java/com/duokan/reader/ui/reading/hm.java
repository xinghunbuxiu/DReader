package com.duokan.reader.ui.reading;

import android.content.Intent;
import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.audio.AudioPlayerService;

class hm implements Runnable {
    /* renamed from: a */
    final /* synthetic */ hl f10342a;

    hm(hl hlVar) {
        this.f10342a = hlVar;
    }

    public void run() {
        this.f10342a.getContext().startService(new Intent(this.f10342a.getContext(), AudioPlayerService.class));
        this.f10342a.f10333L = new hn(this);
        AudioPlayer.m3613a().m3637a(this.f10342a.f10333L);
    }
}
