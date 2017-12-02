package com.duokan.reader.common.async.work;

import android.content.Context;

import com.duokan.core.c.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class k {
    private final Context a;
    private final q b;
    private final ThreadPoolExecutor c;
    private boolean d;
    private final ArrayList e = new ArrayList();
    private final ArrayList f = new ArrayList();
    private final List g = new LinkedList();
    private final List h = new LinkedList();
    private final IAsyncWorkProgressListener i = new l(this);
    private boolean j = false;

    protected abstract o e(c cVar);

    public k(Context context, q qVar, ThreadPoolExecutor threadPoolExecutor) {
        this.a = context.getApplicationContext();
        this.b = qVar;
        this.c = threadPoolExecutor;
        this.d = false;
        this.j = false;
        f();
    }

    public final Context a() {
        return this.a;
    }

    public final q b() {
        return this.b;
    }

    public final void a(IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        Object obj = null;
        if (iAsyncWorkProgressListener != null) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (!this.j) {
                    if (!this.g.contains(iAsyncWorkProgressListener)) {
                        obj = 1;
                        this.g.add(iAsyncWorkProgressListener);
                    }
                    arrayList.addAll(this.f);
                }
            }
            if (obj != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((o) it.next()).b(iAsyncWorkProgressListener);
                }
            }
        }
    }

    public final void b(IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        synchronized (this) {
            if (!(this.j || iAsyncWorkProgressListener == null)) {
                this.g.remove(iAsyncWorkProgressListener);
            }
        }
    }

    public final void a(c cVar, IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        o oVar = null;
        synchronized (this) {
            if (!this.j) {
                oVar = f(cVar);
            }
        }
        if (oVar != null) {
            oVar.a(iAsyncWorkProgressListener);
        }
    }

    public final void b(c cVar, IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        o oVar = null;
        synchronized (this) {
            if (!this.j) {
                oVar = f(cVar);
            }
        }
        if (oVar != null) {
            oVar.c(iAsyncWorkProgressListener);
        }
    }

    public final void a(r rVar) {
        Object obj = null;
        if (rVar != null) {
            synchronized (this) {
                if (!(this.j || this.h.contains(rVar))) {
                    obj = 1;
                    this.h.add(rVar);
                }
            }
            if (obj != null) {
                rVar.a();
            }
        }
    }

    public final void b(r rVar) {
        synchronized (this) {
            if (!(this.j || rVar == null)) {
                this.h.remove(rVar);
            }
        }
    }

    public final boolean c() {
        boolean z = false;
        synchronized (this) {
            if (this.j) {
            } else {
                if (this.e.size() > 0) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final ArrayList d() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.j) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(this.e);
            }
        }
        return arrayList;
    }

    public final ArrayList e() {
        synchronized (this) {
            if (this.j) {
                ArrayList arrayList = new ArrayList();
                return arrayList;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.o()) {
                    arrayList2.add(cVar);
                }
            }
            return arrayList2;
        }
    }

    public final c a(String str) {
        c cVar;
        synchronized (this) {
            if (this.j) {
                cVar = null;
            } else {
                cVar = a(new m(this, str));
            }
        }
        return cVar;
    }

    public final c a(b bVar) {
        c cVar;
        synchronized (this) {
            if (!this.j) {
                Iterator it = this.e.iterator();
                while (it.hasNext()) {
                    cVar = (c) it.next();
                    if (bVar.a(cVar)) {
                        break;
                    }
                }
            }
            cVar = null;
        }
        return cVar;
    }

    public final void a(c cVar) {
        Object obj = null;
        synchronized (this) {
            if (!this.j) {
                cVar.v();
                if (this.e.contains(cVar)) {
                    obj = 1;
                }
            }
        }
        if (obj != null) {
            this.b.b(cVar);
        }
    }

    public final void f() {
        Object obj = null;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            if (!(this.j || this.d)) {
                this.e.clear();
                this.e.addAll(this.b.c());
                this.f.clear();
                Iterator it = this.e.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.o()) {
                        cVar.a(false);
                    }
                    this.f.add(e(cVar));
                }
                arrayList.addAll(this.f);
                this.d = true;
                obj = 1;
            }
        }
        if (obj != null) {
            h();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((o) it2.next()).a(this.i);
            }
        }
    }

    public final c b(c cVar) {
        Object obj = null;
        synchronized (this) {
            o oVar;
            if (this.j) {
                oVar = null;
            } else {
                c a = a(cVar.b());
                if (a == null) {
                    this.e.add(cVar);
                    oVar = e(cVar);
                    this.f.add(oVar);
                } else {
                    obj = 1;
                    oVar = f(a);
                    cVar = a;
                }
            }
        }
        if (oVar != null && r0 == null) {
            cVar.v();
            this.b.a(cVar);
            h();
            oVar.a(this.i);
        }
        return cVar;
    }

    public c c(c cVar) {
        Object obj = null;
        synchronized (this) {
            o oVar;
            if (this.j) {
                oVar = null;
            } else {
                c a = a(cVar.b());
                if (a == null) {
                    this.e.add(cVar);
                    oVar = e(cVar);
                    this.f.add(oVar);
                } else {
                    obj = 1;
                    oVar = f(a);
                    cVar = a;
                }
            }
        }
        if (oVar != null) {
            if (obj == null) {
                cVar.v();
                this.b.a(cVar);
                h();
                oVar.a(this.i);
            }
            oVar.a(this.c);
        }
        return cVar;
    }

    public final void a(c cVar, boolean z) {
        o oVar;
        synchronized (this) {
            if (this.j) {
                oVar = null;
            } else {
                oVar = f(cVar);
            }
        }
        if (oVar != null) {
            oVar.a(z);
        }
    }

    public final void d(c cVar) {
        o oVar;
        synchronized (this) {
            if (this.j) {
                oVar = null;
            } else {
                oVar = f(cVar);
            }
        }
        if (oVar != null) {
            oVar.c();
        }
    }

    public final void g() {
        if (!this.j) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                arrayList.addAll(this.f);
                this.j = true;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((o) it.next()).c();
            }
            this.g.clear();
            this.h.clear();
            this.e.clear();
            this.f.clear();
            this.b.b();
        }
    }

    protected void h() {
        List<r> linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.h);
        }
        for (r a : linkedList) {
            a.a();
        }
    }

    private o f(c cVar) {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (oVar.b().b().equals(cVar.b())) {
                return oVar;
            }
        }
        return null;
    }
}
