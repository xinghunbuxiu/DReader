package com.duokan.reader.domain.bookshelf;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ik implements Future<Void> {
    /* renamed from: a */
    final /* synthetic */ hc f3352a;
    /* renamed from: b */
    private boolean f3353b = false;

    protected ik(hc hcVar) {
        this.f3352a = hcVar;
    }

    public /* synthetic */ Object get() {
        return m4674a();
    }

    public /* synthetic */ Object get(long j, TimeUnit timeUnit) {
        return m4675a(j, timeUnit);
    }

    public boolean cancel(boolean z) {
        this.f3353b = true;
        return true;
    }

    public boolean isCancelled() {
        return this.f3353b;
    }

    public boolean isDone() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public Void m4674a() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public Void m4675a(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }
}
