package com.duokan.reader.ui.reading;

import android.media.AudioManager;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.ag;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.tts.SpeakingListener;

class aea implements SpeakingListener {
    final /* synthetic */ ael a;
    final /* synthetic */ aej b;
    final /* synthetic */ ag c;
    final /* synthetic */ adm d;
    private boolean e = false;

    aea(adm com_duokan_reader_ui_reading_adm, ael com_duokan_reader_ui_reading_ael, aej com_duokan_reader_ui_reading_aej, ag agVar) {
        this.d = com_duokan_reader_ui_reading_adm;
        this.a = com_duokan_reader_ui_reading_ael;
        this.b = com_duokan_reader_ui_reading_aej;
        this.c = agVar;
    }

    public void onSpeakingStart(String str) {
        TaskHandler.postDelayed(new aeb(this), 60000);
        this.d.a.setActiveColorText(this.a.b);
        if (!this.d.a.bh()) {
            if (this.d.a.U() == PageAnimationMode.VSCROLL || this.a.c <= 0) {
                this.d.a.d(this.a.b);
            }
        }
    }

    public void onSpeakingPaused(String str) {
        this.e = true;
        if (!this.d.e()) {
            return;
        }
        if (!((AudioManager) this.d.getContext().getSystemService("audio")).isMusicActive()) {
            this.d.g.resumeSpeaking();
        } else if (this.d.j != null && !this.d.j.e) {
            this.d.j.e = true;
            if (this.d.k != null) {
                this.d.k.d();
            }
            if (this.d.q != null) {
                this.d.q.b();
            }
        }
    }

    public void onSpeakingResumed(String str) {
        this.d.h();
    }

    public void onSpeakingProgress(String str, int i, int i2, int i3) {
        if (!this.d.a.bh() && this.d.a.U() != PageAnimationMode.VSCROLL && this.a.c > 0 && Math.round(((float) this.a.a.length()) * (((float) i) / 100.0f)) > this.a.c) {
            this.d.a.d(this.a.b);
        }
    }

    public void onSpeakingEnd(String str) {
        this.e = true;
        this.d.a.setActiveColorText(null);
        this.b.b.removeFirst();
        this.d.b(this.b, this.c);
    }

    public void onSpeakingCancel(String str) {
        this.e = true;
        this.d.a.setActiveColorText(null);
        ((AudioManager) DkApp.get().getSystemService("audio")).abandonAudioFocus(null);
    }

    public void onSpeakingError(int i, String str) {
        this.e = true;
        this.d.a.setActiveColorText(null);
        a.c().c(LogLevel.ERROR, "tts", String.format("errorCode: %getScaledTouchSlop, errorDesc: %s", new Object[]{Integer.valueOf(i), str}));
        ((AudioManager) DkApp.get().getSystemService("audio")).abandonAudioFocus(null);
    }
}
