package com.duokan.reader.ui.reading;

import android.content.Context;
import android.os.Binder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

import com.duokan.c.g;

public class aeu extends Binder {
    final /* synthetic */ TtsNotificationService a;
    private final WakeLock b;

    public aeu(TtsNotificationService ttsNotificationService, Context context) {
        this.a = ttsNotificationService;
        this.b = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "TTS");
        this.b.setReferenceCounted(false);
    }

    public void a() {
        this.a.b.contentView.setViewVisibility(g.reading__tts_notification_view__resume, 8);
        this.a.b.contentView.setViewVisibility(g.reading__tts_notification_view__pause, 0);
        this.a.startForeground(1, this.a.b);
        this.b.acquire();
    }

    public void b() {
        this.a.b.contentView.setViewVisibility(g.reading__tts_notification_view__resume, 0);
        this.a.b.contentView.setViewVisibility(g.reading__tts_notification_view__pause, 8);
        this.a.startForeground(1, this.a.b);
        this.b.release();
    }

    public void c() {
        this.a.b.contentView.setViewVisibility(g.reading__tts_notification_view__resume, 8);
        this.a.b.contentView.setViewVisibility(g.reading__tts_notification_view__pause, 0);
        this.a.startForeground(1, this.a.b);
        this.b.acquire();
    }

    public void d() {
        this.a.stopForeground(true);
        this.b.release();
    }
}
