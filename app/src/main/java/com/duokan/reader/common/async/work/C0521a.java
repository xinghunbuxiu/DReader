package com.duokan.reader.common.async.work;

import android.content.Context;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.duokan.reader.common.async.work.a */
public abstract class C0521a<TItem extends C0523c> implements C0520o<TItem> {
    /* renamed from: a */
    private final Context f1753a;
    /* renamed from: b */
    private final C0529q<TItem> f1754b;
    /* renamed from: c */
    private final TItem f1755c;
    /* renamed from: d */
    private Thread f1756d;
    /* renamed from: e */
    private final List<IAsyncWorkProgressListener<TItem>> f1757e = new LinkedList();
    /* renamed from: f */
    private Runnable f1758f;
    /* renamed from: g */
    private ThreadPoolExecutor f1759g;

    /* renamed from: a */
    protected abstract C0525e mo1488a(int i);

    /* renamed from: a */
    public static CheckErrorResult m2253a(CheckErrorResult checkErrorResult, CheckErrorResult checkErrorResult2) {
        if (checkErrorResult == CheckErrorResult.Ignored) {
            return checkErrorResult2;
        }
        if (checkErrorResult != CheckErrorResult.Passed) {
            return CheckErrorResult.Failed;
        }
        if (checkErrorResult2 == CheckErrorResult.Failed) {
            return CheckErrorResult.Failed;
        }
        return CheckErrorResult.Passed;
    }

    public C0521a(Context context, TItem tItem, C0529q<TItem> c0529q) {
        this.f1753a = context.getApplicationContext();
        this.f1755c = tItem;
        this.f1754b = c0529q;
    }

    /* renamed from: a */
    protected void m2263a(String str) {
        this.f1755c.m2281a(str);
        m2277j();
    }

    /* renamed from: a */
    public Context m2258a() {
        return this.f1753a;
    }

    /* renamed from: b */
    public TItem mo734b() {
        return this.f1755c;
    }

    /* renamed from: a */
    public void mo731a(IAsyncWorkProgressListener<TItem> iAsyncWorkProgressListener) {
        Object obj = null;
        synchronized (this) {
            if (iAsyncWorkProgressListener != null) {
                if (!this.f1757e.contains(iAsyncWorkProgressListener)) {
                    this.f1757e.add(iAsyncWorkProgressListener);
                    obj = 1;
                }
            }
        }
        if (obj != null) {
            mo735b((IAsyncWorkProgressListener) iAsyncWorkProgressListener);
        }
    }

    /* renamed from: b */
    public void mo735b(IAsyncWorkProgressListener<TItem> iAsyncWorkProgressListener) {
        if (iAsyncWorkProgressListener != null) {
            int f = this.f1755c.m2291f();
            if (f == 1) {
                iAsyncWorkProgressListener.mo745a(this.f1755c);
                iAsyncWorkProgressListener.mo747c(this.f1755c);
            } else if (f == 2) {
                iAsyncWorkProgressListener.mo746b(this.f1755c);
                iAsyncWorkProgressListener.mo747c(this.f1755c);
            } else if (f == 4 || f == 3) {
                iAsyncWorkProgressListener.mo747c(this.f1755c);
                iAsyncWorkProgressListener.mo748d(this.f1755c);
            } else if (f == 7) {
                iAsyncWorkProgressListener.mo750f(this.f1755c);
            } else if (f == 6) {
                iAsyncWorkProgressListener.mo751g(this.f1755c);
            } else if (f == 5) {
                iAsyncWorkProgressListener.mo749e(this.f1755c);
            }
        }
    }

    /* renamed from: c */
    public void mo737c(IAsyncWorkProgressListener<TItem> iAsyncWorkProgressListener) {
        synchronized (this) {
            if (iAsyncWorkProgressListener != null) {
                this.f1757e.remove(iAsyncWorkProgressListener);
            }
        }
    }

    /* renamed from: a */
    public final void mo732a(ThreadPoolExecutor threadPoolExecutor) {
        Object obj;
        synchronized (this) {
            if (this.f1755c.m2301p()) {
                obj = 1;
                if (this.f1758f == null) {
                    this.f1758f = new C0522b(this);
                    this.f1759g = threadPoolExecutor;
                    this.f1759g.execute(this.f1758f);
                }
            } else {
                obj = null;
            }
        }
        if (obj != null) {
            m2277j();
            m2271d();
        }
    }

    /* renamed from: a */
    protected void m2261a(long j, long j2) {
        this.f1755c.m2280a(j, j2);
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.f1757e);
        }
        for (IAsyncWorkProgressListener c : linkedList) {
            c.mo747c(mo734b());
        }
    }

    /* renamed from: a */
    public void mo733a(boolean z) {
        Object obj = 1;
        Object obj2 = null;
        synchronized (this) {
            boolean j = this.f1755c.m2295j();
            if (this.f1755c.m2284a(z)) {
                if (this.f1756d != null) {
                    this.f1756d.interrupt();
                }
                if (!j) {
                    obj2 = 1;
                }
            } else {
                obj = null;
            }
        }
        if (obj != null) {
            m2277j();
        }
        if (obj2 != null) {
            mo1493f();
        }
    }

    /* renamed from: c */
    public void mo736c() {
        Object obj = 1;
        Object obj2 = null;
        synchronized (this) {
            if (this.f1755c.m2299n() || !this.f1755c.m2303r()) {
                obj = null;
            } else {
                if (this.f1756d != null) {
                    this.f1756d.interrupt();
                }
                obj2 = 1;
            }
        }
        if (obj != null) {
            m2277j();
        }
        if (obj2 != null) {
            mo1494h();
        }
    }

    /* renamed from: d */
    protected void m2271d() {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.f1757e);
        }
        for (IAsyncWorkProgressListener a : linkedList) {
            a.mo745a(mo734b());
        }
    }

    /* renamed from: e */
    protected void m2272e() {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.f1757e);
        }
        for (IAsyncWorkProgressListener b : linkedList) {
            b.mo746b(mo734b());
        }
    }

    /* renamed from: f */
    protected void mo1493f() {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.f1757e);
        }
        for (IAsyncWorkProgressListener d : linkedList) {
            d.mo748d(mo734b());
        }
    }

    /* renamed from: g */
    protected void m2274g() {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.f1757e);
        }
        for (IAsyncWorkProgressListener e : linkedList) {
            e.mo749e(mo734b());
        }
    }

    /* renamed from: h */
    protected void mo1494h() {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.f1757e);
        }
        for (IAsyncWorkProgressListener f : linkedList) {
            f.mo750f(mo734b());
        }
    }

    /* renamed from: a */
    protected CheckErrorResult m2259a(C0525e c0525e) {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.f1757e);
        }
        CheckErrorResult checkErrorResult = CheckErrorResult.Ignored;
        CheckErrorResult checkErrorResult2 = checkErrorResult;
        for (IAsyncWorkProgressListener a : linkedList) {
            checkErrorResult2 = C0521a.m2253a(checkErrorResult2, a.mo744a(mo734b(), c0525e));
        }
        return checkErrorResult2;
    }

    /* renamed from: i */
    protected void m2276i() {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.f1757e);
        }
        for (IAsyncWorkProgressListener g : linkedList) {
            g.mo751g(mo734b());
        }
    }

    /* renamed from: b */
    protected int mo1492b(C0525e c0525e) {
        return 6;
    }

    /* renamed from: j */
    protected void m2277j() {
        this.f1755c.m2307v();
        this.f1754b.mo741b(this.f1755c);
    }
}
