package com.duokan.reader.domain.cloud.push;

import android.content.Context;
import android.text.TextUtils;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.sys.UThread;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.ae;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.cloud.push.MessageWakeupListener.MessageSubType;
import com.duokan.reader.domain.social.message.C1140y;
import com.duokan.reader.domain.social.message.C1151k;
import com.duokan.reader.domain.social.message.DkMessagesManager;
import com.duokan.reader.domain.social.message.ar;
import com.duokan.reader.domain.social.message.at;
import com.duokan.reader.domain.social.message.aw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.duokan.reader.domain.cloud.push.b */
public class C0857b implements ai, C0586j, at {
    /* renamed from: a */
    protected static final String f4100a = C0857b.class.getName();
    /* renamed from: b */
    static final /* synthetic */ boolean f4101b = (!C0857b.class.desiredAssertionStatus());
    /* renamed from: c */
    private static final aj<C0857b> f4102c = new aj();
    /* renamed from: d */
    private final Context f4103d;
    /* renamed from: e */
    private final C0709k f4104e;
    /* renamed from: f */
    private final aw f4105f;
    /* renamed from: g */
    private final ReaderEnv f4106g;
    /* renamed from: h */
    private final LinkedList<C0856a> f4107h = new LinkedList();
    /* renamed from: i */
    private final HashMap<MessageSubType, MessageWakeupListener> f4108i = new HashMap();

    /* renamed from: a */
    public DkCloudPushMessage m5677a(String str) {
        return C0872q.m5709b().m5712a(str);
    }

    protected C0857b(Context context, C0709k c0709k, aw awVar, ReaderEnv readerEnv) {
        this.f4103d = context;
        this.f4104e = c0709k;
        this.f4105f = awVar;
        this.f4106g = readerEnv;
        DkApp.get().runPreReady(new C0858c(this));
        DkApp.get().runWhenAppReady(new C0862g(this));
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
        if (m5673h()) {
            m5658a(m5674i(), c0672a, true, null);
        }
    }

    public void onAccountLogoff(C0672a c0672a) {
        if (m5673h()) {
            String prefString = this.f4106g.getPrefString(PrivatePref.PERSONAL, "mi_push_account", "");
            String prefString2 = this.f4106g.getPrefString(PrivatePref.PERSONAL, "mi_push_account_token", "");
            if (!TextUtils.isEmpty(prefString2)) {
                m5666e(prefString2);
            } else if (!TextUtils.isEmpty(prefString)) {
                m5669f(prefString);
            }
        }
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }

    /* renamed from: a */
    public void mo1174a(DkMessagesManager dkMessagesManager, ArrayList<C1151k> arrayList, C1140y c1140y) {
        m5665e();
    }

    /* renamed from: a */
    public void mo1173a(DkMessagesManager dkMessagesManager) {
        m5665e();
    }

    /* renamed from: a */
    public static void m5651a(Context context, C0709k c0709k, aw awVar, ReaderEnv readerEnv) {
        f4102c.m709a(new C0857b(context, c0709k, awVar, readerEnv));
    }

    /* renamed from: a */
    public static C0857b m5649a() {
        return (C0857b) f4102c.m707a();
    }

    /* renamed from: a */
    public void m5685a(boolean z, ag agVar) {
        if (m5673h()) {
            m5657a(m5674i(), this.f4104e.m3502b(PersonalAccount.class), z, agVar);
        } else {
            agVar.mo1183a(this.f4103d.getString(C0247i.general__shared__push_client_server_error));
        }
    }

    /* renamed from: a */
    public void m5679a(DkCloudPushMessage dkCloudPushMessage) {
        C0872q.m5709b().m5713a(dkCloudPushMessage);
    }

    /* renamed from: b */
    public void m5688b(String str) {
        C0872q.m5709b().m5716b(str);
        m5665e();
    }

    /* renamed from: b */
    public void m5686b() {
        C0872q.m5709b().m5718d();
        m5665e();
        this.f4105f.m8492d();
    }

    /* renamed from: c */
    public int m5689c() {
        return C0872q.m5709b().m5717c() + this.f4105f.m8489b();
    }

    /* renamed from: a */
    public void m5678a(int i, long j, C0879x c0879x) {
        if (((PersonalAccount) this.f4104e.m3502b(PersonalAccount.class)).mo839i()) {
            m5650a(j, new C1151k[0], false, c0879x);
            return;
        }
        this.f4105f.m8482a(i, 10, true, new C0865j(this, j, c0879x));
    }

