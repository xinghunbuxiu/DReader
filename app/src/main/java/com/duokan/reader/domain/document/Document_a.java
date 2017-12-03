package com.duokan.reader.domain.document;

public abstract class Document_a {
    public abstract boolean a();

    public abstract boolean a(long j);

    public abstract boolean a(Document_a aVar);

    public abstract boolean c();

    public abstract boolean c(Document_a aVar);

    public abstract boolean d();

    public abstract boolean e();

    public final boolean b() {
        return !c();
    }

    public boolean b(Document_a aVar) {
        return a(aVar) || equals(aVar);
    }

    public boolean d(Document_a aVar) {
        return c(aVar) || equals(aVar);
    }
}
