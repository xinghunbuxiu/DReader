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

import com.duokan.c.d;
import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.ManagedApp;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkMainActivity;

public class TtsNotificationService extends Service {
    private aeu a = new aeu(this, DkApp.get());
    private Notification b;

    public void onCreate() {
        super.onCreate();
        sh b = b();
        if (b == null) {
            stopSelf();
            return;
        }
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, DkMainActivity.class).setAction("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER").addFlags(270532608), 0);
        PendingIntent service = PendingIntent.getService(this, 0, new Intent(this, getClass()).setAction("com.duokan.reader.domain.tts.PAUSE"), 134217728);
        PendingIntent service2 = PendingIntent.getService(this, 0, new Intent(this, getClass()).setAction("com.duokan.reader.domain.tts.RESUME"), 134217728);
        PendingIntent service3 = PendingIntent.getService(this, 0, new Intent(this, getClass()).setAction("com.duokan.reader.domain.tts.STOP"), 134217728);
        RemoteViews remoteViews = new RemoteViews(DkApp.get().getPackageName(), h.reading__tts_notification_view);
        remoteViews.setTextViewText(g.reading__tts_notification_view__title, String.format(DkApp.get().getString(j.general__shared__book_title_marks), new Object[]{b.G().aw()}));
        remoteViews.setTextViewText(g.reading__tts_notification_view__author, String.format(DkApp.get().getString(j.reading__tts_notification_view__author), new Object[]{b.G().B()}));
        remoteViews.setOnClickPendingIntent(g.reading__tts_notification_view__pause, service);
        remoteViews.setOnClickPendingIntent(g.reading__tts_notification_view__resume, service2);
        remoteViews.setOnClickPendingIntent(g.reading__tts_notification_view__close, service3);
        if (a(a())) {
            remoteViews.setTextColor(g.reading__tts_notification_view__title, getResources().getColor(d.reading__tts_notification_view__text_main_dark));
            remoteViews.setTextColor(g.reading__tts_notification_view__author, getResources().getColor(d.reading__tts_notification_view__text_secondary_dark));
            remoteViews.setImageViewResource(g.reading__tts_notification_view__resume, f.reading__tts_notification_view__resume_dark);
            remoteViews.setImageViewResource(g.reading__tts_notification_view__pause, f.reading__tts_notification_view__pause_dark);
            remoteViews.setImageViewResource(g.reading__tts_notification_view__close, f.reading__tts_notification_view__close_dark);
        } else {
            remoteViews.setTextColor(g.reading__tts_notification_view__title, getResources().getColor(d.reading__tts_notification_view__text_main_light));
            remoteViews.setTextColor(g.reading__tts_notification_view__author, getResources().getColor(d.reading__tts_notification_view__text_secondary_light));
            remoteViews.setImageViewResource(g.reading__tts_notification_view__resume, f.reading__tts_notification_view__resume_light);
            remoteViews.setImageViewResource(g.reading__tts_notification_view__pause, f.reading__tts_notification_view__pause_light);
            remoteViews.setImageViewResource(g.reading__tts_notification_view__close, f.reading__tts_notification_view__close_light);
        }
        this.b = new Builder(DkApp.get()).setTicker(b.G().aw()).setContentTitle(b.G().aw()).setContentText(b.G().B()).setSmallIcon(f.mipush_small_notification).setContent(remoteViews).setContentIntent(activity).setOngoing(true).build();
    }

    private boolean a(int i) {
        return ((0.299d * ((double) Color.red(i))) + (0.587d * ((double) Color.green(i)))) + (0.114d * ((double) Color.blue(i))) < 186.0d;
    }

    private int a() {
        try {
            return ((TextView) ((ViewGroup) new Builder(this).build().contentView.apply(this, new LinearLayout(this))).findViewById(16908310)).getCurrentTextColor();
        } catch (Throwable th) {
            return getResources().getColor(17170444);
        }
    }

    private sh b() {
        return (sh) ManagedApp.get().queryFeature(sh.class);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            CharSequence action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                sh b = b();
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
        return this.a;
    }

    public boolean onUnbind(Intent intent) {
        stopSelf();
        return super.onUnbind(intent);
    }
}
