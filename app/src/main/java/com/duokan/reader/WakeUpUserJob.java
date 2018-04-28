package com.duokan.reader;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.app.NotificationCompat.Builder;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0247i;
import com.duokan.reader.domain.job.C0494a;
import com.duokan.reader.domain.job.JobInfo;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class WakeUpUserJob extends C0494a {
    /* renamed from: a */
    private Context f1668a = null;
    /* renamed from: b */
    private SharedPreferences f1669b = null;

    public void exec(Context context, JobInfo jobInfo) {
        this.f1668a = context;
        this.f1669b = context.getSharedPreferences("wakeup", 0);
        Calendar instance = Calendar.getInstance(TimeZone.getDefault());
        if (instance.get(11) < 22) {
            if (DkApp.get().getUserFirstActiveTime() != 0 || !wakeUpUser(0, C0247i.general__shared__0day_wakeup_title, C0247i.general__shared__0day_wakeup_msg, C0247i.general__shared__0day_wakeup_uri)) {
                long max = Math.max(0, instance.getTimeInMillis() - DkApp.get().getUserLastActiveTime());
                if ((max > TimeUnit.DAYS.toMillis(1) && wakeUpUser(1, C0247i.general__shared__1day_wakeup_title, C0247i.general__shared__1day_wakeup_msg, C0247i.general__shared__1day_wakeup_uri)) || max <= TimeUnit.DAYS.toMillis(7) || !wakeUpUser(7, C0247i.general__shared__7day_wakeup_title, C0247i.general__shared__7day_wakeup_msg, C0247i.general__shared__7day_wakeup_uri)) {
                }
            }
        }
    }

    private boolean wakeUpUser(int i, int i2, int i3, int i4) {
        String str = i + "day_wakeup_done";
        if (this.f1669b.contains(str)) {
            return false;
        }
        Intent intent = new Intent(this.f1668a, DkApp.get().getReaderActivityClass());
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(this.f1668a.getString(i4)));
        intent.setFlags(268468224);
        Builder builder = new Builder(this.f1668a);
        builder.setSmallIcon(C0243e.mipush_small_notification);
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle(this.f1668a.getString(i2));
        builder.setTicker(this.f1668a.getString(i2));
        builder.setContentText(this.f1668a.getString(i3));
        builder.setDefaults(-1);
        builder.setAutoCancel(true);
        builder.setContentIntent(PendingIntent.getActivity(this.f1668a, 0, intent, 268435456));
        ((NotificationManager) this.f1668a.getSystemService("notification")).notify(getClass().getName(), i, builder.build());
        this.f1669b.edit().putBoolean(str, true).apply();
        return true;
    }
}
