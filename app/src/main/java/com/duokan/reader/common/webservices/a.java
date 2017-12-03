package com.duokan.reader.common.webservices;

public abstract class a extends WebSession {
    public a() {
        super(false);
    }

    protected a(String str) {
        super(str);
    }

    protected a(boolean z) {
        super(z);
    }

    public void open() {
        open(CacheStrategy.USE_CACHE_IF_FRESH);
    }

    public void open(long j) {
        open(CacheStrategy.USE_CACHE_IF_FRESH, j);
    }
}
