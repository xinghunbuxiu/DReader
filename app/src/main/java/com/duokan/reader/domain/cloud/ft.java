package com.duokan.reader.domain.cloud;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UThread;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.common.webservices.duokan.DkSignInReward;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.cloud.push.MessageWakeupListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public class ft implements ai, MessageWakeupListener {
    /* renamed from: a */
    private static final aj<ft> f4014a = new aj();
    /* renamed from: b */
    private final Context f4015b;
    /* renamed from: c */
    private final C0709k f4016c;
    /* renamed from: d */
    private final LinkedList<fy> f4017d = new LinkedList();
    /* renamed from: e */
    private int f4018e = 0;

    private ft(Context context, C0709k c0709k) {
        this.f4015b = context;
        this.f4016c = c0709k;
        DkApp.get().runWhenAppReady(new fu(this));
    }

    /* renamed from: a */
    public static void m5576a(Context context, C0709k c0709k) {
        f4014a.m709a(new ft(context, c0709k));
    }

    /* renamed from: a */
    public static ft m5575a() {
        return (ft) f4014a.m707a();
    }

    /* renamed from: a */
    public void m5581a(fy fyVar) {
        this.f4017d.add(fyVar);
    }

    /* renamed from: b */
    public void m5585b(fy fyVar) {
        this.f4017d.remove(fyVar);
    }

    /* renamed from: a */
    public void mo785a(MessageSubType messageSubType, Object obj, boolean z) {
        int i = 0;
        if (messageSubType == MessageSubType.USER_TASK) {
            m5578c();
        } else if (messageSubType == MessageSubType.RESIGN_SUCCEED && obj != null && !PersonalPrefs.m5175a().m5242r()) {
            C0328a.m757c().m752c(LogLevel.EVENT, "resign_event", "resign_pass_through");
            try {
                JSONArray jSONArray = new JSONArray((String) obj);
                if (DkApp.get().getRunningState() == RunningState.FOREGROUND) {
                    C0328a.m757c().m752c(LogLevel.EVENT, "resign_event", "pass_through_on_foreground");
                    List arrayList = new ArrayList();
                    while (i < jSONArray.length()) {
                        DkSignInReward dkSignInReward = new DkSignInReward();
                        dkSignInReward.mName = String.valueOf(jSONArray.getJSONObject(i).optString("name"));
                        dkSignInReward.mValue = String.valueOf(jSONArray.getJSONObject(i).optInt("value"));
                        dkSignInReward.mType = 1;
                        arrayList.add(dkSignInReward);
                        i++;
                    }
                    UThread.runOnThread(new fv(this, arrayList));
                } else {
                    C0328a.m757c().m752c(LogLevel.EVENT, "resign_event", "pass_through_on_background");
                    String str = "";
                    int i2 = 0;
                    while (i2 < jSONArray.length()) {
                        String str2 = (str + "," + String.valueOf(jSONArray.getJSONObject(i2).optInt("value"))) + String.valueOf(jSONArray.getJSONObject(i2).optString("name"));
                        i2++;
                        str = str2;
                    }
                    UThread.runOnThread(new fw(this));
                    if (!TextUtils.isEmpty(str)) {
                        str = str.substring(1);
                    }
                    m5586b(str);
                }
                PersonalPrefs.m5175a().m5228f(true);
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
                m5579c(str3.substring(1));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m5583a(String str) {
        new fx(this, C0643q.f2173a, str).open();
    }

    /* renamed from: b */
    public int m5584b() {
        return this.f4018e;
    }

    /* renamed from: a */
    public void m5580a(int i) {
        this.f4018e = i;
        Iterator it = this.f4017d.iterator();
        while (it.hasNext()) {
            ((fy) it.next()).mo2551c();
        }
    }

    /* renamed from: b */
    public void m5586b(String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            string = this.f4015b.getString(C0247i.personal__resign_notification_content);
        } else {
            string = this.f4015b.getString(C0247i.personal__resign_notification_content_reward) + str;
        }
        m5577a("duokan-reader://personal/coupons", this.f4015b.getString(C0247i.personal__resign_notification_title), string, this.f4015b.getString(C0247i.personal__resign_notification_ticker));
    }

    /* renamed from: c */
    private void m5578c() {
        if (!ReaderEnv.get().getPrefBoolean(PrivatePref.PERSONAL, "is_in_task_page", false)) {
            m5580a(m5584b() + 1);
            m5577a("duokan-reader://personal/task", this.f4015b.getString(C0247i.personal__task_notification_title), this.f4015b.getString(C0247i.personal__task_notification_content), this.f4015b.getString(C0247i.personal__task_notification_ticker));
        }
    }

    /* renamed from: c */
    private void m5579c(String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            string = this.f4015b.getString(C0247i.personal__recharge_notification_content);
        } else {
            string = String.format(this.f4015b.getString(C0247i.personal__recharge_notification_content_reward), new Object[]{str});
        }
        m5577a("duokan-reader://personal/coupons", this.f4015b.getString(C0247i.personal__recharge_notification_title), string, this.f4015b.getString(C0247i.personal__recharge_notification_ticker));
    }

    /* renamed from: a */
    private void m5577a(String str, String str2, String str3, String str4) {
        String str5 = "task_notification";
        ((NotificationManager) this.f4015b.getSystemService("notification")).notify(str5, 1, new Builder(DkApp.get()).setContentTitle(str2).setContentText(str3).setTicker(str4).setSmallIcon(C0243e.mipush_small_notification).setDefaults(1).setWhen(System.currentTimeMillis()).setContentIntent(PendingIntent.getActivity(this.f4015b, 0, new Intent(this.f4015b, DkApp.get().getReaderActivityClass()).setAction("android.intent.action.VIEW").setData(Uri.parse(str)).addCategory("android.intent.category.LAUNCHER").addFlags(268468224), 134217728)).setAutoCancel(true).build());
    }
}
