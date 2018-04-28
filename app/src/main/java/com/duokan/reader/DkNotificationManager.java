package com.duokan.reader;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;

public class DkNotificationManager implements ai {
    /* renamed from: a */
    private static final aj<DkNotificationManager> f1399a = new aj();
    /* renamed from: b */
    private final Context f1400b;
    /* renamed from: c */
    private final NotificationManager f1401c;
    /* renamed from: d */
    private boolean f1402d = true;

    private DkNotificationManager(Context context) {
        this.f1400b = context;
        this.f1401c = (NotificationManager) this.f1400b.getSystemService("notification");
    }

    public static void startup(Context context) {
        f1399a.m709a(new DkNotificationManager(context));
    }

    public static DkNotificationManager get() {
        return (DkNotificationManager) f1399a.m707a();
    }

    public void cancel(String str, int i) {
        this.f1401c.cancel(str, i);
    }

    public void notify(String str, int i, Notification notification) {
        try {
            if (this.f1402d) {
                this.f1401c.notify(str, i, notification);
            }
        } catch (Exception e) {
        }
    }
}
