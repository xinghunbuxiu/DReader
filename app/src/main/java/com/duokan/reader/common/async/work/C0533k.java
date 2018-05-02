package com.duokan.reader.common.async.work;

import android.content.Context;
import com.duokan.core.p029c.C0326b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.duokan.reader.common.async.work.k */
public abstract class C0533k<TItem extends C0523c, TWork extends C0520o<TItem>> {
    /* renamed from: a */
    private final Context f1782a;
    /* renamed from: b */
    private final C0529q<TItem> f1783b;
    /* renamed from: c */
    private final ThreadPoolExecutor f1784c;
    /* renamed from: d */
    private boolean f1785d;
    /* renamed from: e */
    private final ArrayList<TItem> f1786e = new ArrayList();
    /* renamed from: f */
    private final ArrayList<TWork> f1787f = new ArrayList();
    /* renamed from: g */
    private final List<IAsyncWorkProgressListener<TItem>> f1788g = new LinkedList();
    /* renamed from: h */
    private final List<C0537r> f1789h = new LinkedList();
    /* renamed from: i */
    private final IAsyncWorkProgressListener<TItem> f1790i = new C0534l(this);
    /* renamed from: j */
    private boolean f1791j = false;

    /* renamed from: e */
    protected abstract TWork mo1478e(TItem tItem);

    public C0533k(Context context, C0529q<TItem> c0529q, ThreadPoolExecutor threadPoolExecutor) {
        this.f1782a = context.getApplicationContext();
        this.f1783b = c0529q;
        this.f1784c = threadPoolExecutor;
        this.f1785d = false;
        this.f1791j = false;
        m2372e();
    }

    /* renamed from: a */
    public final Context m2354a() {
        return this.f1782a;
    }

    /* renamed from: b */
    public final C0529q<TItem> m2363b() {
        return this.f1783b;
    }

