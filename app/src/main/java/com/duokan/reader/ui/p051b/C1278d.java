package com.duokan.reader.ui.p051b;

import android.content.Context;
import com.duokan.core.app.C0286x;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.C0590d;
import com.duokan.reader.common.C0610h;
import com.duokan.reader.domain.cloud.push.C0856a;
import com.duokan.reader.domain.cloud.push.C0857b;
import com.duokan.reader.domain.social.message.C1148h;
import com.duokan.reader.domain.social.message.au;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.duokan.reader.ui.b.d */
public class C1278d implements ai, C0286x, C0610h, C0856a, au {
    /* renamed from: a */
    static final /* synthetic */ boolean f6005a = (!C1278d.class.desiredAssertionStatus());
    /* renamed from: b */
    private static final aj<C1278d> f6006b = new aj();
    /* renamed from: c */
    private final Context f6007c;
    /* renamed from: d */
    private final C0857b f6008d;
    /* renamed from: e */
    private final C1148h f6009e;
    /* renamed from: f */
    private final C0590d f6010f;
    /* renamed from: g */
    private final LinkedList<C1280f> f6011g = new LinkedList();
    /* renamed from: h */
    private int f6012h = 0;

    private C1278d(Context context, C0857b c0857b, C1148h c1148h, C0590d c0590d) {
        this.f6007c = context;
        this.f6008d = c0857b;
        this.f6009e = c1148h;
        this.f6010f = c0590d;
        DkApp.get().runPreReady(new C1279e(this));
    }

    /* renamed from: a */
    public void mo1594a() {
        if (DkApp.get().isReady()) {
            m9046h();
        }
    }

    /* renamed from: b */
    public void mo1596b() {
        if (DkApp.get().isReady()) {
            m9046h();
        }
    }

    /* renamed from: a */
    public void mo1595a(int i) {
        if (DkApp.get().isReady()) {
            m9046h();
        }
    }

    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
    }

    /* renamed from: a */
    public static void m9038a(Context context, C0857b c0857b, C1148h c1148h, C0590d c0590d) {
        f6006b.m709a(new C1278d(context, c0857b, c1148h, c0590d));
    }

    /* renamed from: c */
    public static C1278d m9042c() {
        return (C1278d) f6006b.m707a();
    }

    /* renamed from: a */
    public void m9049a(C1280f c1280f) {
        if (f6005a || c1280f != null) {
            c1280f.mo1917b(this.f6012h);
            this.f6011g.add(c1280f);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public void m9051b(C1280f c1280f) {
        if (f6005a || c1280f != null) {
            this.f6011g.remove(c1280f);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: d */
    public int m9052d() {
        return this.f6012h;
    }

    /* renamed from: e */
    public int m9053e() {
        return this.f6008d.m5689c() + this.f6009e.m8489b();
    }

    /* renamed from: f */
    private void m9044f() {
        this.f6012h = m9045g();
        m9040b(this.f6012h);
    }

    /* renamed from: g */
    private int m9045g() {
        return (this.f6008d.m5689c() + this.f6009e.m8489b()) + this.f6010f.m2654b();
    }

    /* renamed from: h */
    private void m9046h() {
        m9044f();
    }

    /* renamed from: b */
    private void m9040b(int i) {
        Iterator it = this.f6011g.iterator();
        while (it.hasNext()) {
            ((C1280f) it.next()).mo1917b(i);
        }
    }
}
