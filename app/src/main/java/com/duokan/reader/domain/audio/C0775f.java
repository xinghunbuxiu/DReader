package com.duokan.reader.domain.audio;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.duokan.reader.domain.document.C0930b;

/* renamed from: com.duokan.reader.domain.audio.f */
class C0775f extends Handler {
    /* renamed from: a */
    final /* synthetic */ AudioPlayer f2612a;

    public C0775f(AudioPlayer audioPlayer) {
        this.f2612a = audioPlayer;
        super(Looper.getMainLooper());
    }

    public void handleMessage(Message message) {
        if (this.f2612a.m3641b() && this.f2612a.f2595b != null) {
            long j = 1000;
            int currentPosition = this.f2612a.f2595b.getCurrentPosition();
            if (currentPosition <= 0) {
                this.f2612a.f2605m.sendEmptyMessageDelayed(0, 1000);
                return;
            }
            C0930b a = this.f2612a.m3626b(currentPosition);
            if (a == null) {
                this.f2612a.m3642c();
                this.f2612a.m3636i();
                return;
            }
            if (this.f2612a.f2598e != a) {
                this.f2612a.m3624a(a.mo1443a());
                this.f2612a.f2598e = a;
            } else if (this.f2612a.f2598e != null) {
                j = (long) Math.max(1000, Math.round(1000.0f * this.f2612a.f2598e.mo1445c()) - this.f2612a.f2595b.getCurrentPosition());
            }
            this.f2612a.f2605m.sendEmptyMessageDelayed(0, j);
        }
    }
}