    /* renamed from: a */
    public void m5684a(List<C0876u> list, ar arVar) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (C0876u c0876u : list) {
            if (c0876u.f4157a != null) {
                arrayList2.add(c0876u.f4157a);
            } else if (c0876u.f4158b != null) {
                arrayList.add(c0876u.f4158b);
            }
        }
        this.f4105f.m8487a(arrayList2, new C0866k(this, arrayList, arVar));
    }

    /* renamed from: a */
    public void m5680a(MessageSubType messageSubType, MessageWakeupListener messageWakeupListener) {
        this.f4108i.put(messageSubType, messageWakeupListener);
    }

    /* renamed from: a */
    public void m5681a(C0856a c0856a) {
        if (f4101b || c0856a != null) {
            this.f4107h.add(c0856a);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public void m5687b(C0856a c0856a) {
        if (f4101b || c0856a != null) {
            this.f4107h.remove(c0856a);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    public void m5690c(String str) {
        C0880y.m5742a().m5754b(str);
    }

    /* renamed from: d */
    public void m5692d(String str) {
        C0880y.m5742a().m5756c(str);
    }

    /* renamed from: d */
    public List<String> m5691d() {
        return C0880y.m5742a().m5753b();
    }

    /* renamed from: e */
    private void m5665e() {
        UThread.runOnThread(new C0867l(this));
    }

    /* renamed from: a */
    private void m5658a(String str, C0672a c0672a, boolean z, Runnable runnable) {
        Object c = (c0672a == null || c0672a.mo839i()) ? "" : c0672a.mo833c();
        CharSequence prefString = this.f4106g.getPrefString(PrivatePref.PERSONAL, "mi_push_token", "");
        CharSequence prefString2 = this.f4106g.getPrefString(PrivatePref.PERSONAL, "mi_push_account", "");
        long prefLong = this.f4106g.getPrefLong(PrivatePref.PERSONAL, "mi_push_register_time", 0);
        if (z || System.currentTimeMillis() - prefLong > 86400000 || !TextUtils.equals(prefString, str) || !TextUtils.equals(prefString2, c) || C0641o.m2934i().m2985l()) {
            WebSession c0868m = new C0868m(this, ae.f2100a, c0672a, str, c, runnable);
            c0868m.setMaxRetryCount(1);
            c0868m.open();
        }
    }

    /* renamed from: f */
    private void m5667f() {
        if (m5673h() && !this.f4106g.getPrefBoolean(PrivatePref.PERSONAL, "mi_push_notify_server", false)) {
            m5657a(m5674i(), this.f4104e.m3502b(PersonalAccount.class), ReaderEnv.get().getReceivePushes(), null);
        }
    }

    /* renamed from: e */
    private void m5666e(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f4106g.setPrefString(PrivatePref.PERSONAL, "mi_push_notify_account_token", str);
            this.f4106g.commitPrefs();
            WebSession c0869n = new C0869n(this, ae.f2100a, str);
            c0869n.setMaxRetryCount(1);
            c0869n.open();
        }
    }

    /* renamed from: f */
    private void m5669f(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f4106g.setPrefString(PrivatePref.PERSONAL, "mi_push_notify_account", str);
            this.f4106g.commitPrefs();
            WebSession c0870o = new C0870o(this, ae.f2100a, str);
            c0870o.setMaxRetryCount(1);
            c0870o.open();
        }
    }

    /* renamed from: g */
    private void m5671g() {
        this.f4106g.setPrefString(PrivatePref.PERSONAL, "mi_push_notify_account", "");
        this.f4106g.setPrefString(PrivatePref.PERSONAL, "mi_push_account", "");
        this.f4106g.setPrefString(PrivatePref.PERSONAL, "mi_push_account_token", "");
        this.f4106g.setPrefString(PrivatePref.PERSONAL, "mi_push_notify_account_token", "");
        this.f4106g.commitPrefs();
    }

    /* renamed from: a */
    private void m5657a(String str, C0672a c0672a, boolean z, ag agVar) {
        new C0859d(this, ae.f2100a, c0672a, str, z, new C0871p(this, agVar)).open();
    }

    /* renamed from: a */
    private void m5659a(String str, C0672a c0672a, String... strArr) {
        new C0860e(this, ae.f2100a, c0672a, str, strArr).open();
    }

    /* renamed from: h */
    private boolean m5673h() {
        return !TextUtils.isEmpty(this.f4106g.getPrefString(PrivatePref.PERSONAL, "mi_push_token", ""));
    }

    /* renamed from: i */
    private String m5674i() {
        return this.f4106g.getPrefString(PrivatePref.PERSONAL, "mi_push_token", "");
    }

    /* renamed from: a */
    private void m5650a(long j, C1151k[] c1151kArr, boolean z, C0879x c0879x) {
        C0876u[] c0876uArr;
        boolean z2;
        int i = 20;
        DkCloudPushMessage[] a = C0872q.m5709b().m5715a(j);
        Collection a2 = C0876u.m5731a(a);
        Collection a3 = C0876u.m5732a(c1151kArr);
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(a2);
        linkedList.addAll(a3);
        Collections.sort(linkedList, new C0861f(this));
        if (linkedList.size() > 0) {
            if (linkedList.size() <= 20) {
                i = linkedList.size();
            }
            c0876uArr = (C0876u[]) linkedList.subList(0, i).toArray(new C0876u[0]);
        } else {
            c0876uArr = new C0876u[0];
        }
        if (z || a.length > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        c0879x.mo1894a(c0876uArr, z2);
    }
}
