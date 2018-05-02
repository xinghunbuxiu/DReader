package com.duokan.reader.domain.document;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public abstract class bc {
    static final /* synthetic */ boolean g = (!bc.class.desiredAssertionStatus());
    public boolean a = true;
    public boolean b = false;
    public boolean c = false;
    protected l d = null;
    protected final k e;
    protected final Semaphore f;
    private long h = -1;
    private LinkedList i = new LinkedList();
    private final ConcurrentLinkedQueue j = new ConcurrentLinkedQueue();

    public abstract boolean c();

    public bc(l lVar, k kVar, Semaphore semaphore) {
        this.d = lVar;
        this.e = kVar;
        this.f = semaphore;
    }

    public boolean a() {
        return this.j.isEmpty();
    }

    public boolean a(Object obj) {
        return this.j.contains(obj);
    }

    public long b() {
        return this.h;
    }

    public void a(long j) {
        if (this.h != j) {
            long j2 = this.h;
            this.h = j;
            synchronized (this.i) {
                Iterator it = this.i.iterator();
                while (it.hasNext()) {
                    ((bd) it.next()).a(this, j2, this.h);
                }
            }
        }
    }

    public boolean d() {
        return this.e.e;
    }

    public void a(bd bdVar) {
        if (g || bdVar != null) {
            synchronized (this.i) {
                this.i.add(bdVar);
            }
            return;
        }
        throw new AssertionError();
    }

    public void b(bd bdVar) {
        if (g || bdVar != null) {
            synchronized (this.i) {
                this.i.remove(bdVar);
            }
            return;
        }
        throw new AssertionError();
    }

    public void b(Object obj) {
        this.j.add(obj);
        this.f.release();
    }

    public void c(Object obj) {
        this.j.remove(obj);
        this.f.release();
    }
}
