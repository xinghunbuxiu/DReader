package com.duokan.reader;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.app.NotificationCompat.Builder;

import com.duokan.b.e;
import com.duokan.b.i;
import com.duokan.reader.domain.job.JobInfo;
import com.duokan.reader.domain.job.a;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class WakeUpUserJob extends a {
    private Context a = null;
    private SharedPreferences b = null;

    public void exec(Context context, JobInfo jobInfo) {
        this.a = context;
        this.b = context.getSharedPreferences("wakeup", 0);
        Calendar instance = Calendar.getInstance(TimeZone.getDefault());
        if (instance.get(11) < 22) {
            if (DkApp.get().getUserFirstActiveTime() != 0 || !wakeUpUser(0, i.general__shared__0day_wakeup_title, i.general__shared__0day_wakeup_msg, i.general__shared__0day_wakeup_uri)) {
                long max = Math.max(0, instance.getTimeInMillis() - DkApp.get().getUserLastActiveTime());
                if ((max > TimeUnit.DAYS.toMillis(1) && wakeUpUser(1, i.general__shared__1day_wakeup_title, i.general__shared__1day_wakeup_msg, i.general__shared__1day_wakeup_uri)) || max <= TimeUnit.DAYS.toMillis(7) || !wakeUpUser(7, i.general__shared__7day_wakeup_title, i.general__shared__7day_wakeup_msg, i.general__shared__7day_wakeup_uri)) {
                }
            }
        }
    }

    private boolean wakeUpUser(int i, int i2, int i3, int i4) {
        String str = i + "day_wakeup_done";
        if (this.b.contains(str)) {
            return false;
        }
        Intent intent = new Intent(this.a, DkApp.get().getReaderActivityClass());
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(this.a.getString(i4)));
        intent.setFlags(268468224);
        Builder builder = new Builder(this.a);
        builder.setSmallIcon(e.mipush_small_notification);
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle(this.a.getString(i2));
        builder.setTicker(this.a.getString(i2));
        builder.setContentText(this.a.getString(i3));
        builder.setDefaults(-1);
        builder.setAutoCancel(true);
        builder.setContentIntent(PendingIntent.getActivity(this.a, 0, intent, 268435456));
        ((NotificationManager) this.a.getSystemService("notification")).notify(getClass().getName(), i, builder.build());
        this.b.edit().putBoolean(str, true).apply();
        return true;
    }
}
