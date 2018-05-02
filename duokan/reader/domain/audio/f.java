package com.duokan.reader.domain.audio;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.duokan.reader.domain.document.b;

import miuipub.date.Calendar;

class f extends Handler {
    final /* synthetic */ AudioPlayer a;

    public f(AudioPlayer audioPlayer) {
        this.a = audioPlayer;
        super(Looper.getMainLooper());
    }

    public void handleMessage(Message message) {
        if (this.a.b() && this.a.b != null) {
            long j = 1000;
            int currentPosition = this.a.b.getCurrentPosition();
            if (currentPosition <= 0) {
                this.a.m.sendEmptyMessageDelayed(0, 1000);
                return;
            }
            b a = this.a.b(currentPosition);
            if (a == null) {
                this.a.c();
                this.a.i();
                return;
            }
            if (this.a.e != a) {
                this.a.a(a.a());
                this.a.e = a;
            } else if (this.a.e != null) {
                j = (long) Math.max(Calendar.MILLISECOND_OF_SECOND, Math.round(1000.0f * this.a.e.c()) - this.a.b.getCurrentPosition());
            }
            this.a.m.sendEmptyMessageDelayed(0, j);
        }
    }
}
