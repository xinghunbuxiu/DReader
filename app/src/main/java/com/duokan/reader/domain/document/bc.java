package com.duokan.reader.domain.document;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public abstract class bc {
    /* renamed from: g */
    static final /* synthetic */ boolean f4242g = (!bc.class.desiredAssertionStatus());
    /* renamed from: a */
    public boolean f4243a = true;
    /* renamed from: b */
    public boolean f4244b = false;
    /* renamed from: c */
    public boolean f4245c = false;
    /* renamed from: d */
    protected C0919l f4246d = null;
    /* renamed from: e */
    protected final C0917k f4247e;
    /* renamed from: f */
    protected final Semaphore f4248f;
    /* renamed from: h */
    private long f4249h = -1;
    /* renamed from: i */
    private LinkedList<bd> f4250i = new LinkedList();
    /* renamed from: j */
    private final ConcurrentLinkedQueue<Object> f4251j = new ConcurrentLinkedQueue();

    /* renamed from: c */
    public abstract boolean mo1272c();

    public bc(C0919l c0919l, C0917k c0917k, Semaphore semaphore) {
        this.f4246d = c0919l;
        this.f4247e = c0917k;
        this.f4248f = semaphore;
    }

    /* renamed from: a */
    public boolean m5837a() {
        return this.f4251j.isEmpty();
    }

    /* renamed from: a */
    public boolean m5838a(Object obj) {
        return this.f4251j.contains(obj);
    }

    /* renamed from: b */
    public long m5839b() {
        return this.f4249h;
    }

    /* renamed from: a */
    public void m5835a(long j) {
        if (this.f4249h != j) {
            long j2 = this.f4249h;
            this.f4249h = j;
            synchronized (this.f4250i) {
                Iterator it = this.f4250i.iterator();
                while (it.hasNext()) {
                    ((bd) it.next()).mo1295a(this, j2, this.f4249h);
                }
            }
        }
    }

    /* renamed from: d */
    public boolean m5844d() {
        return this.f4247e.f4334e;
    }

    /* renamed from: a */
    public void m5836a(bd bdVar) {
        if (f4242g || bdVar != null) {
            synchronized (this.f4250i) {
                this.f4250i.add(bdVar);
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public void m5840b(bd bdVar) {
        if (f4242g || bdVar != null) {
            synchronized (this.f4250i) {
                this.f4250i.remove(bdVar);
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public void m5841b(Object obj) {
        this.f4251j.add(obj);
        this.f4248f.release();
    }

    /* renamed from: c */
    public void m5842c(Object obj) {
        this.f4251j.remove(obj);
        this.f4248f.release();
    }
}
