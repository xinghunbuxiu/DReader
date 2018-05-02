package com.duokan.reader.common.webservices;

public abstract class OpenWebSession extends WebSession {
    public OpenWebSession() {
        super(false);
    }

    protected OpenWebSession(String str) {
        super(str);
    }

    protected OpenWebSession(boolean z) {
        super(z);
    }

    public void open() {
        open(CacheStrategy.USE_CACHE_IF_FRESH);
    }

    public void open(long j) {
        open(CacheStrategy.USE_CACHE_IF_FRESH, j);
    }
}
