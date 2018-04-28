package com.duokan.reader.domain.cloud;

import android.content.Context;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.common.async.p035a.C0519c;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class ap implements ai, ao {
    /* renamed from: a */
    private static final aj<ap> f3695a = new aj();
    /* renamed from: b */
    private final Context f3696b;
    /* renamed from: c */
    private final C0709k f3697c;
    /* renamed from: d */
    private final C0586j f3698d;
    /* renamed from: e */
    private final LinkedList<au> f3699e = new LinkedList();
    /* renamed from: f */
    private al f3700f;
    /* renamed from: g */
    private int f3701g = 0;

    private ap(Context context, C0709k c0709k) {
        this.f3696b = context;
        this.f3697c = c0709k;
        this.f3698d = new aq(this);
        this.f3700f = new al(this.f3697c.m3508d());
        this.f3701g = PersonalPrefs.m5175a().m5233i();
        DkApp.get().runPreReady(new ar(this));
    }

    /* renamed from: a */
    public static void m5295a(Context context, C0709k c0709k) {
        f3695a.m709a(new ap(context, c0709k));
    }

    /* renamed from: a */
    public static ap m5294a() {
        return (ap) f3695a.m707a();
    }

    /* renamed from: a */
    public void m5306a(au auVar) {
        this.f3699e.add(auVar);
    }

    /* renamed from: b */
    public void m5308b(au auVar) {
        this.f3699e.remove(auVar);
    }

    /* renamed from: b */
    public int m5307b() {
        return this.f3701g;
    }

    /* renamed from: a */
    public void m5303a(C0517a<Void> c0517a) {
        m5297a(false, false, 0, 0);
    }

    /* renamed from: a */
    public void mo1154a(SharedKey sharedKey, Serializable serializable) {
        m5303a(C0519c.f1752a);
    }

    /* renamed from: a */
    public void mo1153a(SharedKey sharedKey) {
        m5303a(C0519c.f1752a);
    }

    /* renamed from: a */
    private void m5297a(boolean z, boolean z2, int i, int i2) {
        if (z || !this.f3700f.m3366b()) {
            m5296a(z, i, i2);
        }
    }

    /* renamed from: a */
    private void m5296a(boolean z, int i, int i2) {
        this.f3697c.m3495a(new as(this, i, i2, z));
    }

    /* renamed from: c */
    private void m5300c() {
        Iterator it = this.f3699e.iterator();
        while (it.hasNext()) {
            ((au) it.next()).mo1919c();
        }
    }
}
