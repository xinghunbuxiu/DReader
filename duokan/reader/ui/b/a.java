package com.duokan.reader.ui.b;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;

import com.duokan.c.f;
import com.duokan.c.j;
import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkNotificationManager;
import com.duokan.reader.DkReader;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.social.message.DkMessagesManager;
import com.duokan.reader.domain.social.message.aa;
import com.duokan.reader.domain.social.message.ac;
import com.duokan.reader.domain.social.message.ay;
import com.duokan.reader.domain.social.message.h;
import com.duokan.reader.domain.social.message.k;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class a implements ah, ay {
    private static final ai a = new ai();
    private final Context b;
    private final HashMap c = new HashMap();

    private a(Context context, h hVar) {
        this.b = context;
        DkApp.get().runPreReady(new b(this, hVar));
    }

    public static void a(Context context, h hVar) {
        a.a(new a(context, hVar));
    }

    public void a(DkMessagesManager dkMessagesManager) {
        String[] c = dkMessagesManager.c();
        if (c.length == 0) {
            this.c.clear();
            a();
        } else if (this.c.isEmpty()) {
            dkMessagesManager.a(Arrays.asList(c), new c(this));
        }
    }

    public void a(DkMessagesManager dkMessagesManager, ArrayList arrayList, aa aaVar) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            this.c.put(kVar.b, kVar);
        }
        String[] c = dkMessagesManager.c();
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.c.keySet()) {
            boolean z;
            for (String equals : c) {
                if (equals.equals(str)) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (!z) {
                arrayList2.add(str);
            }
        }
        it = arrayList2.iterator();
        while (it.hasNext()) {
            this.c.remove((String) it.next());
        }
        a();
        aaVar.a(true);
    }

    private void a() {
        if (this.c.isEmpty()) {
            c();
        } else {
            b();
        }
    }

    private void b() {
        if (ReaderEnv.get().getIsReceiveReplyMessage()) {
            CharSequence charSequence;
            CharSequence b;
            Builder builder = new Builder(this.b);
            if (this.c.size() == 1) {
                k kVar = (k) this.c.values().iterator().next();
                charSequence = kVar.a().getAliasForDisplay() + ac.a(this.b, kVar);
                b = kVar.b();
            } else {
                charSequence = this.b.getString(j.app__shared__shortcut_name);
                b = this.b.getString(j.personal__feed_notification__several_replies, new Object[]{Integer.valueOf(this.c.size())});
            }
            Intent intent = new Intent(this.b, DkReader.get().getMainActivityClass());
            intent.setAction("com.duokan.reader.actions.OPEN_REPLY_MESSAGES");
            intent.addFlags(268435456);
            DkNotificationManager.get().notify("com.duokan.reader.domain.social.message.DkUnreadFeedMessagesNotifier", 0, builder.setContentIntent(PendingIntent.getActivity(this.b, 0, intent, 134217728)).setSmallIcon(f.mipush_small_notification).setTicker(b).setAutoCancel(true).setContentTitle(charSequence).setContentText(b).build());
        }
    }

    private void c() {
        DkNotificationManager.get().cancel("com.duokan.reader.domain.social.message.DkUnreadFeedMessagesNotifier", 0);
    }
}
