package com.duokan.reader.ui.reading;

import android.content.Context;
import android.os.Binder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.duokan.p024c.C0255g;

public class afl extends Binder {
    /* renamed from: a */
    final /* synthetic */ TtsNotificationService f9636a;
    /* renamed from: b */
    private final WakeLock f9637b;

    public afl(TtsNotificationService ttsNotificationService, Context context) {
        this.f9636a = ttsNotificationService;
        this.f9637b = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "TTS");
        this.f9637b.setReferenceCounted(false);
    }

    /* renamed from: a */
    public void m13496a() {
        this.f9636a.f9178b.contentView.setViewVisibility(C0255g.reading__tts_notification_view__resume, 8);
        this.f9636a.f9178b.contentView.setViewVisibility(C0255g.reading__tts_notification_view__pause, 0);
        this.f9636a.startForeground(1, this.f9636a.f9178b);
        this.f9637b.acquire();
    }

    /* renamed from: b */
    public void m13497b() {
        this.f9636a.f9178b.contentView.setViewVisibility(C0255g.reading__tts_notification_view__resume, 0);
        this.f9636a.f9178b.contentView.setViewVisibility(C0255g.reading__tts_notification_view__pause, 8);
        this.f9636a.startForeground(1, this.f9636a.f9178b);
        this.f9637b.release();
    }

    /* renamed from: c */
    public void m13498c() {
        this.f9636a.f9178b.contentView.setViewVisibility(C0255g.reading__tts_notification_view__resume, 8);
        this.f9636a.f9178b.contentView.setViewVisibility(C0255g.reading__tts_notification_view__pause, 0);
        this.f9636a.startForeground(1, this.f9636a.f9178b);
        this.f9637b.acquire();
    }

    /* renamed from: d */
    public void m13499d() {
        this.f9636a.stopForeground(true);
        this.f9637b.release();
    }
}
