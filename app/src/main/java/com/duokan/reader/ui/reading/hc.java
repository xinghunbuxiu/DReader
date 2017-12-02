package com.duokan.reader.ui.reading;

import android.content.Intent;

import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.audio.AudioPlayerService;

class hc implements Runnable {
    final /* synthetic */ hb a;

    hc(hb hbVar) {
        this.a = hbVar;
    }

    public void run() {
        this.a.getContext().startService(new Intent(this.a.getContext(), AudioPlayerService.class));
        this.a.L = new hd(this);
        AudioPlayer.a().a(this.a.L);
    }
}
