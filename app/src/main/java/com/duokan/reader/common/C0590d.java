package com.duokan.reader.common;

import android.content.Intent;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.sys.UThread;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.cloud.push.C0857b;
import com.duokan.reader.domain.cloud.push.MessageWakeupListener;

import java.util.LinkedList;

/* renamed from: com.duokan.reader.common.d */
public class C0590d implements ai, C0586j, MessageWakeupListener {
    /* renamed from: a */
    private static final aj<C0590d> f1922a = new aj();
    /* renamed from: b */
    private final DkApp f1923b;
    /* renamed from: c */
    private final boolean f1924c;
    /* renamed from: d */
    private final ReaderEnv f1925d;
    /* renamed from: e */
    private final C0709k f1926e;
    /* renamed from: f */
    private final LinkedList<C0610h> f1927f = new LinkedList();
    /* renamed from: g */
    private final Intent f1928g;
    /* renamed from: h */
    private int f1929h = 0;
    /* renamed from: i */
    private long f1930i = 0;

    private C0590d(DkApp dkApp, boolean z, ReaderEnv readerEnv, C0857b c0857b, C0709k c0709k) {
        this.f1923b = dkApp;
        this.f1924c = z;
        this.f1925d = readerEnv;
        this.f1926e = c0709k;
        this.f1928g = new Intent(this.f1923b, DkApp.get().getReaderActivityClass());
        this.f1928g.setAction("com.duokan.reader.actions.SHOW_FEEDBACK");
        this.f1928g.addFlags(268468224);
        c0857b.m5680a(MessageSubType.BBS_FEEDBACK, (MessageWakeupListener) this);
        this.f1923b.runPreReady(new C0607e(this));
    }

    /* renamed from: a */
    public static void m2645a(DkApp dkApp, boolean z, ReaderEnv readerEnv, C0857b c0857b, C0709k c0709k) {
        f1922a.m709a(new C0590d(dkApp, z, readerEnv, c0857b, c0709k));
    }

    /* renamed from: a */
    public static C0590d m2643a() {
        return (C0590d) f1922a.m707a();
    }

    /* renamed from: b */
    public int m2654b() {
        return this.f1929h;
    }

    /* renamed from: c */
    public void m2656c() {
        m2644a(0);
    }

    /* renamed from: a */
    public void m2652a(C0610h c0610h) {
        this.f1927f.add(c0610h);
    }

    /* renamed from: b */
    public void m2655b(C0610h c0610h) {
        this.f1927f.remove(c0610h);
    }

    /* renamed from: a */
    public void mo785a(MessageSubType messageSubType, Object obj, boolean z) {
        if (z) {
            this.f1923b.startActivity(this.f1928g);
            return;
        }
        this.f1930i = System.currentTimeMillis();
        m2650d();
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
        m2650d();
    }

    public void onAccountLogoff(C0672a c0672a) {
        m2644a(0);
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }

    /* renamed from: d */
    private void m2650d() {
        if (C0709k.m3476a().m3500a(MiAccount.class)) {
            m2646a((MiAccount) this.f1926e.m3502b(MiAccount.class));
        }
    }

    /* renamed from: a */
    private void m2644a(int i) {
        if (this.f1929h != i) {
            this.f1929h = i;
            this.f1925d.setPrefInt(PrivatePref.PERSONAL, "feedback_count", this.f1929h);
            this.f1925d.commitPrefs();
            m2651e();
        }
    }

    /* renamed from: e */
    private void m2651e() {
        UThread.runOnThread(new C0608f(this));
    }

    /* renamed from: a */
    private void m2646a(MiAccount miAccount) {
        new C0609g(this, miAccount).open();
    }
}
