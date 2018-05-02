package com.duokan.reader.common.async.work;

import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;

/* renamed from: com.duokan.reader.common.async.work.b */
class C0522b implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0521a f1760a;

    C0522b(C0521a c0521a) {
        this.f1760a = c0521a;
    }

    public void run() {
        synchronized (this.f1760a) {
            this.f1760a.f1756d = Thread.currentThread();
        }
        try {
            m2278a();
            synchronized (this.f1760a) {
                this.f1760a.f1756d = null;
            }
        } catch (Throwable th) {
            synchronized (this.f1760a) {
                this.f1760a.f1756d = null;
            }
        }
    }

    /* renamed from: a */
    private void m2278a() {
        synchronized (this.f1760a) {
            Object obj = (this.f1760a.f1755c.m2292g() || this.f1760a.f1755c.m2293h()) ? 1 : null;
        }
        if (obj != null) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
        }
        int i = 0;
        while (true) {
            Object obj2;
            C0525e a;
            Object obj3;
            Object obj4;
            synchronized (this.f1760a) {
                Object obj5 = (this.f1760a.f1755c.m2292g() || this.f1760a.f1755c.m2293h()) ? 1 : null;
                if (obj5 == null || !this.f1760a.f1755c.m2302q()) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
            }
            if (obj2 != null) {
                this.f1760a.m2272e();
            }
            if (obj5 != null) {
                a = this.f1760a.mo1488a(i);
            } else {
                a = null;
            }
            this.f1760a.m2277j();
            synchronized (this.f1760a) {
                if (this.f1760a.f1755c.m2292g() || this.f1760a.f1755c.m2293h()) {
                    obj5 = 1;
                } else {
                    obj5 = null;
                }
                if (a == null) {
                    if (obj5 == null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    obj5 = null;
                    obj3 = null;
                    obj4 = obj2;
                    obj2 = null;
                } else if (this.f1760a.f1755c.m2299n()) {
                    obj2 = null;
                    obj5 = null;
                    obj3 = null;
                    obj4 = 1;
                } else if (a.m2313b()) {
                    this.f1760a.f1755c.m2283a(a);
                    obj2 = null;
                    obj5 = null;
                    int obj32 = 1;
                    obj4 = 1;
                } else if (a.m2314c()) {
                    if (obj5 != null) {
                        this.f1760a.f1755c.m2287b(C0525e.m2310b(-2, true, false));
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    obj5 = obj2;
                    obj32 = null;
                    obj4 = 1;
                    obj2 = null;
                } else if (!a.f1777e) {
                    this.f1760a.f1755c.m2287b(a);
                    obj2 = null;
                    r5 = 1;
                    obj32 = null;
                    obj4 = 1;
                } else if (obj5 == null) {
                    obj2 = null;
                    obj5 = null;
                    obj32 = null;
                    obj4 = 1;
                } else if (!a.f1778f && this.f1760a.m2259a(a) != CheckErrorResult.Passed) {
                    this.f1760a.f1755c.m2287b(a);
                    obj2 = null;
                    r5 = 1;
                    obj32 = null;
                    obj4 = 1;
                } else if (i < this.f1760a.mo734b().m2289d()) {
                    i++;
                    obj2 = null;
                    obj5 = null;
                    obj32 = null;
                    obj4 = null;
                } else {
                    r5 = this.f1760a.mo1492b(a);
                    if (r5 == 3) {
                        this.f1760a.f1755c.m2284a(false);
                        obj2 = 1;
                        obj5 = null;
                    } else if (r5 == 6) {
                        this.f1760a.f1755c.m2287b(a);
                        obj2 = null;
                        r5 = 1;
                    } else {
                        throw new IllegalStateException();
                    }
                    obj32 = null;
                    obj4 = 1;
                }
            }
            if (obj32 != null) {
                this.f1760a.m2277j();
                this.f1760a.m2274g();
            } else if (obj5 != null) {
                this.f1760a.m2277j();
                this.f1760a.m2276i();
            } else if (obj2 != null) {
                this.f1760a.m2277j();
                this.f1760a.mo1493f();
            }
            synchronized (this.f1760a) {
                if (obj4 != null) {
                    if (!this.f1760a.f1755c.m2292g()) {
                        this.f1760a.f1758f = null;
                        this.f1760a.f1759g = null;
                        return;
                    }
                }
            }
        }
    }
}
