package com.duokan.reader.ui.p051b;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkNotificationManager;
import com.duokan.reader.DkReader;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.social.message.C1140y;
import com.duokan.reader.domain.social.message.C1148h;
import com.duokan.reader.domain.social.message.C1151k;
import com.duokan.reader.domain.social.message.DkMessagesManager;
import com.duokan.reader.domain.social.message.aa;
import com.duokan.reader.domain.social.message.at;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.duokan.reader.ui.b.a */
public class C1275a implements ai, at {
    /* renamed from: a */
    private static final aj<C1275a> f5999a = new aj();
    /* renamed from: b */
    private final Context f6000b;
    /* renamed from: c */
    private final HashMap<String, C1151k> f6001c = new HashMap();

    private C1275a(Context context, C1148h c1148h) {
        this.f6000b = context;
        DkApp.get().runPreReady(new C1276b(this, c1148h));
    }

    /* renamed from: a */
    public static void m9028a(Context context, C1148h c1148h) {
        f5999a.m709a(new C1275a(context, c1148h));
    }

    /* renamed from: a */
    public void mo1173a(DkMessagesManager dkMessagesManager) {
        String[] c = dkMessagesManager.m8491c();
        if (c.length == 0) {
            this.f6001c.clear();
            m9027a();
        } else if (this.f6001c.isEmpty()) {
            dkMessagesManager.m8486a(Arrays.asList(c), new C1277c(this));
        }
    }

    /* renamed from: a */
    public void mo1174a(DkMessagesManager dkMessagesManager, ArrayList<C1151k> arrayList, C1140y c1140y) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C1151k c1151k = (C1151k) it.next();
            this.f6001c.put(c1151k.f5555b, c1151k);
        }
        String[] c = dkMessagesManager.m8491c();
        ArrayList arrayList2 = new ArrayList();
        for (String str : this.f6001c.keySet()) {
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
            this.f6001c.remove((String) it.next());
        }
        m9027a();
        c1140y.mo1519a(true);
    }

    /* renamed from: a */
    private void m9027a() {
        if (this.f6001c.isEmpty()) {
            m9031c();
        } else {
            m9029b();
        }
    }

    /* renamed from: b */
    private void m9029b() {
        if (ReaderEnv.get().getIsReceiveReplyMessage()) {
            CharSequence charSequence;
            CharSequence b;
            Builder builder = new Builder(this.f6000b);
            if (this.f6001c.size() == 1) {
                C1151k c1151k = (C1151k) this.f6001c.values().iterator().next();
                charSequence = c1151k.m8578a().getAliasForDisplay() + aa.m8504a(this.f6000b, c1151k);
                b = c1151k.m8580b();
            } else {
                charSequence = this.f6000b.getString(C0258j.app__shared__shortcut_name);
                b = this.f6000b.getString(C0258j.personal__feed_notification__several_replies, new Object[]{Integer.valueOf(this.f6001c.size())});
            }
            Intent intent = new Intent(this.f6000b, DkReader.get().getMainActivityClass());
            intent.setAction("com.duokan.reader.actions.OPEN_REPLY_MESSAGES");
            intent.addFlags(268435456);
            DkNotificationManager.get().notify("com.duokan.reader.domain.social.message.DkUnreadFeedMessagesNotifier", 0, builder.setContentIntent(PendingIntent.getActivity(this.f6000b, 0, intent, 134217728)).setSmallIcon(C0254f.mipush_small_notification).setTicker(b).setAutoCancel(true).setContentTitle(charSequence).setContentText(b).build());
        }
    }

    /* renamed from: c */
    private void m9031c() {
        DkNotificationManager.get().cancel("com.duokan.reader.domain.social.message.DkUnreadFeedMessagesNotifier", 0);
    }
}
