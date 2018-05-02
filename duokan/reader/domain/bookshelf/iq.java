package com.duokan.reader.domain.bookshelf;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class iq implements Future {
    final /* synthetic */ hi a;
    private boolean b = false;

    protected iq(hi hiVar) {
        this.a = hiVar;
    }

    public /* synthetic */ Object get() {
        return a();
    }

    public /* synthetic */ Object get(long j, TimeUnit timeUnit) {
        return a(j, timeUnit);
    }

    public boolean cancel(boolean z) {
        this.b = true;
        return true;
    }

    public boolean isCancelled() {
        return this.b;
    }

    public boolean isDone() {
        throw new UnsupportedOperationException();
    }

    public Void a() {
        throw new UnsupportedOperationException();
    }

    public Void a(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }
}
