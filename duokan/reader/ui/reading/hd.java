package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.audio.AudioPlayer.PlayerStatus;
import com.duokan.reader.domain.audio.e;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.b;
import com.duokan.reader.domain.document.bb;
import com.duokan.reader.domain.document.g;

class hd implements e {
    final /* synthetic */ hc a;

    hd(hc hcVar) {
        this.a = hcVar;
    }

    public void a(PlayerStatus playerStatus) {
        if (playerStatus == PlayerStatus.IDLE || playerStatus == PlayerStatus.PAUSE) {
            this.a.a.c.setActiveColorText(null);
            this.a.a.c.a(0, 16);
            return;
        }
        this.a.a.c.a(16, 0);
    }

    public void a(bb bbVar) {
        int i = 0;
        this.a.a.c.a(16, 0);
        this.a.a.c.setActiveColorText(bbVar);
        ak Z = this.a.a.c.Z();
        if (this.a.a.c.aT() || !(Z == null || Z.c() || this.a.a.J == null || !Z.b(this.a.a.J))) {
            i = 1;
        }
        if (i != 0) {
            this.a.a.c.d(bbVar);
        }
        this.a.a.J = bbVar;
    }

    public void a(int i) {
        g[] b = this.a.a.h.h().b();
        int i2 = i + 1;
        while (i2 < b.length) {
            b[] a = this.a.a.d(i2);
            if (a == null || a.length <= 0) {
                i2++;
            } else {
                AudioPlayer.a().a(a, Integer.valueOf(i2), this.a.a.n().aF());
                AudioPlayer.a().a(a[0].a(), new Integer[]{Integer.valueOf(i2)});
                return;
            }
        }
        this.a.a.J = null;
    }
}
