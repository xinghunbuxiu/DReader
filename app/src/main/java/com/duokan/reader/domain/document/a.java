package com.duokan.reader.domain.document;

public abstract class a {
    public abstract boolean a();

    public abstract boolean a(long j);

    public abstract boolean a(a aVar);

    public abstract boolean c();

    public abstract boolean c(a aVar);

    public abstract boolean d();

    public abstract boolean e();

    public final boolean b() {
        return !c();
    }

    public boolean b(a aVar) {
        return a(aVar) || equals(aVar);
    }

    public boolean d(a aVar) {
        return c(aVar) || equals(aVar);
    }
}
