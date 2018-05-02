package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.document.ay;

class hf implements Runnable {
    final /* synthetic */ hb a;

    hf(hb hbVar) {
        this.a = hbVar;
    }

    public void run() {
        if (!this.a.q && this == this.a.K) {
            ay Z = this.a.c.Z();
            ay e = AudioPlayer.a().e();
            this.a.K = null;
            if (Z == null || e == null) {
                this.a.c.aV();
            } else if (Z.b(e)) {
                this.a.c.aV();
            } else {
                if (AudioPlayer.a().b()) {
                    this.a.c.a(Z, false);
                }
                this.a.c.aV();
            }
        }
    }
}
