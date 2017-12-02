package com.duokan.reader.domain.cloud;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;

import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.t;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.c.f;
import com.duokan.reader.common.c.g;
import com.duokan.reader.common.webservices.duokan.DkSignInReward;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.push.MessageWakeupListener;
import com.duokan.reader.domain.cloud.push.MessageWakeupListener.MessageSubType;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class gn implements ah, g, MessageWakeupListener {
    private static final ai a = new ai();
    private final Context b;
    private final i c;
    private final LinkedList d = new LinkedList();
    private int e = 0;

    private gn(Context context, i iVar) {
        this.b = context;
        this.c = iVar;
        DkApp.get().runWhenAppReady(new go(this));
    }

    public static void a(Context context, i iVar) {
        a.a(new gn(context, iVar));
    }

    public static gn a() {
        return (gn) a.a();
    }

    public void a(gs gsVar) {
        this.d.add(gsVar);
    }

    public void b(gs gsVar) {
        this.d.remove(gsVar);
    }

    public void onConnectivityChanged(f fVar) {
    }

    public void a(MessageSubType messageSubType, Object obj, boolean z) {
        int i = 0;
        if (messageSubType == MessageSubType.USER_TASK) {
            c();
        } else if (messageSubType == MessageSubType.RESIGN_SUCCEED && obj != null && !PersonalPrefs.a().r()) {
            a.c().c(LogLevel.EVENT, "resign_event", "resign_pass_through");
            try {
                JSONArray jSONArray = new JSONArray((String) obj);
                if (DkApp.get().getRunningState() == RunningState.FOREGROUND) {
                    a.c().c(LogLevel.EVENT, "resign_event", "pass_through_on_foreground");
                    List arrayList = new ArrayList();
                    while (i < jSONArray.length()) {
                        DkSignInReward dkSignInReward = new DkSignInReward();
                        dkSignInReward.mName = String.valueOf(jSONArray.getJSONObject(i).optString("name"));
                        dkSignInReward.mValue = String.valueOf(jSONArray.getJSONObject(i).optInt("value"));
                        arrayList.add(dkSignInReward);
                        i++;
                    }
                    t.a(new gp(this, arrayList));
                } else {
                    a.c().c(LogLevel.EVENT, "resign_event", "pass_through_on_background");
                    String str = "";
                    int i2 = 0;
                    while (i2 < jSONArray.length()) {
                        String str2 = (str + "," + String.valueOf(jSONArray.getJSONObject(i2).optInt("value"))) + String.valueOf(jSONArray.getJSONObject(i2).optString("name"));
                        i2++;
                        str = str2;
                    }
                    t.a(new gq(this));
                    if (!TextUtils.isEmpty(str)) {
                        str = str.substring(1);
                    }
                    b(str);
                }
                PersonalPrefs.a().f(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if (messageSubType == MessageSubType.RECHARGE_SUCCEED && obj != null) {
            try {
                JSONArray jSONArray2 = new JSONArray((String) obj);
                String str3 = "";
                while (i < jSONArray2.length()) {
                    str3 = (str3 + "," + String.valueOf(jSONArray2.getJSONObject(i).optInt("value"))) + String.valueOf(jSONArray2.getJSONObject(i).optString("name"));
                    i++;
                }
                c(str3.substring(1));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public void a(String str) {
        new gr(this, str).open();
    }

    public int b() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((gs) it.next()).c();
        }
    }

    public void b(String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            string = this.b.getString(com.duokan.b.i.personal__resign_notification_content);
        } else {
            string = this.b.getString(com.duokan.b.i.personal__resign_notification_content_reward) + str;
        }
        a("duokan-reader://personal/coupons", this.b.getString(com.duokan.b.i.personal__resign_notification_title), string, this.b.getString(com.duokan.b.i.personal__resign_notification_ticker));
    }

    private void c() {
        if (!ReaderEnv.get().getPrefBoolean(PrivatePref.PERSONAL, "is_in_task_page", false)) {
            a(b() + 1);
            a("duokan-reader://personal/task", this.b.getString(com.duokan.b.i.personal__task_notification_title), this.b.getString(com.duokan.b.i.personal__task_notification_content), this.b.getString(com.duokan.b.i.personal__task_notification_ticker));
        }
    }

    private void c(String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            string = this.b.getString(com.duokan.b.i.personal__recharge_notification_content);
        } else {
            string = String.format(this.b.getString(com.duokan.b.i.personal__recharge_notification_content_reward), new Object[]{str});
        }
        a("duokan-reader://personal/coupons", this.b.getString(com.duokan.b.i.personal__recharge_notification_title), string, this.b.getString(com.duokan.b.i.personal__recharge_notification_ticker));
    }

    private void a(String str, String str2, String str3, String str4) {
        String str5 = "task_notification";
        ((NotificationManager) this.b.getSystemService("notification")).notify(str5, 1, new Builder(DkApp.get()).setContentTitle(str2).setContentText(str3).setTicker(str4).setSmallIcon(e.mipush_small_notification).setDefaults(1).setWhen(System.currentTimeMillis()).setContentIntent(PendingIntent.getActivity(this.b, 0, new Intent(this.b, DkApp.get().getReaderActivityClass()).setAction("android.intent.action.VIEW").setData(Uri.parse(str)).addCategory("android.intent.category.LAUNCHER").addFlags(268468224), 134217728)).setAutoCancel(true).build());
    }
}
