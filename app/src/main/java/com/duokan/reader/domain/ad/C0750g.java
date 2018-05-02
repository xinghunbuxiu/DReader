package com.duokan.reader.domain.ad;

import android.content.Context;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.dv;
import com.duokan.reader.DkApp;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.duokan.reader.domain.ad.g */
public class C0750g implements ai {
    /* renamed from: d */
    private static final aj<C0750g> f2542d = new aj();
    /* renamed from: a */
    private final String f2543a;
    /* renamed from: b */
    private final String f2544b;
    /* renamed from: c */
    private final String f2545c;
    /* renamed from: e */
    private final Context f2546e;
    /* renamed from: f */
    private String f2547f;
    /* renamed from: g */
    private final String f2548g = "http://api.ad.xiaomi.com/u/api";
    /* renamed from: h */
    private final String f2549h = "http://api.ad.xiaomi.com/u/getSplashAds";
    /* renamed from: i */
    private final int f2550i;
    /* renamed from: j */
    private final int f2551j;
    /* renamed from: k */
    private final int f2552k;
    /* renamed from: l */
    private final int f2553l;
    /* renamed from: m */
    private final int f2554m;
    /* renamed from: n */
    private final int f2555n;
    /* renamed from: o */
    private final int f2556o;
    /* renamed from: p */
    private int f2557p = 0;
    /* renamed from: q */
    private int f2558q = 0;
    /* renamed from: r */
    private final C0746c f2559r;
    /* renamed from: s */
    private int f2560s = 0;
    /* renamed from: t */
    private ConcurrentLinkedQueue<C0748e> f2561t = new ConcurrentLinkedQueue();
    /* renamed from: u */
    private ConcurrentLinkedQueue<C0748e> f2562u = new ConcurrentLinkedQueue();

    /* renamed from: n */
    static /* synthetic */ int m3579n(C0750g c0750g) {
        int i = c0750g.f2558q + 1;
        c0750g.f2558q = i;
        return i;
    }

    private C0750g(Context context) {
        this.f2546e = context;
        this.f2543a = DkApp.get().getFictionChapterEndAdUpId();
        this.f2544b = DkApp.get().getSplashAdUpId();
        this.f2545c = DkApp.get().getComicChapterEndAdUpId();
        this.f2559r = new C0746c(context);
        this.f2550i = dv.m1932b(context, 275.0f);
        this.f2551j = dv.m1932b(context, 185.0f);
        this.f2552k = dv.m1932b(context, 120.0f);
        this.f2553l = dv.m1932b(context, 285.0f);
        this.f2554m = dv.m1932b(context, 205.0f);
        this.f2555n = dv.m1932b(context, 155.0f);
        this.f2556o = dv.m1932b(context, 115.0f);
    }

    /* renamed from: a */
    public static void m3562a(Context context) {
        f2542d.m709a(new C0750g(context));
    }

    /* renamed from: a */
    public static C0750g m3561a() {
        return (C0750g) f2542d.m707a();
    }

    /* renamed from: a */
    public void m3585a(String str) {
        this.f2547f = str;
        m3571g();
    }

    /* renamed from: b */
    public C0748e m3587b() {
        if (this.f2562u.isEmpty()) {
            m3573h();
            return null;
        }
        C0748e c0748e = (C0748e) this.f2562u.remove();
        if (this.f2562u.size() > 1) {
            return c0748e;
        }
        UThread.post(new C0751h(this));
        return c0748e;
    }

    /* renamed from: a */
    public C0748e m3583a(int i) {
        if (i < this.f2552k) {
            return null;
        }
        Iterator it = this.f2561t.iterator();
        while (it.hasNext()) {
            C0748e c0748e = (C0748e) it.next();
            if (c0748e.f2539x < i) {
                this.f2561t.remove(c0748e);
                if (this.f2561t.size() > 1) {
                    return c0748e;
                }
                UThread.post(new C0752i(this));
                return c0748e;
            }
        }
        m3571g();
        return null;
    }

    /* renamed from: g */
    private void m3571g() {
        synchronized (this) {
            this.f2557p++;
        }
        new C0753j(this).open();
    }

    /* renamed from: h */
    private void m3573h() {
        synchronized (this) {
            this.f2557p++;
        }
        new C0755l(this).open();
    }

    /* renamed from: a */
    public void m3586a(String str, int i, C0759p c0759p) {
        synchronized (this) {
            this.f2557p++;
        }
        new C0757n(this, str, i, c0759p).open();
    }

    /* renamed from: a */
    public void m3584a(C0748e c0748e) {
        if (c0748e != null) {
            m3564a(c0748e.f2525j);
        }
    }

    /* renamed from: b */
    public void m3588b(C0748e c0748e) {
        if (c0748e != null) {
            m3564a(c0748e.f2526k);
        }
    }

    /* renamed from: c */
    public void m3590c(C0748e c0748e) {
        if (c0748e != null) {
            m3564a(c0748e.f2527l);
        }
    }

    /* renamed from: d */
    public void m3592d(C0748e c0748e) {
        if (c0748e != null) {
            m3564a(c0748e.f2528m);
        }
    }

    /* renamed from: e */
    public void m3594e(C0748e c0748e) {
        if (c0748e != null) {
            m3564a(c0748e.f2529n);
        }
    }

    /* renamed from: f */
    public void m3596f(C0748e c0748e) {
        if (c0748e != null) {
            m3564a(c0748e.f2530o);
        }
    }

    /* renamed from: a */
    private void m3564a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            new C0758o(this, list).open();
        }
    }

    /* renamed from: c */
    public int m3589c() {
        int i;
        synchronized (this) {
            i = this.f2558q;
            this.f2558q = 0;
        }
        return i;
    }

    /* renamed from: d */
    public int m3591d() {
        int i;
        synchronized (this) {
            i = this.f2557p;
            this.f2557p = 0;
        }
        return i;
    }

    /* renamed from: e */
    public int m3593e() {
        int i;
        synchronized (this) {
            i = this.f2560s;
            this.f2560s = 0;
        }
        return i;
    }

    /* renamed from: f */
    public void m3595f() {
        synchronized (this) {
            this.f2560s++;
        }
    }
}
