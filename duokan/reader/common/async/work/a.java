package com.duokan.reader.common.async.work;

import android.content.Context;

import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class a implements o {
    private final Context a;
    private final q b;
    private final c c;
    private Thread d;
    private final List e = new LinkedList();
    private Runnable f;
    private ThreadPoolExecutor g;

    protected abstract e a(int i);

    public static CheckErrorResult a(CheckErrorResult checkErrorResult, CheckErrorResult checkErrorResult2) {
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

    public a(Context context, c cVar, q qVar) {
        this.a = context.getApplicationContext();
        this.c = cVar;
        this.b = qVar;
    }

    protected void a(String str) {
        this.c.a(str);
        j();
    }

    public Context a() {
        return this.a;
    }

    public c b() {
        return this.c;
    }

    public void a(IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        Object obj = null;
        synchronized (this) {
            if (iAsyncWorkProgressListener != null) {
                if (!this.e.contains(iAsyncWorkProgressListener)) {
                    this.e.add(iAsyncWorkProgressListener);
                    obj = 1;
                }
            }
        }
        if (obj != null) {
            b(iAsyncWorkProgressListener);
        }
    }

    public void b(IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        if (iAsyncWorkProgressListener != null) {
            int f = this.c.f();
            if (f == 1) {
                iAsyncWorkProgressListener.a(this.c);
                iAsyncWorkProgressListener.c(this.c);
            } else if (f == 2) {
                iAsyncWorkProgressListener.b(this.c);
                iAsyncWorkProgressListener.c(this.c);
            } else if (f == 4 || f == 3) {
                iAsyncWorkProgressListener.c(this.c);
                iAsyncWorkProgressListener.d(this.c);
            } else if (f == 7) {
                iAsyncWorkProgressListener.f(this.c);
            } else if (f == 6) {
                iAsyncWorkProgressListener.g(this.c);
            } else if (f == 5) {
                iAsyncWorkProgressListener.e(this.c);
            }
        }
    }

    public void c(IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        synchronized (this) {
            if (iAsyncWorkProgressListener != null) {
                this.e.remove(iAsyncWorkProgressListener);
            }
        }
    }

    public final void a(ThreadPoolExecutor threadPoolExecutor) {
        Object obj;
        synchronized (this) {
            if (this.c.p()) {
                obj = 1;
                if (this.f == null) {
                    this.f = new b(this);
                    this.g = threadPoolExecutor;
                    this.g.execute(this.f);
                }
            } else {
                obj = null;
            }
        }
        if (obj != null) {
            j();
            d();
        }
    }

    protected void a(long j, long j2) {
        this.c.a(j, j2);
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.e);
        }
        for (IAsyncWorkProgressListener c : linkedList) {
            c.c(b());
        }
    }

    public void a(boolean z) {
        Object obj = 1;
        Object obj2 = null;
        synchronized (this) {
            boolean j = this.c.j();
            if (this.c.a(z)) {
                if (this.d != null) {
                    this.d.interrupt();
                }
                if (!j) {
                    obj2 = 1;
                }
            } else {
                obj = null;
            }
        }
        if (obj != null) {
            j();
        }
        if (obj2 != null) {
            f();
        }
    }

    public void c() {
        Object obj = 1;
        Object obj2 = null;
        synchronized (this) {
            if (this.c.n() || !this.c.r()) {
                obj = null;
            } else {
                if (this.d != null) {
                    this.d.interrupt();
                }
                obj2 = 1;
            }
        }
        if (obj != null) {
            j();
        }
        if (obj2 != null) {
            h();
        }
    }

    protected void d() {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.e);
        }
        for (IAsyncWorkProgressListener a : linkedList) {
            a.a(b());
        }
    }

    protected void e() {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.e);
        }
        for (IAsyncWorkProgressListener b : linkedList) {
            b.b(b());
        }
    }

    protected void f() {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.e);
        }
        for (IAsyncWorkProgressListener d : linkedList) {
            d.d(b());
        }
    }

    protected void g() {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.e);
        }
        for (IAsyncWorkProgressListener e : linkedList) {
            e.e(b());
        }
    }

    protected void h() {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.e);
        }
        for (IAsyncWorkProgressListener f : linkedList) {
            f.f(b());
        }
    }

    protected CheckErrorResult a(e eVar) {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.e);
        }
        CheckErrorResult checkErrorResult = CheckErrorResult.Ignored;
        CheckErrorResult checkErrorResult2 = checkErrorResult;
        for (IAsyncWorkProgressListener a : linkedList) {
            checkErrorResult2 = a(checkErrorResult2, a.a(b(), eVar));
        }
        return checkErrorResult2;
    }

    protected void i() {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.e);
        }
        for (IAsyncWorkProgressListener g : linkedList) {
            g.g(b());
        }
    }

    protected int b(e eVar) {
        return 6;
    }

    protected void j() {
        this.c.v();
        this.b.b(this.c);
    }
}
