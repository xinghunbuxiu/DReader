package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.document.ay;

class hp implements Runnable {
    /* renamed from: a */
    final /* synthetic */ hl f10345a;

    hp(hl hlVar) {
        this.f10345a = hlVar;
    }

    public void run() {
        if (!this.f10345a.q && this == this.f10345a.f10332K) {
            ay Z = this.f10345a.c.mo2009Z();
            ay e = AudioPlayer.m3613a().m3644e();
            this.f10345a.f10332K = null;
            if (Z == null || e == null) {
                this.f10345a.c.aV();
            } else if (Z.m5814b(e)) {
                this.f10345a.c.aV();
            } else {
                if (AudioPlayer.m3613a().m3641b()) {
                    this.f10345a.c.mo2025a(Z, false);
                }
                this.f10345a.c.aV();
            }
        }
    }
}
