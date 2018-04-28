package com.duokan.reader.ui.reading;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.duokan.core.app.ManagedApp;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkMainActivity;

public class TtsNotificationService extends Service {
    /* renamed from: a */
    private afl f9177a = new afl(this, DkApp.get());
    /* renamed from: b */
    private Notification f9178b;

    public void onCreate() {
        super.onCreate();
        su b = m12615b();
        if (b == null) {
            stopSelf();
            return;
        }
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, DkMainActivity.class).setAction("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER").addFlags(270532608), 0);
        PendingIntent service = PendingIntent.getService(this, 0, new Intent(this, getClass()).setAction("com.duokan.reader.domain.tts.PAUSE"), 134217728);
        PendingIntent service2 = PendingIntent.getService(this, 0, new Intent(this, getClass()).setAction("com.duokan.reader.domain.tts.RESUME"), 134217728);
        PendingIntent service3 = PendingIntent.getService(this, 0, new Intent(this, getClass()).setAction("com.duokan.reader.domain.tts.STOP"), 134217728);
        RemoteViews remoteViews = new RemoteViews(DkApp.get().getPackageName(), C0256h.reading__tts_notification_view);
        remoteViews.setTextViewText(C0255g.reading__tts_notification_view__title, String.format(DkApp.get().getString(C0258j.general__shared__book_title_marks), new Object[]{b.mo1992G().ay()}));
        remoteViews.setTextViewText(C0255g.reading__tts_notification_view__author, String.format(DkApp.get().getString(C0258j.reading__tts_notification_view__author), new Object[]{b.mo1992G().m4150C()}));
        remoteViews.setOnClickPendingIntent(C0255g.reading__tts_notification_view__pause, service);
        remoteViews.setOnClickPendingIntent(C0255g.reading__tts_notification_view__resume, service2);
        remoteViews.setOnClickPendingIntent(C0255g.reading__tts_notification_view__close, service3);
        if (m12614a(m12612a())) {
            remoteViews.setTextColor(C0255g.reading__tts_notification_view__title, getResources().getColor(C0252d.reading__tts_notification_view__text_main_dark));
            remoteViews.setTextColor(C0255g.reading__tts_notification_view__author, getResources().getColor(C0252d.reading__tts_notification_view__text_secondary_dark));
            remoteViews.setImageViewResource(C0255g.reading__tts_notification_view__resume, C0254f.reading__tts_notification_view__resume_dark);
            remoteViews.setImageViewResource(C0255g.reading__tts_notification_view__pause, C0254f.reading__tts_notification_view__pause_dark);
            remoteViews.setImageViewResource(C0255g.reading__tts_notification_view__close, C0254f.reading__tts_notification_view__close_dark);
        } else {
            remoteViews.setTextColor(C0255g.reading__tts_notification_view__title, getResources().getColor(C0252d.reading__tts_notification_view__text_main_light));
            remoteViews.setTextColor(C0255g.reading__tts_notification_view__author, getResources().getColor(C0252d.reading__tts_notification_view__text_secondary_light));
            remoteViews.setImageViewResource(C0255g.reading__tts_notification_view__resume, C0254f.reading__tts_notification_view__resume_light);
            remoteViews.setImageViewResource(C0255g.reading__tts_notification_view__pause, C0254f.reading__tts_notification_view__pause_light);
            remoteViews.setImageViewResource(C0255g.reading__tts_notification_view__close, C0254f.reading__tts_notification_view__close_light);
        }
        this.f9178b = new Builder(DkApp.get()).setTicker(b.mo1992G().ay()).setContentTitle(b.mo1992G().ay()).setContentText(b.mo1992G().m4150C()).setSmallIcon(C0254f.mipush_small_notification).setContent(remoteViews).setContentIntent(activity).setOngoing(true).build();
    }

    /* renamed from: a */
    private boolean m12614a(int i) {
        return ((0.299d * ((double) Color.red(i))) + (0.587d * ((double) Color.green(i)))) + (0.114d * ((double) Color.blue(i))) < 186.0d;
    }

    /* renamed from: a */
    private int m12612a() {
        try {
            return ((TextView) ((ViewGroup) new Builder(this).build().contentView.apply(this, new LinearLayout(this))).findViewById(16908310)).getCurrentTextColor();
        } catch (Throwable th) {
            return getResources().getColor(17170444);
        }
    }

    /* renamed from: b */
    private su m12615b() {
        return (su) ManagedApp.get().queryFeature(su.class);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            CharSequence action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                su b = m12615b();
                if (b == null) {
                    stopSelf();
                } else if (TextUtils.equals(action, "com.duokan.reader.domain.tts.START")) {
                    b.aX();
                } else if (TextUtils.equals(action, "com.duokan.reader.domain.tts.PAUSE")) {
                    b.ba();
                } else if (TextUtils.equals(action, "com.duokan.reader.domain.tts.RESUME")) {
                    b.aZ();
                } else if (TextUtils.equals(action, "com.duokan.reader.domain.tts.STOP")) {
                    b.aY();
                }
            }
        }
        return 2;
    }

    public IBinder onBind(Intent intent) {
        return this.f9177a;
    }

    public boolean onUnbind(Intent intent) {
        stopSelf();
        return super.onUnbind(intent);
    }
}
