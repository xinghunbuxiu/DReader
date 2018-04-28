package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.audio.AudioPlayer.PlayerStatus;
import com.duokan.reader.domain.audio.C0774e;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.C0930b;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.bb;

class hn implements C0774e {
    /* renamed from: a */
    final /* synthetic */ hm f10343a;

    hn(hm hmVar) {
        this.f10343a = hmVar;
    }

    /* renamed from: a */
    public void mo2276a(PlayerStatus playerStatus) {
        if (playerStatus == PlayerStatus.IDLE || playerStatus == PlayerStatus.PAUSE) {
            this.f10343a.f10342a.c.setActiveColorText(null);
            this.f10343a.f10342a.c.mo2040a(0, 16);
            return;
        }
        this.f10343a.f10342a.c.mo2040a(16, 0);
    }

    /* renamed from: a */
    public void mo2277a(bb bbVar) {
        int i = 0;
        this.f10343a.f10342a.c.mo2040a(16, 0);
        this.f10343a.f10342a.c.setActiveColorText(bbVar);
        ak Z = this.f10343a.f10342a.c.mo2009Z();
        if (this.f10343a.f10342a.c.aT() || !(Z == null || Z.mo1189c() || this.f10343a.f10342a.f10331J == null || !Z.m5814b(this.f10343a.f10342a.f10331J))) {
            i = 1;
        }
        if (i != 0) {
            this.f10343a.f10342a.c.mo2131d(bbVar);
        }
        this.f10343a.f10342a.f10331J = bbVar;
    }

    /* renamed from: a */
    public void mo2275a(int i) {
        C0901g[] b = this.f10343a.f10342a.h.mo1240h().mo1268b();
        int i2 = i + 1;
        while (i2 < b.length) {
            C0930b[] a = this.f10343a.f10342a.m14340d(i2);
            if (a == null || a.length <= 0) {
                i2++;
            } else {
                AudioPlayer.m3613a().m3639a(a, Integer.valueOf(i2), this.f10343a.f10342a.m12849n().aH());
                AudioPlayer.m3613a().m3638a(a[0].mo1443a(), new Integer[]{Integer.valueOf(i2)});
                return;
            }
        }
        this.f10343a.f10342a.f10331J = null;
    }
}
