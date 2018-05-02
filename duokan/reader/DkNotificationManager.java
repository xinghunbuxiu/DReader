package com.duokan.reader;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

import com.duokan.core.app.ah;
import com.duokan.core.app.ai;

public class DkNotificationManager implements ah {
    private static final ai a = new ai();
    private final Context b;
    private final NotificationManager c;
    private boolean d = true;

    private DkNotificationManager(Context context) {
        this.b = context;
        this.c = (NotificationManager) this.b.getSystemService("notification");
    }

    public static void startup(Context context) {
        a.a(new DkNotificationManager(context));
    }

    public static DkNotificationManager get() {
        return (DkNotificationManager) a.a();
    }

    public void cancel(String str, int i) {
        this.c.cancel(str, i);
    }

    public void notify(String str, int i, Notification notification) {
        try {
            if (this.d) {
                this.c.notify(str, i, notification);
            }
        } catch (Exception e) {
        }
    }
}
