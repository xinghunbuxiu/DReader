package com.duokan.reader.common.async.work;

import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.duokan.reader.common.async.work.l */
class C0534l implements IAsyncWorkProgressListener<TItem> {
    /* renamed from: a */
    final /* synthetic */ C0533k f1792a;

    C0534l(C0533k c0533k) {
        this.f1792a = c0533k;
    }

    /* renamed from: a */
    public void mo745a(TItem tItem) {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this.f1792a) {
            if (!this.f1792a.f1791j) {
                linkedList.addAll(this.f1792a.f1788g);
            }
        }
        for (IAsyncWorkProgressListener a : linkedList) {
            a.mo745a(tItem);
        }
    }

    /* renamed from: b */
    public void mo746b(TItem tItem) {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this.f1792a) {
            if (!this.f1792a.f1791j) {
                linkedList.addAll(this.f1792a.f1788g);
            }
        }
        for (IAsyncWorkProgressListener b : linkedList) {
            b.mo746b(tItem);
        }
    }

    /* renamed from: c */
    public void mo747c(TItem tItem) {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this.f1792a) {
            if (!this.f1792a.f1791j) {
                linkedList.addAll(this.f1792a.f1788g);
            }
        }
        for (IAsyncWorkProgressListener c : linkedList) {
            c.mo747c(tItem);
        }
    }

    /* renamed from: d */
    public void mo748d(TItem tItem) {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this.f1792a) {
            if (!this.f1792a.f1791j) {
                linkedList.addAll(this.f1792a.f1788g);
            }
        }
        for (IAsyncWorkProgressListener d : linkedList) {
            d.mo748d(tItem);
        }
    }

    /* renamed from: e */
    public void mo749e(TItem tItem) {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this.f1792a) {
            if (!this.f1792a.f1791j) {
                linkedList.addAll(this.f1792a.f1788g);
            }
        }
        for (IAsyncWorkProgressListener e : linkedList) {
            e.mo749e(tItem);
        }
        synchronized (this.f1792a) {
            C0520o c0520o;
            if (this.f1792a.f1791j) {
                c0520o = null;
            } else {
                c0520o = this.f1792a.m2353f((C0523c) tItem);
                if (c0520o != null) {
                    this.f1792a.f1786e.remove(tItem);
                    this.f1792a.f1787f.remove(c0520o);
                }
            }
        }
        if (c0520o != null) {
            this.f1792a.f1783b.mo743c(tItem);
            c0520o.mo737c(this.f1792a.f1790i);
            this.f1792a.m2374g();
        }
    }

    /* renamed from: f */
    public void mo750f(TItem tItem) {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this.f1792a) {
            if (!this.f1792a.f1791j) {
                linkedList.addAll(this.f1792a.f1788g);
            }
        }
        for (IAsyncWorkProgressListener f : linkedList) {
            f.mo750f(tItem);
        }
        synchronized (this.f1792a) {
            C0520o c0520o;
            if (this.f1792a.f1791j) {
                c0520o = null;
            } else {
                c0520o = this.f1792a.m2353f((C0523c) tItem);
                if (c0520o != null) {
                    this.f1792a.f1786e.remove(tItem);
                    this.f1792a.f1787f.remove(c0520o);
                }
            }
        }
        if (c0520o != null) {
            this.f1792a.f1783b.mo743c(tItem);
            c0520o.mo737c(this.f1792a.f1790i);
            this.f1792a.m2374g();
        }
    }

    /* renamed from: a */
    public CheckErrorResult mo744a(TItem tItem, C0525e c0525e) {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this.f1792a) {
            if (!this.f1792a.f1791j) {
                linkedList.addAll(this.f1792a.f1788g);
            }
        }
        CheckErrorResult checkErrorResult = CheckErrorResult.Ignored;
        CheckErrorResult checkErrorResult2 = checkErrorResult;
        for (IAsyncWorkProgressListener a : linkedList) {
            checkErrorResult2 = C0521a.m2253a(checkErrorResult2, a.mo744a(tItem, c0525e));
        }
        return checkErrorResult2;
    }

    /* renamed from: g */
    public void mo751g(TItem tItem) {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this.f1792a) {
            if (!this.f1792a.f1791j) {
                linkedList.addAll(this.f1792a.f1788g);
            }
        }
        for (IAsyncWorkProgressListener g : linkedList) {
            g.mo751g(tItem);
        }
    }
}