    /* renamed from: a */
    public final void m2357a(IAsyncWorkProgressListener<TItem> iAsyncWorkProgressListener) {
        Object obj = null;
        if (iAsyncWorkProgressListener != null) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (!this.f1791j) {
                    if (!this.f1788g.contains(iAsyncWorkProgressListener)) {
                        obj = 1;
                        this.f1788g.add(iAsyncWorkProgressListener);
                    }
                    arrayList.addAll(this.f1787f);
                }
            }
            if (obj != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((C0520o) it.next()).mo735b(iAsyncWorkProgressListener);
                }
            }
        }
    }

    /* renamed from: b */
    public final void m2364b(IAsyncWorkProgressListener<TItem> iAsyncWorkProgressListener) {
        synchronized (this) {
            if (!(this.f1791j || iAsyncWorkProgressListener == null)) {
                this.f1788g.remove(iAsyncWorkProgressListener);
            }
        }
    }

    /* renamed from: a */
    public final void m2359a(TItem tItem, IAsyncWorkProgressListener<TItem> iAsyncWorkProgressListener) {
        C0520o c0520o = null;
        synchronized (this) {
            if (!this.f1791j) {
                c0520o = m2353f((C0523c) tItem);
            }
        }
        if (c0520o != null) {
            c0520o.mo731a((IAsyncWorkProgressListener) iAsyncWorkProgressListener);
        }
    }

    /* renamed from: b */
    public final void m2365b(TItem tItem, IAsyncWorkProgressListener<TItem> iAsyncWorkProgressListener) {
        C0520o c0520o = null;
        synchronized (this) {
            if (!this.f1791j) {
                c0520o = m2353f((C0523c) tItem);
            }
        }
        if (c0520o != null) {
            c0520o.mo737c(iAsyncWorkProgressListener);
        }
    }

    /* renamed from: a */
    public final void m2361a(C0537r c0537r) {
        Object obj = null;
        if (c0537r != null) {
            synchronized (this) {
                if (!(this.f1791j || this.f1789h.contains(c0537r))) {
                    obj = 1;
                    this.f1789h.add(c0537r);
                }
            }
            if (obj != null) {
                c0537r.mo948a();
            }
        }
    }

    /* renamed from: b */
    public final void m2366b(C0537r c0537r) {
        synchronized (this) {
            if (!(this.f1791j || c0537r == null)) {
                this.f1789h.remove(c0537r);
            }
        }
    }

    /* renamed from: c */
    public final ArrayList<TItem> m2368c() {
        ArrayList<TItem> arrayList;
        synchronized (this) {
            if (this.f1791j) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(this.f1786e);
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public final ArrayList<TItem> m2369d() {
        synchronized (this) {
            if (this.f1791j) {
                ArrayList<TItem> arrayList = new ArrayList();
                return arrayList;
            }
            ArrayList<TItem> arrayList2 = new ArrayList();
            Iterator it = this.f1786e.iterator();
            while (it.hasNext()) {
                C0523c c0523c = (C0523c) it.next();
                if (c0523c.m2300o()) {
                    arrayList2.add(c0523c);
                }
            }
            return arrayList2;
        }
    }

    /* renamed from: a */
    public final TItem m2356a(String str) {
        TItem tItem;
        synchronized (this) {
            if (this.f1791j) {
                tItem = null;
            } else {
                tItem = m2355a(new C0535m(this, str));
            }
        }
        return tItem;
    }

    /* renamed from: a */
    public final TItem m2355a(C0326b<TItem> c0326b) {
        TItem tItem;
        synchronized (this) {
            if (!this.f1791j) {
                Iterator it = this.f1786e.iterator();
                while (it.hasNext()) {
                    tItem = (C0523c) it.next();
                    if (c0326b.mo411a(tItem)) {
                        break;
                    }
                }
            }
            tItem = null;
        }
        return tItem;
    }

    /* renamed from: a */
    public final void m2358a(TItem tItem) {
        Object obj = null;
        synchronized (this) {
            if (!this.f1791j) {
                tItem.m2307v();
                if (this.f1786e.contains(tItem)) {
                    obj = 1;
                }
            }
        }
        if (obj != null) {
            this.f1783b.mo741b(tItem);
        }
    }

    /* renamed from: e */
    public final void m2372e() {
        Object obj = null;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            if (!(this.f1791j || this.f1785d)) {
                this.f1786e.clear();
                this.f1786e.addAll(this.f1783b.mo742c());
                this.f1787f.clear();
                Iterator it = this.f1786e.iterator();
                while (it.hasNext()) {
                    C0523c c0523c = (C0523c) it.next();
                    if (c0523c.m2300o()) {
                        c0523c.m2284a(false);
                    }
                    this.f1787f.add(mo1478e(c0523c));
                }
                arrayList.addAll(this.f1787f);
                this.f1785d = true;
                obj = 1;
            }
        }
        if (obj != null) {
            m2374g();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((C0520o) it2.next()).mo731a(this.f1790i);
            }
        }
    }

    /* renamed from: b */
    public final TItem m2362b(TItem tItem) {
        Object obj = null;
        synchronized (this) {
            C0520o c0520o;
            if (this.f1791j) {
                c0520o = null;
            } else {
                TItem a = m2356a(tItem.m2285b());
                if (a == null) {
                    this.f1786e.add(tItem);
                    c0520o = mo1478e((C0523c) tItem);
                    this.f1787f.add(c0520o);
                } else {
                    obj = 1;
                    c0520o = m2353f((C0523c) a);
                    tItem = a;
                }
            }
        }
        if (c0520o != null && obj == null) {
            tItem.m2307v();
            this.f1783b.mo739a(tItem);
            m2374g();
            c0520o.mo731a(this.f1790i);
        }
        return tItem;
    }

    /* renamed from: c */
    public TItem m2367c(TItem tItem) {
        Object obj = null;
        synchronized (this) {
            C0520o c0520o;
            if (this.f1791j) {
                c0520o = null;
            } else {
                TItem a = m2356a(tItem.m2285b());
                if (a == null) {
                    this.f1786e.add(tItem);
                    c0520o = mo1478e((C0523c) tItem);
                    this.f1787f.add(c0520o);
                } else {
                    obj = 1;
                    c0520o = m2353f((C0523c) a);
                    tItem = a;
                }
            }
        }
        if (c0520o != null) {
            if (obj == null) {
                tItem.m2307v();
                this.f1783b.mo739a(tItem);
                m2374g();
                c0520o.mo731a(this.f1790i);
            }
            c0520o.mo732a(this.f1784c);
        }
        return tItem;
    }

    /* renamed from: a */
    public final void m2360a(TItem tItem, boolean z) {
        C0520o c0520o;
        synchronized (this) {
            if (this.f1791j) {
                c0520o = null;
            } else {
                c0520o = m2353f((C0523c) tItem);
            }
        }
        if (c0520o != null) {
            c0520o.mo733a(z);
        }
    }

    /* renamed from: d */
    public final void m2370d(TItem tItem) {
        C0520o c0520o;
        synchronized (this) {
            if (this.f1791j) {
                c0520o = null;
            } else {
                c0520o = m2353f((C0523c) tItem);
            }
        }
        if (c0520o != null) {
            c0520o.mo736c();
        }
    }

    /* renamed from: f */
    public final void m2373f() {
        if (!this.f1791j) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                arrayList.addAll(this.f1787f);
                this.f1791j = true;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((C0520o) it.next()).mo736c();
            }
            this.f1788g.clear();
            this.f1789h.clear();
            this.f1786e.clear();
            this.f1787f.clear();
            this.f1783b.mo740b();
        }
    }

    /* renamed from: g */
    protected void m2374g() {
        List<C0537r> linkedList = new LinkedList();
        synchronized (this) {
            linkedList.addAll(this.f1789h);
        }
        for (C0537r a : linkedList) {
            a.mo948a();
        }
    }

    /* renamed from: f */
    private TWork m2353f(TItem tItem) {
        Iterator it = this.f1787f.iterator();
        while (it.hasNext()) {
            C0520o c0520o = (C0520o) it.next();
            if (c0520o.mo734b().m2285b().equals(tItem.m2285b())) {
                return c0520o;
            }
        }
        return null;
    }
}
