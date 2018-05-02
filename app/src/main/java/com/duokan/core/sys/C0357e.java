package com.duokan.core.sys;

import com.duokan.core.sys.AsyncCache.DataState;

/* renamed from: com.duokan.core.sys.e */
public abstract class C0357e {
    /* renamed from: a */
    static final /* synthetic */ boolean f718a = (!AsyncCache.class.desiredAssertionStatus());
    /* renamed from: b */
    private DataState f719b = DataState.NULL;
    /* renamed from: c */
    private boolean f720c = false;
    /* renamed from: d */
    private Thread f721d = null;

    /* renamed from: a */
    protected abstract boolean mo769a(C0357e c0357e);

    /* renamed from: h */
    public abstract int mo770h();

    /* renamed from: i */
    public abstract int mo771i();

    /* renamed from: j */
    protected abstract boolean mo772j();

    /* renamed from: k */
    protected abstract void mo773k();

    /* renamed from: l */
    protected abstract void mo774l();

    /* renamed from: m */
    protected abstract void mo1754m();

    /* renamed from: a */
    public final boolean m1007a() {
        return this.f720c;
    }

    /* renamed from: b */
    public final boolean m1009b() {
        return this.f719b == DataState.NULL;
    }

    /* renamed from: c */
    public final boolean m1010c() {
        return this.f719b == DataState.EMPTY;
    }

    /* renamed from: d */
    public final boolean m1011d() {
        return this.f721d != null;
    }

    /* renamed from: e */
    public final boolean m1012e() {
        return this.f719b == DataState.FILLED;
    }

    /* renamed from: f */
    public final void m1013f() {
        this.f720c = true;
    }

    /* renamed from: g */
    protected final boolean m1014g() {
        return Thread.currentThread() == this.f721d;
    }

    /* renamed from: n */
    private final boolean m1001n() {
        if (f718a || this.f719b == DataState.NULL) {
            boolean z = false;
            try {
                z = mo772j();
            } catch (Error e) {
                e.printStackTrace();
            }
            if (z) {
                this.f719b = DataState.UNFILLED;
            }
            return z;
        }
        throw new AssertionError();
    }

    /* renamed from: h */
    private final boolean m1000h(C0357e c0357e) {
        if (!f718a && this.f719b != DataState.NULL) {
            throw new AssertionError();
        } else if (f718a || c0357e.f719b == DataState.FILLED || c0357e.f719b == DataState.UNFILLED) {
            boolean z = false;
            try {
                z = mo769a(c0357e);
            } catch (Error e) {
                e.printStackTrace();
            }
            if (z) {
                this.f719b = DataState.UNFILLED;
                c0357e.f719b = DataState.EMPTY;
            }
            return z;
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: o */
    private final void m1002o() {
        if (f718a || this.f719b != DataState.EMPTY) {
            try {
                mo773k();
            } catch (Error e) {
                e.printStackTrace();
            }
            this.f719b = DataState.EMPTY;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: p */
    private final void m1003p() {
        if (f718a || this.f721d == null) {
            this.f721d = Thread.currentThread();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: q */
    private final void m1004q() {
        if (f718a || this.f721d != null) {
            this.f721d = null;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: r */
    private final void m1005r() {
        if (f718a || this.f719b == DataState.UNFILLED) {
            try {
                mo774l();
            } catch (Error e) {
                e.printStackTrace();
            }
            this.f719b = DataState.FILLED;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: s */
    private final void m1006s() {
        if (f718a || this.f719b == DataState.UNFILLED) {
            try {
                mo1754m();
            } catch (Error e) {
                e.printStackTrace();
            }
            this.f719b = DataState.EMPTY;
            return;
        }
        throw new AssertionError();
    }
}
