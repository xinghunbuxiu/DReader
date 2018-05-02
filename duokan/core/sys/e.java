package com.duokan.core.sys;

import com.duokan.core.sys.AsyncCache.DataState;

public abstract class e {
    static final /* synthetic */ boolean a = (!AsyncCache.class.desiredAssertionStatus());
    private DataState b = DataState.NULL;
    private boolean c = false;
    private Thread d = null;

    protected abstract boolean a(e eVar);

    public abstract int h();

    public abstract int i();

    protected abstract boolean j();

    protected abstract void k();

    protected abstract void l();

    protected abstract void m();

    public final boolean a() {
        return this.c;
    }

    public final boolean b() {
        return this.b == DataState.NULL;
    }

    public final boolean c() {
        return this.b == DataState.EMPTY;
    }

    public final boolean d() {
        return this.d != null;
    }

    public final boolean e() {
        return this.b == DataState.FILLED;
    }

    public final void f() {
        this.c = true;
    }

    protected final boolean g() {
        return Thread.currentThread() == this.d;
    }

    private final boolean n() {
        if (a || this.b == DataState.NULL) {
            boolean z = false;
            try {
                z = j();
            } catch (Error e) {
                e.printStackTrace();
            }
            if (z) {
                this.b = DataState.UNFILLED;
            }
            return z;
        }
        throw new AssertionError();
    }

    private final boolean h(e eVar) {
        if (!a && this.b != DataState.NULL) {
            throw new AssertionError();
        } else if (a || eVar.b == DataState.FILLED || eVar.b == DataState.UNFILLED) {
            boolean z = false;
            try {
                z = a(eVar);
            } catch (Error e) {
                e.printStackTrace();
            }
            if (z) {
                this.b = DataState.UNFILLED;
                eVar.b = DataState.EMPTY;
            }
            return z;
        } else {
            throw new AssertionError();
        }
    }

    private final void o() {
        if (a || this.b != DataState.EMPTY) {
            try {
                k();
            } catch (Error e) {
                e.printStackTrace();
            }
            this.b = DataState.EMPTY;
            return;
        }
        throw new AssertionError();
    }

    private final void p() {
        if (a || this.d == null) {
            this.d = Thread.currentThread();
            return;
        }
        throw new AssertionError();
    }

    private final void q() {
        if (a || this.d != null) {
            this.d = null;
            return;
        }
        throw new AssertionError();
    }

    private final void r() {
        if (a || this.b == DataState.UNFILLED) {
            try {
                l();
            } catch (Error e) {
                e.printStackTrace();
            }
            this.b = DataState.FILLED;
            return;
        }
        throw new AssertionError();
    }

    private final void s() {
        if (a || this.b == DataState.UNFILLED) {
            try {
                m();
            } catch (Error e) {
                e.printStackTrace();
            }
            this.b = DataState.EMPTY;
            return;
        }
        throw new AssertionError();
    }
}
